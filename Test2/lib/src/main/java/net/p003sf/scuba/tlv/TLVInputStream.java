package net.p003sf.scuba.tlv;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class TLVInputStream extends InputStream {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");
    private static final int MAX_BUFFER_LENGTH = 65535;
    private int bufferSize;
    private DataInputStream inputStream;
    private TLVInputState markedState;
    private final InputStream originalInputStream;
    private TLVInputState state;

    public TLVInputStream(InputStream inputStream) {
        this.bufferSize = 0;
        try {
            if ((inputStream instanceof BufferedInputStream) || (inputStream instanceof ByteArrayInputStream)) {
                this.bufferSize = inputStream.available();
            }
        } catch (IOException ioe) {
            LOGGER.log(Level.WARNING, "Exception reading from stream", (Throwable) ioe);
        }
        this.originalInputStream = inputStream;
        this.inputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        this.state = new TLVInputState();
        this.markedState = null;
    }

    public int readTag() throws IOException {
        int tag;
        if (!this.state.isAtStartOfTag() && !this.state.isProcessingValue()) {
            throw new IllegalStateException("Not at start of tag");
        }
        try {
            int b = this.inputStream.readUnsignedByte();
            int bytesRead = 0 + 1;
            while (true) {
                if (b != 0 && b != 255) {
                    break;
                }
                b = this.inputStream.readUnsignedByte();
                bytesRead++;
            }
            if ((b & 31) == 31) {
                int tag2 = b;
                int b2 = this.inputStream.readUnsignedByte();
                bytesRead++;
                while ((b2 & 128) == 128) {
                    tag2 = (tag2 << 8) | (b2 & 127);
                    b2 = this.inputStream.readUnsignedByte();
                    bytesRead++;
                }
                tag = (tag2 << 8) | (b2 & 127);
            } else {
                tag = b;
            }
            this.state.setTagProcessed(tag, bytesRead);
            return tag;
        } catch (IOException e) {
            throw e;
        }
    }

    public int readLength() throws IOException {
        int length;
        try {
            if (!this.state.isAtStartOfLength()) {
                throw new IllegalStateException("Not at start of length");
            }
            int b = this.inputStream.readUnsignedByte();
            int bytesRead = 0 + 1;
            if ((b & 128) == 0) {
                length = b;
            } else {
                int count = b & 127;
                length = 0;
                for (int i = 0; i < count; i++) {
                    bytesRead++;
                    length = (length << 8) | this.inputStream.readUnsignedByte();
                }
            }
            this.state.setLengthProcessed(length, bytesRead);
            return length;
        } catch (IOException e) {
            throw e;
        }
    }

    public byte[] readValue() throws IOException {
        try {
            if (!this.state.isProcessingValue()) {
                throw new IllegalStateException("Not yet processing value!");
            }
            int length = this.state.getLength();
            byte[] value = new byte[length];
            this.inputStream.readFully(value);
            this.state.updateValueBytesProcessed(length);
            return value;
        } catch (IOException e) {
            throw e;
        }
    }

    private long skipValue() throws IOException {
        if (this.state.isAtStartOfTag() || this.state.isAtStartOfLength()) {
            return 0L;
        }
        int bytesLeft = this.state.getValueBytesLeft();
        return skip(bytesLeft);
    }

    public void skipToTag(int searchTag) throws IOException {
        while (true) {
            if (!this.state.isAtStartOfTag()) {
                if (this.state.isAtStartOfLength()) {
                    readLength();
                    if (TLVUtil.isPrimitive(this.state.getTag())) {
                        skipValue();
                    }
                } else if (TLVUtil.isPrimitive(this.state.getTag())) {
                    skipValue();
                }
            }
            int tag = readTag();
            if (tag == searchTag) {
                return;
            }
            if (TLVUtil.isPrimitive(tag)) {
                int length = readLength();
                int skippedBytes = (int) skipValue();
                if (skippedBytes < length) {
                    return;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.inputStream.available();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int result = this.inputStream.read();
        if (result < 0) {
            return -1;
        }
        this.state.updateValueBytesProcessed(1);
        return result;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (n <= 0) {
            return 0L;
        }
        long result = this.inputStream.skip(n);
        this.state.updateValueBytesProcessed((int) result);
        return result;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int readLimit) {
        this.inputStream.mark(readLimit);
        this.markedState = new TLVInputState(this.state);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        if (!markSupported()) {
            throw new IOException("mark/reset not supported");
        }
        this.inputStream.reset();
        this.state = this.markedState;
        this.markedState = null;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inputStream.close();
    }

    public String toString() {
        return this.state.toString();
    }
}
