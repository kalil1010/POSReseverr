package kotlin.p001io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* compiled from: Console.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m17d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.io.LineReader, reason: use source file name */
/* loaded from: classes.dex */
public final class Console2 {
    private static final int BUFFER_SIZE = 32;
    private static final ByteBuffer byteBuf;
    private static final byte[] bytes;
    private static final CharBuffer charBuf;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    private static final StringBuilder sb;
    public static final Console2 INSTANCE = new Console2();
    private static final char[] chars = new char[32];

    static {
        byte[] bArr = new byte[32];
        bytes = bArr;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "ByteBuffer.wrap(bytes)");
        byteBuf = byteBufferWrap;
        CharBuffer charBufferWrap = CharBuffer.wrap(chars);
        Intrinsics.checkNotNullExpressionValue(charBufferWrap, "CharBuffer.wrap(chars)");
        charBuf = charBufferWrap;
        sb = new StringBuilder();
    }

    private Console2() {
    }

    public static final /* synthetic */ CharsetDecoder access$getDecoder$p(Console2 $this) {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        return charsetDecoder;
    }

    /* compiled from: Console.kt */
    @Metadata(m15bv = {1, 0, 3}, m18k = 3, m19mv = {1, 4, 0})
    /* renamed from: kotlin.io.LineReader$readLine$1 */
    final /* synthetic */ class C04651 extends MutablePropertyReference0Impl {
        C04651(Console2 console2) {
            super(console2, Console2.class, "decoder", "getDecoder()Ljava/nio/charset/CharsetDecoder;", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty6
        public Object get() {
            return Console2.access$getDecoder$p((Console2) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty3
        public void set(Object value) {
            Console2.decoder = (CharsetDecoder) value;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:
    
        if (r2 <= 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
    
        if (kotlin.p001io.Console2.chars[r2 - 1] != '\n') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008f, code lost:
    
        r2 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        if (r2 <= 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:
    
        if (kotlin.p001io.Console2.chars[r2 - 1] != '\r') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009d, code lost:
    
        r2 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a7, code lost:
    
        if (kotlin.p001io.Console2.sb.length() != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00aa, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
    
        if (r1 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b5, code lost:
    
        return new java.lang.String(kotlin.p001io.Console2.chars, 0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b6, code lost:
    
        kotlin.p001io.Console2.sb.append(kotlin.p001io.Console2.chars, 0, r2);
        r1 = kotlin.p001io.Console2.sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "sb.toString()");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ce, code lost:
    
        if (kotlin.p001io.Console2.sb.length() <= 32) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d0, code lost:
    
        trimStringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d3, code lost:
    
        kotlin.p001io.Console2.sb.setLength(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d9, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024 A[Catch: all -> 0x00e0, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0010, B:7:0x0014, B:8:0x0019, B:12:0x0029, B:14:0x0036, B:24:0x004c, B:38:0x0087, B:40:0x008f, B:42:0x0093, B:44:0x009d, B:45:0x009f, B:50:0x00ad, B:53:0x00b6, B:55:0x00d0, B:56:0x00d3, B:25:0x0052, B:28:0x005e, B:32:0x0066, B:34:0x0077, B:36:0x007f, B:59:0x00da, B:10:0x0024), top: B:64:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String readLine(java.io.InputStream r11, java.nio.charset.Charset r12) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p001io.Console2.readLine(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }

    private final int decode(boolean endOfInput) throws CharacterCodingException {
        while (true) {
            CharsetDecoder charsetDecoder = decoder;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
            }
            CoderResult coderResult = charsetDecoder.decode(byteBuf, charBuf, endOfInput);
            Intrinsics.checkNotNullExpressionValue(coderResult, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (coderResult.isError()) {
                resetAll();
                coderResult.throwException();
            }
            int nChars = charBuf.position();
            if (!coderResult.isOverflow()) {
                return nChars;
            }
            sb.append(chars, 0, nChars - 1);
            charBuf.position(0);
            charBuf.limit(32);
            charBuf.put(chars[nChars - 1]);
        }
    }

    private final int compactBytes() {
        ByteBuffer $this$with = byteBuf;
        $this$with.compact();
        int iPosition = $this$with.position();
        $this$with.position(0);
        return iPosition;
    }

    private final int decodeEndOfInput(int nBytes, int nChars) throws CharacterCodingException {
        byteBuf.limit(nBytes);
        charBuf.position(nChars);
        int iDecode = decode(true);
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        return iDecode;
    }

    private final void updateCharset(Charset charset) {
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(charsetDecoderNewDecoder, "charset.newDecoder()");
        decoder = charsetDecoderNewDecoder;
        byteBuf.clear();
        charBuf.clear();
        byteBuf.put((byte) 10);
        byteBuf.flip();
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        boolean z = false;
        charsetDecoder.decode(byteBuf, charBuf, false);
        if (charBuf.position() == 1 && charBuf.get(0) == '\n') {
            z = true;
        }
        directEOL = z;
        resetAll();
    }

    private final void resetAll() {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        sb.setLength(0);
    }

    private final void trimStringBuilder() {
        sb.setLength(32);
        sb.trimToSize();
    }
}
