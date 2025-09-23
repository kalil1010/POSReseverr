package net.p003sf.scuba.smartcards;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* loaded from: classes.dex */
public class CardFileInputStream extends InputStream {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba");
    private final byte[] buffer;
    private int bufferLength;
    private int fileLength;

    /* renamed from: fs */
    private FileSystemStructured f836fs;
    private int markedOffset;
    private int offsetBufferInFile;
    private int offsetInBuffer;
    private FileInfo[] path;

    public CardFileInputStream(int maxBlockSize, FileSystemStructured fs) throws CardServiceException {
        this.f836fs = fs;
        synchronized (fs) {
            FileInfo[] fsPath = fs.getSelectedPath();
            if (fsPath == null || fsPath.length < 1) {
                throw new CardServiceException("No valid file selected, path = " + Arrays.toString(fsPath));
            }
            FileInfo[] fileInfoArr = new FileInfo[fsPath.length];
            this.path = fileInfoArr;
            System.arraycopy(fsPath, 0, fileInfoArr, 0, fsPath.length);
            this.fileLength = fsPath[fsPath.length - 1].getFileLength();
            this.buffer = new byte[maxBlockSize];
            this.bufferLength = 0;
            this.offsetBufferInFile = 0;
            this.offsetInBuffer = 0;
            this.markedOffset = -1;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        synchronized (this.f836fs) {
            try {
                try {
                    if (!Arrays.equals(this.path, this.f836fs.getSelectedPath())) {
                        for (FileInfo fileInfo : this.path) {
                            this.f836fs.selectFile(fileInfo.getFID());
                        }
                    }
                    int offsetInFile = this.offsetBufferInFile + this.offsetInBuffer;
                    if (offsetInFile >= this.fileLength) {
                        return -1;
                    }
                    if (this.offsetInBuffer >= this.bufferLength) {
                        int le = Math.min(this.buffer.length, this.fileLength - offsetInFile);
                        try {
                            try {
                                int newOffsetBufferInFile = this.offsetBufferInFile + this.bufferLength;
                                int newBufferLength = fillBufferFromFile(this.path, newOffsetBufferInFile, le);
                                this.offsetBufferInFile = newOffsetBufferInFile;
                                this.offsetInBuffer = 0;
                                this.bufferLength = newBufferLength;
                            } catch (Exception e) {
                                throw new IOException("Unexpected exception", e);
                            }
                        } catch (CardServiceException cse) {
                            throw new IOException("Unexpected exception", cse);
                        }
                    }
                    int result = this.buffer[this.offsetInBuffer] & UByte.MAX_VALUE;
                    this.offsetInBuffer++;
                    return result;
                } catch (CardServiceException cse2) {
                    LOGGER.log(Level.WARNING, "Unexpected exception", (Throwable) cse2);
                    throw new IOException("Unexpected exception", cse2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.InputStream
    public long skip(long n) {
        synchronized (this.f836fs) {
            if (n < this.bufferLength - this.offsetInBuffer) {
                this.offsetInBuffer = (int) (this.offsetInBuffer + n);
            } else {
                int offsetInFile = this.offsetBufferInFile + this.offsetInBuffer;
                this.offsetBufferInFile = (int) (offsetInFile + n);
                this.offsetInBuffer = 0;
                this.bufferLength = 0;
            }
        }
        return n;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        return this.bufferLength - this.offsetInBuffer;
    }

    @Override // java.io.InputStream
    public void mark(int readLimit) {
        synchronized (this.f836fs) {
            this.markedOffset = this.offsetBufferInFile + this.offsetInBuffer;
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        synchronized (this.f836fs) {
            if (this.markedOffset < 0) {
                throw new IOException("Mark not set");
            }
            this.offsetBufferInFile = this.markedOffset;
            this.offsetInBuffer = 0;
            this.bufferLength = 0;
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        synchronized (this.f836fs) {
        }
        return true;
    }

    public int getLength() {
        return this.fileLength;
    }

    public int getPostion() {
        return this.offsetBufferInFile + this.offsetInBuffer;
    }

    private int fillBufferFromFile(FileInfo[] path, int offsetInFile, int le) throws CardServiceException {
        int length;
        synchronized (this.f836fs) {
            if (le > this.buffer.length) {
                throw new IllegalArgumentException("length too big");
            }
            if (!Arrays.equals(this.f836fs.getSelectedPath(), path)) {
                for (FileInfo fileInfo : path) {
                    this.f836fs.selectFile(fileInfo.getFID());
                }
            }
            byte[] data = this.f836fs.readBinary(offsetInFile, le);
            System.arraycopy(data, 0, this.buffer, 0, data.length);
            length = data.length;
        }
        return length;
    }
}
