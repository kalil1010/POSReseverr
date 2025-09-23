package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Annotations;
import kotlin.Annotations3;
import kotlin.Annotations8;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmPlatformAnnotations6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.p003sf.scuba.smartcards.ISO7816;
import okio.internal.ByteString2;
import org.apache.commons.lang3.StringUtils;

/* compiled from: ByteString.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 Z2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001ZB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0000J\u0013\u0010!\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\"H\u0096\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0087\u0002¢\u0006\u0002\b&J\u0015\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0007¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\tH\u0010¢\u0006\u0002\b)J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u001d\u0010+\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0000H\u0010¢\u0006\u0002\b-J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\r\u00103\u001a\u00020\u0004H\u0010¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\tH\u0010¢\u0006\u0002\b7J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\b\u00109\u001a\u00020\u0000H\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020\u0000H\u0016J\b\u0010C\u001a\u00020\u0000H\u0016J\b\u0010D\u001a\u00020\u0000H\u0016J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bEJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0004J\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0000J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016J\u001c\u0010K\u001a\u00020\u00002\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\tH\u0017J\b\u0010N\u001a\u00020\u0000H\u0016J\b\u0010O\u001a\u00020\u0000H\u0016J\b\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020TH\u0016J%\u0010R\u001a\u00020?2\u0006\u0010U\u001a\u00020V2\u0006\u0010;\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0010¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u00020?2\u0006\u0010S\u001a\u00020YH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006["}, m17d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, m18k = 1, m19mv = {1, 4, 0})
/* loaded from: classes.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    @JvmPlatformAnnotations6
    public static final ByteString decodeBase64(String str) {
        return INSTANCE.decodeBase64(str);
    }

    @JvmPlatformAnnotations6
    public static final ByteString decodeHex(String str) {
        return INSTANCE.decodeHex(str);
    }

    @JvmPlatformAnnotations6
    public static final ByteString encodeString(String str, Charset charset) {
        return INSTANCE.encodeString(str, charset);
    }

    @JvmPlatformAnnotations6
    public static final ByteString encodeUtf8(String str) {
        return INSTANCE.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(byteString2, i);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return byteString.indexOf(bArr, i);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = byteString.size();
        }
        return byteString.lastIndexOf(byteString2, i);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = byteString.size();
        }
        return byteString.lastIndexOf(bArr, i);
    }

    @JvmPlatformAnnotations6
    /* renamed from: of */
    public static final ByteString m41of(ByteBuffer byteBuffer) {
        return INSTANCE.m44of(byteBuffer);
    }

    @JvmPlatformAnnotations6
    /* renamed from: of */
    public static final ByteString m42of(byte... bArr) {
        return INSTANCE.m45of(bArr);
    }

    @JvmPlatformAnnotations6
    /* renamed from: of */
    public static final ByteString m43of(byte[] bArr, int i, int i2) {
        return INSTANCE.m46of(bArr, i, i2);
    }

    @JvmPlatformAnnotations6
    public static final ByteString read(InputStream inputStream, int i) throws IOException {
        return INSTANCE.read(inputStream, i);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = byteString.size();
        }
        return byteString.substring(i, i2);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int i) {
        return substring$default(this, i, 0, 2, null);
    }

    public ByteString(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    /* renamed from: getData$okio, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: getHashCode$okio, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public final void setHashCode$okio(int i) {
        this.hashCode = i;
    }

    /* renamed from: getUtf8$okio, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public String utf8() {
        String result$iv = getUtf8();
        if (result$iv != null) {
            return result$iv;
        }
        String result$iv2 = Platform.toUtf8String(internalArray$okio());
        setUtf8$okio(result$iv2);
        return result$iv2;
    }

    public String string(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(this.data, charset);
    }

    public String base64() {
        return Base64.encodeBase64$default(getData(), null, 1, null);
    }

    public ByteString md5() {
        return digest$okio("MD5");
    }

    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public ByteString digest$okio(String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        byte[] bArrDigest = MessageDigest.getInstance(algorithm).digest(this.data);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(bArrDigest);
    }

    public ByteString hmacSha1(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public ByteString hmacSha256(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public ByteString hmacSha512(ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public ByteString hmac$okio(String algorithm, ByteString key) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "mac.doFinal(data)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String base64Url() {
        return Base64.encodeBase64(getData(), Base64.getBASE64_URL_SAFE());
    }

    public String hex() {
        char[] result$iv = new char[getData().length * 2];
        int c$iv = 0;
        for (int b$iv : getData()) {
            int c$iv2 = c$iv + 1;
            int other$iv$iv = b$iv >> 4;
            result$iv[c$iv] = ByteString2.getHEX_DIGIT_CHARS()[other$iv$iv & 15];
            c$iv = c$iv2 + 1;
            int other$iv$iv2 = 15 & b$iv;
            result$iv[c$iv2] = ByteString2.getHEX_DIGIT_CHARS()[other$iv$iv2];
        }
        return new String(result$iv);
    }

    public ByteString toAsciiLowercase() {
        byte b;
        for (int i$iv = 0; i$iv < getData().length; i$iv++) {
            byte c$iv = getData()[i$iv];
            byte b2 = (byte) 65;
            if (c$iv >= b2 && c$iv <= (b = (byte) 90)) {
                byte[] data = getData();
                byte[] lowercase$iv = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(lowercase$iv, "java.util.Arrays.copyOf(this, size)");
                int i$iv2 = i$iv + 1;
                lowercase$iv[i$iv] = (byte) (c$iv + ISO7816.INS_VERIFY);
                while (i$iv2 < lowercase$iv.length) {
                    byte c$iv2 = lowercase$iv[i$iv2];
                    if (c$iv2 < b2 || c$iv2 > b) {
                        i$iv2++;
                    } else {
                        lowercase$iv[i$iv2] = (byte) (c$iv2 + ISO7816.INS_VERIFY);
                        i$iv2++;
                    }
                }
                return new ByteString(lowercase$iv);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        byte b;
        for (int i$iv = 0; i$iv < getData().length; i$iv++) {
            byte c$iv = getData()[i$iv];
            byte b2 = (byte) 97;
            if (c$iv >= b2 && c$iv <= (b = (byte) 122)) {
                byte[] data = getData();
                byte[] lowercase$iv = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(lowercase$iv, "java.util.Arrays.copyOf(this, size)");
                int i$iv2 = i$iv + 1;
                lowercase$iv[i$iv] = (byte) (c$iv + ISO7816.INS_CREATE_FILE);
                while (i$iv2 < lowercase$iv.length) {
                    byte c$iv2 = lowercase$iv[i$iv2];
                    if (c$iv2 < b2 || c$iv2 > b) {
                        i$iv2++;
                    } else {
                        lowercase$iv[i$iv2] = (byte) (c$iv2 + ISO7816.INS_CREATE_FILE);
                        i$iv2++;
                    }
                }
                return new ByteString(lowercase$iv);
            }
        }
        return this;
    }

    public ByteString substring(int beginIndex, int endIndex) {
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (!(endIndex <= getData().length)) {
            throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
        }
        int subLen$iv = endIndex - beginIndex;
        if (!(subLen$iv >= 0)) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        if (beginIndex == 0 && endIndex == getData().length) {
            return this;
        }
        return new ByteString(ArraysKt.copyOfRange(getData(), beginIndex, endIndex));
    }

    public byte internalGet$okio(int pos) {
        return getData()[pos];
    }

    public final byte getByte(int index) {
        return internalGet$okio(index);
    }

    public final int size() {
        return getSize$okio();
    }

    public int getSize$okio() {
        return getData().length;
    }

    public byte[] toByteArray() {
        byte[] data = getData();
        byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    public byte[] internalArray$okio() {
        return getData();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(byteBufferAsReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    public void write(OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        out.write(this.data);
    }

    public void write$okio(Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ByteString2.commonWrite(this, buffer, offset, byteCount);
    }

    public boolean rangeEquals(int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(otherOffset, getData(), offset, byteCount);
    }

    public boolean rangeEquals(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && Util.arrayRangeEquals(getData(), offset, other, otherOffset, byteCount);
    }

    public final boolean startsWith(ByteString prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public final boolean startsWith(byte[] prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    public final boolean endsWith(ByteString suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public final boolean endsWith(byte[] suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public final int indexOf(ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf(other.internalArray$okio(), fromIndex);
    }

    public int indexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        int limit$iv = getData().length - other.length;
        int i$iv = Math.max(fromIndex, 0);
        if (i$iv <= limit$iv) {
            while (!Util.arrayRangeEquals(getData(), i$iv, other, 0, other.length)) {
                if (i$iv != limit$iv) {
                    i$iv++;
                }
            }
            return i$iv;
        }
        return -1;
    }

    public final int lastIndexOf(ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    public int lastIndexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        int limit$iv = getData().length - other.length;
        for (int i$iv = Math.min(fromIndex, limit$iv); i$iv >= 0; i$iv--) {
            if (Util.arrayRangeEquals(getData(), i$iv, other, 0, other.length)) {
                return i$iv;
            }
        }
        return -1;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        return (other instanceof ByteString) && ((ByteString) other).size() == getData().length && ((ByteString) other).rangeEquals(0, getData(), 0, getData().length);
    }

    public int hashCode() {
        int result$iv = getHashCode();
        if (result$iv != 0) {
            return result$iv;
        }
        int it$iv = Arrays.hashCode(getData());
        setHashCode$okio(it$iv);
        return it$iv;
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int sizeA$iv = size();
        int sizeB$iv = other.size();
        int size$iv = Math.min(sizeA$iv, sizeB$iv);
        for (int i$iv = 0; i$iv < size$iv; i$iv++) {
            int $this$and$iv$iv = getByte(i$iv);
            int byteA$iv = $this$and$iv$iv & 255;
            byte $this$and$iv$iv2 = other.getByte(i$iv);
            int byteB$iv = $this$and$iv$iv2 & UByte.MAX_VALUE;
            if (byteA$iv != byteB$iv) {
                return byteA$iv < byteB$iv ? -1 : 1;
            }
        }
        if (sizeA$iv == sizeB$iv) {
            return 0;
        }
        return sizeA$iv < sizeB$iv ? -1 : 1;
    }

    public String toString() {
        if (getData().length == 0) {
            return "[size=0]";
        }
        int i$iv = ByteString2.codePointIndexToCharIndex(getData(), 64);
        if (i$iv != -1) {
            String text$iv = utf8();
            if (text$iv == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = text$iv.substring(0, i$iv);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String safeText$iv = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(strSubstring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), StringUtils.f866CR, "\\r", false, 4, (Object) null);
            if (i$iv >= text$iv.length()) {
                return "[text=" + safeText$iv + ']';
            }
            return "[size=" + getData().length + " text=" + safeText$iv + "…]";
        }
        if (getData().length <= 64) {
            return "[hex=" + hex() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(getData().length);
        sb.append(" hex=");
        ByteString $this$commonSubstring$iv$iv = this;
        if (!(64 <= $this$commonSubstring$iv$iv.getData().length)) {
            throw new IllegalArgumentException(("endIndex > length(" + $this$commonSubstring$iv$iv.getData().length + ')').toString());
        }
        int subLen$iv$iv = 64 - 0;
        if (!(subLen$iv$iv >= 0)) {
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        if (64 != $this$commonSubstring$iv$iv.getData().length) {
            $this$commonSubstring$iv$iv = new ByteString(ArraysKt.copyOfRange($this$commonSubstring$iv$iv.getData(), 0, 64));
        }
        sb.append($this$commonSubstring$iv$iv.hex());
        sb.append("…]");
        return sb.toString();
    }

    private final void readObject(ObjectInputStream in) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        int dataLength = in.readInt();
        ByteString byteString = INSTANCE.read(in, dataLength);
        Field field = ByteString.class.getDeclaredField("data");
        Intrinsics.checkNotNullExpressionValue(field, "field");
        field.setAccessible(true);
        field.set(this, byteString.data);
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to operator function", replaceWith = @Annotations8(expression = "this[index]", imports = {}))
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m1527deprecated_getByte(int index) {
        return getByte(index);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to val", replaceWith = @Annotations8(expression = "size", imports = {}))
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m1528deprecated_size() {
        return size();
    }

    /* compiled from: ByteString.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007¢\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006%"}, m17d2 = {"Lokio/ByteString$Companion;", "", "()V", "EMPTY", "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", "string", "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", "charset", "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", "array", "offset", "", "byteCount", "read", "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, m18k = 1, m19mv = {1, 4, 0})
    public static final class Companion {
        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            return companion.m46of(bArr, i, i2);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @JvmPlatformAnnotations6
        /* renamed from: of */
        public final ByteString m45of(byte... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(bArrCopyOf);
        }

        @JvmPlatformAnnotations6
        /* renamed from: of */
        public final ByteString m46of(byte[] toByteString, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(toByteString, "$this$toByteString");
            Util.checkOffsetAndCount(toByteString.length, offset, byteCount);
            return new ByteString(ArraysKt.copyOfRange(toByteString, offset, offset + byteCount));
        }

        @JvmPlatformAnnotations6
        /* renamed from: of */
        public final ByteString m44of(ByteBuffer toByteString) {
            Intrinsics.checkNotNullParameter(toByteString, "$this$toByteString");
            byte[] copy = new byte[toByteString.remaining()];
            toByteString.get(copy);
            return new ByteString(copy);
        }

        @JvmPlatformAnnotations6
        public final ByteString encodeUtf8(String encodeUtf8) {
            Intrinsics.checkNotNullParameter(encodeUtf8, "$this$encodeUtf8");
            ByteString byteString$iv = new ByteString(Platform.asUtf8ToByteArray(encodeUtf8));
            byteString$iv.setUtf8$okio(encodeUtf8);
            return byteString$iv;
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i, Object obj) {
            if ((i & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return companion.encodeString(str, charset);
        }

        @JvmPlatformAnnotations6
        public final ByteString encodeString(String encode, Charset charset) {
            Intrinsics.checkNotNullParameter(encode, "$this$encode");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @JvmPlatformAnnotations6
        public final ByteString decodeBase64(String decodeBase64) {
            Intrinsics.checkNotNullParameter(decodeBase64, "$this$decodeBase64");
            byte[] decoded$iv = Base64.decodeBase64ToArray(decodeBase64);
            if (decoded$iv != null) {
                return new ByteString(decoded$iv);
            }
            return null;
        }

        @JvmPlatformAnnotations6
        public final ByteString decodeHex(String decodeHex) {
            Intrinsics.checkNotNullParameter(decodeHex, "$this$decodeHex");
            if (!(decodeHex.length() % 2 == 0)) {
                throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
            }
            byte[] result$iv = new byte[decodeHex.length() / 2];
            int length = result$iv.length;
            for (int i$iv = 0; i$iv < length; i$iv++) {
                int d1$iv = ByteString2.decodeHexDigit(decodeHex.charAt(i$iv * 2)) << 4;
                int d2$iv = ByteString2.decodeHexDigit(decodeHex.charAt((i$iv * 2) + 1));
                result$iv[i$iv] = (byte) (d1$iv + d2$iv);
            }
            return new ByteString(result$iv);
        }

        @JvmPlatformAnnotations6
        public final ByteString read(InputStream readByteString, int byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(readByteString, "$this$readByteString");
            if (!(byteCount >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
            }
            byte[] result = new byte[byteCount];
            int offset = 0;
            while (offset < byteCount) {
                int read = readByteString.read(result, offset, byteCount - offset);
                if (read == -1) {
                    throw new EOFException();
                }
                offset += read;
            }
            return new ByteString(result);
        }

        @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        /* renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m1529deprecated_decodeBase64(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return decodeBase64(string);
        }

        @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        /* renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m1530deprecated_decodeHex(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return decodeHex(string);
        }

        @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        /* renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m1531deprecated_encodeString(String string, Charset charset) {
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(charset, "charset");
            return encodeString(string, charset);
        }

        @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        /* renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m1532deprecated_encodeUtf8(String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return encodeUtf8(string);
        }

        @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m1533deprecated_of(ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            return m44of(buffer);
        }

        @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m1534deprecated_of(byte[] array, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(array, "array");
            return m46of(array, offset, byteCount);
        }

        @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        /* renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m1535deprecated_read(InputStream inputstream, int byteCount) {
            Intrinsics.checkNotNullParameter(inputstream, "inputstream");
            return read(inputstream, byteCount);
        }
    }
}
