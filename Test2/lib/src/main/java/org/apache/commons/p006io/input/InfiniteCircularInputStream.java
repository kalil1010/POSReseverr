package org.apache.commons.p006io.input;

import java.io.InputStream;
import kotlin.UByte;

/* loaded from: classes.dex */
public class InfiniteCircularInputStream extends InputStream {
    private int position = -1;
    private final byte[] repeatedContent;

    public InfiniteCircularInputStream(byte[] repeatedContent) {
        this.repeatedContent = repeatedContent;
    }

    @Override // java.io.InputStream
    public int read() {
        int i = this.position + 1;
        byte[] bArr = this.repeatedContent;
        int length = i % bArr.length;
        this.position = length;
        return bArr[length] & UByte.MAX_VALUE;
    }
}
