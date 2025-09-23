package net.p003sf.scuba.tlv;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class TLVOutputStream extends OutputStream {
    private DataOutputStream outputStream;
    private TLVOutputState state;

    public TLVOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream instanceof DataOutputStream ? (DataOutputStream) outputStream : new DataOutputStream(outputStream);
        this.state = new TLVOutputState();
    }

    public void writeTag(int tag) throws IOException {
        byte[] tagAsBytes = TLVUtil.getTagAsBytes(tag);
        if (this.state.canBeWritten()) {
            this.outputStream.write(tagAsBytes);
        }
        this.state.setTagProcessed(tag);
    }

    public void writeLength(int length) throws IOException {
        byte[] lengthAsBytes = TLVUtil.getLengthAsBytes(length);
        this.state.setLengthProcessed(length);
        if (this.state.canBeWritten()) {
            this.outputStream.write(lengthAsBytes);
        }
    }

    public void writeValue(byte[] value) throws IOException {
        if (value == null) {
            throw new IllegalArgumentException("Cannot write null.");
        }
        if (this.state.isAtStartOfTag()) {
            throw new IllegalStateException("Cannot write value bytes yet. Need to write a tag first.");
        }
        if (this.state.isAtStartOfLength()) {
            writeLength(value.length);
            write(value);
        } else {
            write(value);
            this.state.updatePreviousLength(value.length);
        }
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        write(new byte[]{(byte) b}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes) throws IOException {
        write(bytes, 0, bytes.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bytes, int offset, int length) throws IOException {
        if (this.state.isAtStartOfTag()) {
            throw new IllegalStateException("Cannot write value bytes yet. Need to write a tag first.");
        }
        if (this.state.isAtStartOfLength()) {
            this.state.setDummyLengthProcessed();
        }
        this.state.updateValueBytesProcessed(bytes, offset, length);
        if (this.state.canBeWritten()) {
            this.outputStream.write(bytes, offset, length);
        }
    }

    public void writeValueEnd() throws IOException {
        if (this.state.isAtStartOfLength()) {
            throw new IllegalStateException("Not processing value yet.");
        }
        if (this.state.isAtStartOfTag() && !this.state.isDummyLengthSet()) {
            return;
        }
        byte[] bufferedValueBytes = this.state.getValue();
        int length = bufferedValueBytes.length;
        this.state.updatePreviousLength(length);
        if (this.state.canBeWritten()) {
            byte[] lengthAsBytes = TLVUtil.getLengthAsBytes(length);
            this.outputStream.write(lengthAsBytes);
            this.outputStream.write(bufferedValueBytes);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.outputStream.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.state.canBeWritten()) {
            throw new IllegalStateException("Cannot close stream yet, illegal TLV state.");
        }
        this.outputStream.close();
    }
}
