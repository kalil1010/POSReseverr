package org.apache.commons.p006io.input;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class AutoCloseInputStream extends ProxyInputStream {
    public AutoCloseInputStream(InputStream in) {
        super(in);
    }

    @Override // org.apache.commons.p006io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
        this.in = new ClosedInputStream();
    }

    @Override // org.apache.commons.p006io.input.ProxyInputStream
    protected void afterRead(int n) throws IOException {
        if (n == -1) {
            close();
        }
    }

    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
