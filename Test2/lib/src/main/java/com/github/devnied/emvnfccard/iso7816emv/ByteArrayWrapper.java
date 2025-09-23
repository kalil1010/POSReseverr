package com.github.devnied.emvnfccard.iso7816emv;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class ByteArrayWrapper {
    private final byte[] data;
    private final int hashcode;

    private ByteArrayWrapper(byte[] data) {
        this.data = data;
        this.hashcode = Arrays.hashCode(data);
    }

    public static ByteArrayWrapper wrapperAround(byte[] data) {
        if (data == null) {
            throw null;
        }
        return new ByteArrayWrapper(data);
    }

    public boolean equals(Object other) {
        if (!(other instanceof ByteArrayWrapper)) {
            return false;
        }
        return Arrays.equals(this.data, ((ByteArrayWrapper) other).data);
    }

    public int hashCode() {
        return this.hashcode;
    }
}
