package okio.internal;

import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PrimitiveCompanionObjects8;
import kotlin.text.CharsKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.Sink;
import okio.Timeout;
import okio.Util;
import okio.buffer;

/* compiled from: RealBufferedSource.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\u0080\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\u0080\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0080\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\u0080\b¨\u00068"}, m17d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: okio.internal.RealBufferedSourceKt, reason: use source file name */
/* loaded from: classes.dex */
public final class RealBufferedSource2 {
    public static final long commonRead(buffer commonRead, Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(commonRead, "$this$commonRead");
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount >= 0) {
            if (!(true ^ commonRead.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            if (commonRead.bufferField.size() == 0) {
                long read = commonRead.source.read(commonRead.bufferField, 8192);
                if (read == -1) {
                    return -1L;
                }
            }
            long toRead = Math.min(byteCount, commonRead.bufferField.size());
            return commonRead.bufferField.read(sink, toRead);
        }
        throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
    }

    public static final boolean commonExhausted(buffer commonExhausted) {
        Intrinsics.checkNotNullParameter(commonExhausted, "$this$commonExhausted");
        if (!commonExhausted.closed) {
            return commonExhausted.bufferField.exhausted() && commonExhausted.source.read(commonExhausted.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonRequire(buffer commonRequire, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(commonRequire, "$this$commonRequire");
        if (!commonRequire.request(byteCount)) {
            throw new EOFException();
        }
    }

    public static final boolean commonRequest(buffer commonRequest, long byteCount) {
        Intrinsics.checkNotNullParameter(commonRequest, "$this$commonRequest");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (!(!commonRequest.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (commonRequest.bufferField.size() < byteCount) {
            if (commonRequest.source.read(commonRequest.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final byte commonReadByte(buffer commonReadByte) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadByte, "$this$commonReadByte");
        commonReadByte.require(1L);
        return commonReadByte.bufferField.readByte();
    }

    public static final ByteString commonReadByteString(buffer commonReadByteString) throws IOException {
        Intrinsics.checkNotNullParameter(commonReadByteString, "$this$commonReadByteString");
        commonReadByteString.bufferField.writeAll(commonReadByteString.source);
        return commonReadByteString.bufferField.readByteString();
    }

    public static final ByteString commonReadByteString(buffer commonReadByteString, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadByteString, "$this$commonReadByteString");
        commonReadByteString.require(byteCount);
        return commonReadByteString.bufferField.readByteString(byteCount);
    }

    public static final int commonSelect(buffer commonSelect, Options options) throws EOFException {
        Intrinsics.checkNotNullParameter(commonSelect, "$this$commonSelect");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!(!commonSelect.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int index = Buffer2.selectPrefix(commonSelect.bufferField, options, true);
            if (index != -2) {
                if (index == -1) {
                    return -1;
                }
                int selectedSize = options.getByteStrings()[index].size();
                commonSelect.bufferField.skip(selectedSize);
                return index;
            }
        } while (commonSelect.source.read(commonSelect.bufferField, 8192) != -1);
        return -1;
    }

    public static final byte[] commonReadByteArray(buffer commonReadByteArray) throws IOException {
        Intrinsics.checkNotNullParameter(commonReadByteArray, "$this$commonReadByteArray");
        commonReadByteArray.bufferField.writeAll(commonReadByteArray.source);
        return commonReadByteArray.bufferField.readByteArray();
    }

    public static final byte[] commonReadByteArray(buffer commonReadByteArray, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadByteArray, "$this$commonReadByteArray");
        commonReadByteArray.require(byteCount);
        return commonReadByteArray.bufferField.readByteArray(byteCount);
    }

    public static final void commonReadFully(buffer commonReadFully, byte[] sink) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadFully, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            commonReadFully.require(sink.length);
            commonReadFully.bufferField.readFully(sink);
        } catch (EOFException e) {
            int offset = 0;
            while (commonReadFully.bufferField.size() > 0) {
                int read = commonReadFully.bufferField.read(sink, offset, (int) commonReadFully.bufferField.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                offset += read;
            }
            throw e;
        }
    }

    public static final int commonRead(buffer commonRead, byte[] sink, int offset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(commonRead, "$this$commonRead");
        Intrinsics.checkNotNullParameter(sink, "sink");
        Util.checkOffsetAndCount(sink.length, offset, byteCount);
        if (commonRead.bufferField.size() == 0) {
            long read = commonRead.source.read(commonRead.bufferField, 8192);
            if (read == -1) {
                return -1;
            }
        }
        long b$iv = commonRead.bufferField.size();
        int toRead = (int) Math.min(byteCount, b$iv);
        return commonRead.bufferField.read(sink, offset, toRead);
    }

    public static final void commonReadFully(buffer commonReadFully, Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(commonReadFully, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            commonReadFully.require(byteCount);
            commonReadFully.bufferField.readFully(sink, byteCount);
        } catch (EOFException e) {
            sink.writeAll(commonReadFully.bufferField);
            throw e;
        }
    }

    public static final long commonReadAll(buffer commonReadAll, Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(commonReadAll, "$this$commonReadAll");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long totalBytesWritten = 0;
        while (commonReadAll.source.read(commonReadAll.bufferField, 8192) != -1) {
            long emitByteCount = commonReadAll.bufferField.completeSegmentByteCount();
            if (emitByteCount > 0) {
                totalBytesWritten += emitByteCount;
                sink.write(commonReadAll.bufferField, emitByteCount);
            }
        }
        if (commonReadAll.bufferField.size() > 0) {
            long totalBytesWritten2 = totalBytesWritten + commonReadAll.bufferField.size();
            sink.write(commonReadAll.bufferField, commonReadAll.bufferField.size());
            return totalBytesWritten2;
        }
        return totalBytesWritten;
    }

    public static final String commonReadUtf8(buffer commonReadUtf8) throws IOException {
        Intrinsics.checkNotNullParameter(commonReadUtf8, "$this$commonReadUtf8");
        commonReadUtf8.bufferField.writeAll(commonReadUtf8.source);
        return commonReadUtf8.bufferField.readUtf8();
    }

    public static final String commonReadUtf8(buffer commonReadUtf8, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadUtf8, "$this$commonReadUtf8");
        commonReadUtf8.require(byteCount);
        return commonReadUtf8.bufferField.readUtf8(byteCount);
    }

    public static final String commonReadUtf8Line(buffer commonReadUtf8Line) {
        Intrinsics.checkNotNullParameter(commonReadUtf8Line, "$this$commonReadUtf8Line");
        long newline = commonReadUtf8Line.indexOf((byte) 10);
        if (newline != -1) {
            return Buffer2.readUtf8Line(commonReadUtf8Line.bufferField, newline);
        }
        if (commonReadUtf8Line.bufferField.size() != 0) {
            return commonReadUtf8Line.readUtf8(commonReadUtf8Line.bufferField.size());
        }
        return null;
    }

    public static final String commonReadUtf8LineStrict(buffer commonReadUtf8LineStrict, long limit) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadUtf8LineStrict, "$this$commonReadUtf8LineStrict");
        if (!(limit >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long scanLength = limit == PrimitiveCompanionObjects8.MAX_VALUE ? Long.MAX_VALUE : limit + 1;
        byte b = (byte) 10;
        long newline = commonReadUtf8LineStrict.indexOf(b, 0L, scanLength);
        if (newline != -1) {
            return Buffer2.readUtf8Line(commonReadUtf8LineStrict.bufferField, newline);
        }
        if (scanLength < PrimitiveCompanionObjects8.MAX_VALUE && commonReadUtf8LineStrict.request(scanLength) && commonReadUtf8LineStrict.bufferField.getByte(scanLength - 1) == ((byte) 13) && commonReadUtf8LineStrict.request(1 + scanLength) && commonReadUtf8LineStrict.bufferField.getByte(scanLength) == b) {
            return Buffer2.readUtf8Line(commonReadUtf8LineStrict.bufferField, scanLength);
        }
        Buffer data = new Buffer();
        Buffer buffer = commonReadUtf8LineStrict.bufferField;
        long b$iv = commonReadUtf8LineStrict.bufferField.size();
        buffer.copyTo(data, 0L, Math.min(32, b$iv));
        throw new EOFException("\\n not found: limit=" + Math.min(commonReadUtf8LineStrict.bufferField.size(), limit) + " content=" + data.readByteString().hex() + "…");
    }

    public static final int commonReadUtf8CodePoint(buffer commonReadUtf8CodePoint) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadUtf8CodePoint, "$this$commonReadUtf8CodePoint");
        commonReadUtf8CodePoint.require(1L);
        int b0 = commonReadUtf8CodePoint.bufferField.getByte(0L);
        if ((b0 & 224) == 192) {
            commonReadUtf8CodePoint.require(2L);
        } else if ((b0 & 240) == 224) {
            commonReadUtf8CodePoint.require(3L);
        } else if ((b0 & 248) == 240) {
            commonReadUtf8CodePoint.require(4L);
        }
        return commonReadUtf8CodePoint.bufferField.readUtf8CodePoint();
    }

    public static final short commonReadShort(buffer commonReadShort) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadShort, "$this$commonReadShort");
        commonReadShort.require(2L);
        return commonReadShort.bufferField.readShort();
    }

    public static final short commonReadShortLe(buffer commonReadShortLe) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadShortLe, "$this$commonReadShortLe");
        commonReadShortLe.require(2L);
        return commonReadShortLe.bufferField.readShortLe();
    }

    public static final int commonReadInt(buffer commonReadInt) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadInt, "$this$commonReadInt");
        commonReadInt.require(4L);
        return commonReadInt.bufferField.readInt();
    }

    public static final int commonReadIntLe(buffer commonReadIntLe) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadIntLe, "$this$commonReadIntLe");
        commonReadIntLe.require(4L);
        return commonReadIntLe.bufferField.readIntLe();
    }

    public static final long commonReadLong(buffer commonReadLong) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadLong, "$this$commonReadLong");
        commonReadLong.require(8L);
        return commonReadLong.bufferField.readLong();
    }

    public static final long commonReadLongLe(buffer commonReadLongLe) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadLongLe, "$this$commonReadLongLe");
        commonReadLongLe.require(8L);
        return commonReadLongLe.bufferField.readLongLe();
    }

    public static final long commonReadDecimalLong(buffer commonReadDecimalLong) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadDecimalLong, "$this$commonReadDecimalLong");
        commonReadDecimalLong.require(1L);
        for (long pos = 0; commonReadDecimalLong.request(pos + 1); pos++) {
            byte b = commonReadDecimalLong.bufferField.getByte(pos);
            if ((b < ((byte) 48) || b > ((byte) 57)) && (pos != 0 || b != ((byte) 45))) {
                if (pos == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected leading [0-9] or '-' character but was 0x");
                    String string = Integer.toString(b, CharsKt.checkRadix(CharsKt.checkRadix(16)));
                    Intrinsics.checkNotNullExpressionValue(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                    sb.append(string);
                    throw new NumberFormatException(sb.toString());
                }
                return commonReadDecimalLong.bufferField.readDecimalLong();
            }
        }
        return commonReadDecimalLong.bufferField.readDecimalLong();
    }

    public static final long commonReadHexadecimalUnsignedLong(buffer commonReadHexadecimalUnsignedLong) throws EOFException {
        Intrinsics.checkNotNullParameter(commonReadHexadecimalUnsignedLong, "$this$commonReadHexadecimalUnsignedLong");
        commonReadHexadecimalUnsignedLong.require(1L);
        for (int pos = 0; commonReadHexadecimalUnsignedLong.request(pos + 1); pos++) {
            byte b = commonReadHexadecimalUnsignedLong.bufferField.getByte(pos);
            if ((b < ((byte) 48) || b > ((byte) 57)) && ((b < ((byte) 97) || b > ((byte) 102)) && (b < ((byte) 65) || b > ((byte) 70)))) {
                if (pos == 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected leading [0-9a-fA-F] character but was 0x");
                    String string = Integer.toString(b, CharsKt.checkRadix(CharsKt.checkRadix(16)));
                    Intrinsics.checkNotNullExpressionValue(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
                    sb.append(string);
                    throw new NumberFormatException(sb.toString());
                }
                return commonReadHexadecimalUnsignedLong.bufferField.readHexadecimalUnsignedLong();
            }
        }
        return commonReadHexadecimalUnsignedLong.bufferField.readHexadecimalUnsignedLong();
    }

    public static final void commonSkip(buffer commonSkip, long byteCount) throws EOFException {
        Intrinsics.checkNotNullParameter(commonSkip, "$this$commonSkip");
        long byteCount2 = byteCount;
        if (!(!commonSkip.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (byteCount2 > 0) {
            if (commonSkip.bufferField.size() == 0 && commonSkip.source.read(commonSkip.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long toSkip = Math.min(byteCount2, commonSkip.bufferField.size());
            commonSkip.bufferField.skip(toSkip);
            byteCount2 -= toSkip;
        }
    }

    public static final long commonIndexOf(buffer commonIndexOf, byte b, long fromIndex, long toIndex) {
        Intrinsics.checkNotNullParameter(commonIndexOf, "$this$commonIndexOf");
        if (!(!commonIndexOf.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (0 <= fromIndex && toIndex >= fromIndex) {
            long fromIndex2 = fromIndex;
            while (fromIndex2 < toIndex) {
                long result = commonIndexOf.bufferField.indexOf(b, fromIndex2, toIndex);
                if (result != -1) {
                    return result;
                }
                long lastBufferSize = commonIndexOf.bufferField.size();
                if (lastBufferSize >= toIndex || commonIndexOf.source.read(commonIndexOf.bufferField, 8192) == -1) {
                    return -1L;
                }
                fromIndex2 = Math.max(fromIndex2, lastBufferSize);
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
    }

    public static final long commonIndexOf(buffer commonIndexOf, ByteString bytes, long fromIndex) throws IOException {
        Intrinsics.checkNotNullParameter(commonIndexOf, "$this$commonIndexOf");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        long fromIndex2 = fromIndex;
        if (!(!commonIndexOf.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long result = commonIndexOf.bufferField.indexOf(bytes, fromIndex2);
            if (result != -1) {
                return result;
            }
            long lastBufferSize = commonIndexOf.bufferField.size();
            if (commonIndexOf.source.read(commonIndexOf.bufferField, 8192) == -1) {
                return -1L;
            }
            fromIndex2 = Math.max(fromIndex2, (lastBufferSize - bytes.size()) + 1);
        }
    }

    public static final long commonIndexOfElement(buffer commonIndexOfElement, ByteString targetBytes, long fromIndex) {
        Intrinsics.checkNotNullParameter(commonIndexOfElement, "$this$commonIndexOfElement");
        Intrinsics.checkNotNullParameter(targetBytes, "targetBytes");
        long fromIndex2 = fromIndex;
        if (!(!commonIndexOfElement.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long result = commonIndexOfElement.bufferField.indexOfElement(targetBytes, fromIndex2);
            if (result != -1) {
                return result;
            }
            long lastBufferSize = commonIndexOfElement.bufferField.size();
            if (commonIndexOfElement.source.read(commonIndexOfElement.bufferField, 8192) == -1) {
                return -1L;
            }
            fromIndex2 = Math.max(fromIndex2, lastBufferSize);
        }
    }

    public static final boolean commonRangeEquals(buffer commonRangeEquals, long offset, ByteString bytes, int bytesOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(commonRangeEquals, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        if (!(!commonRangeEquals.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (offset < 0 || bytesOffset < 0 || byteCount < 0 || bytes.size() - bytesOffset < byteCount) {
            return false;
        }
        for (int i = 0; i < byteCount; i++) {
            long bufferOffset = i + offset;
            if (!commonRangeEquals.request(1 + bufferOffset) || commonRangeEquals.bufferField.getByte(bufferOffset) != bytes.getByte(bytesOffset + i)) {
                return false;
            }
        }
        return true;
    }

    public static final BufferedSource commonPeek(buffer commonPeek) {
        Intrinsics.checkNotNullParameter(commonPeek, "$this$commonPeek");
        return Okio.buffer(new PeekSource(commonPeek));
    }

    public static final void commonClose(buffer commonClose) throws IOException {
        Intrinsics.checkNotNullParameter(commonClose, "$this$commonClose");
        if (commonClose.closed) {
            return;
        }
        commonClose.closed = true;
        commonClose.source.close();
        commonClose.bufferField.clear();
    }

    public static final Timeout commonTimeout(buffer commonTimeout) {
        Intrinsics.checkNotNullParameter(commonTimeout, "$this$commonTimeout");
        return commonTimeout.source.getTimeout();
    }

    public static final String commonToString(buffer commonToString) {
        Intrinsics.checkNotNullParameter(commonToString, "$this$commonToString");
        return "buffer(" + commonToString.source + ')';
    }
}
