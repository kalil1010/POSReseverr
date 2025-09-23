package org.apache.commons.p006io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.p006io.TaggedIOException;

/* loaded from: classes.dex */
public class TaggedOutputStream extends ProxyOutputStream {
    private final Serializable tag;

    public TaggedOutputStream(OutputStream proxy) {
        super(proxy);
        this.tag = UUID.randomUUID();
    }

    public boolean isCauseOf(Exception exception) {
        return TaggedIOException.isTaggedWith(exception, this.tag);
    }

    public void throwIfCauseOf(Exception exception) throws IOException {
        TaggedIOException.throwCauseIfTaggedWith(exception, this.tag);
    }

    @Override // org.apache.commons.p006io.output.ProxyOutputStream
    protected void handleIOException(IOException e) throws IOException {
        throw new TaggedIOException(e, this.tag);
    }
}
