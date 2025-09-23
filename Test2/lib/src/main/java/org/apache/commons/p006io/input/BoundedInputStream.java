package org.apache.commons.p006io.input;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class BoundedInputStream extends InputStream {

    /* renamed from: in */
    private final InputStream f861in;
    private long mark;
    private final long max;
    private long pos;
    private boolean propagateClose;

    public BoundedInputStream(InputStream in, long size) {
        this.pos = 0L;
        this.mark = -1L;
        this.propagateClose = true;
        this.max = size;
        this.f861in = in;
    }

    public BoundedInputStream(InputStream in) {
        this(in, -1L);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        long j = this.max;
        if (j >= 0 && this.pos >= j) {
            return -1;
        }
        int result = this.f861in.read();
        this.pos++;
        return result;
    }

    @Override // java.io.InputStream
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        long j = this.max;
        if (j >= 0 && this.pos >= j) {
            return -1;
        }
        long j2 = this.max;
        long maxRead = j2 >= 0 ? Math.min(len, j2 - this.pos) : len;
        int bytesRead = this.f861in.read(b, off, (int) maxRead);
        if (bytesRead == -1) {
            return -1;
        }
        this.pos += bytesRead;
        return bytesRead;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        long j = this.max;
        long toSkip = j >= 0 ? Math.min(n, j - this.pos) : n;
        long skippedBytes = this.f861in.skip(toSkip);
        this.pos += skippedBytes;
        return skippedBytes;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        long j = this.max;
        if (j >= 0 && this.pos >= j) {
            return 0;
        }
        return this.f861in.available();
    }

    public String toString() {
        return this.f861in.toString();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.propagateClose) {
            this.f861in.close();
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f861in.reset();
        this.pos = this.mark;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int readlimit) {
        this.f861in.mark(readlimit);
        this.mark = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f861in.markSupported();
    }

    public boolean isPropagateClose() {
        return this.propagateClose;
    }

    public void setPropagateClose(boolean propagateClose) {
        this.propagateClose = propagateClose;
    }
}
