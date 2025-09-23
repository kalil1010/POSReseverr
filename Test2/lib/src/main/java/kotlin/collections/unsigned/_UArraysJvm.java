package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedUtils;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _UArraysJvm.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000T\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001*\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a2\u0010\u0012\u001a\u00020\u0013*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001f\u0010\u001f\u001a\u00020\u0002*\u00020\u00032\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010\u001f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010\u001f\u001a\u00020\n*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010\u001f\u001a\u00020\u000e*\u00020\u000f2\u0006\u0010 \u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a.\u0010)\u001a\u00020**\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.\u001a.\u0010)\u001a\u00020/*\u00020\u00032\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020/0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u001a.\u0010)\u001a\u00020**\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020*0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u00102\u001a.\u0010)\u001a\u00020/*\u00020\u00072\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020/0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00103\u001a.\u0010)\u001a\u00020**\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020*0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u00104\u001a.\u0010)\u001a\u00020/*\u00020\u000b2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020/0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00105\u001a.\u0010)\u001a\u00020**\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020*0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u00106\u001a.\u0010)\u001a\u00020/*\u00020\u000f2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020/0,H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00107\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u00068"}, m17d2 = {"asList", "", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "asList-GBYM_sE", "([B)Ljava/util/List;", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "asList--ajY-9A", "([I)Ljava/util/List;", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "asList-QwZRm1k", "([J)Ljava/util/List;", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "", "element", "fromIndex", "toIndex", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-EtDCXyQ", "([SSII)I", "elementAt", "index", "elementAt-PpDY95g", "([BI)B", "elementAt-qFRl0hI", "([II)I", "elementAt-r7IrZao", "([JI)J", "elementAt-nggk6HY", "([SI)S", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m20pn = "kotlin.collections", m21xi = 1, m22xs = "kotlin/collections/unsigned/UArraysKt")
/* renamed from: kotlin.collections.unsigned.UArraysKt___UArraysJvmKt */
/* loaded from: classes.dex */
class _UArraysJvm {
    /* renamed from: elementAt-qFRl0hI */
    private static final int m521elementAtqFRl0hI(int[] $this$elementAt, int index) {
        return UIntArray.m213getpVg5ArA($this$elementAt, index);
    }

    /* renamed from: elementAt-r7IrZao */
    private static final long m522elementAtr7IrZao(long[] $this$elementAt, int index) {
        return ULongArray.m283getsVKNKU($this$elementAt, index);
    }

    /* renamed from: elementAt-PpDY95g */
    private static final byte m519elementAtPpDY95g(byte[] $this$elementAt, int index) {
        return UByteArray.m143getw2LRezQ($this$elementAt, index);
    }

    /* renamed from: elementAt-nggk6HY */
    private static final short m520elementAtnggk6HY(short[] $this$elementAt, int index) {
        return UShortArray.m379getMh2AYeg($this$elementAt, index);
    }

    /* renamed from: asList--ajY-9A */
    public static final List<UInt> m507asListajY9A(int[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new _UArraysJvm2(asList);
    }

    /* renamed from: asList-QwZRm1k */
    public static final List<ULong> m509asListQwZRm1k(long[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new _UArraysJvm3(asList);
    }

    /* renamed from: asList-GBYM_sE */
    public static final List<UByte> m508asListGBYM_sE(byte[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new _UArraysJvm4(asList);
    }

    /* renamed from: asList-rL5Bavg */
    public static final List<UShort> m510asListrL5Bavg(short[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new _UArraysJvm5(asList);
    }

    /* renamed from: binarySearch-2fe2U9s$default */
    public static /* synthetic */ int m512binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m214getSizeimpl(iArr);
        }
        return UArraysKt.m511binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    /* renamed from: binarySearch-2fe2U9s */
    public static final int m511binarySearch2fe2U9s(int[] binarySearch, int element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UIntArray.m214getSizeimpl(binarySearch));
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = binarySearch[mid];
            int cmp = UnsignedUtils.uintCompare(midVal, element);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default */
    public static /* synthetic */ int m516binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m284getSizeimpl(jArr);
        }
        return UArraysKt.m515binarySearchK6DWlUc(jArr, j, i, i2);
    }

    /* renamed from: binarySearch-K6DWlUc */
    public static final int m515binarySearchK6DWlUc(long[] binarySearch, long element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, ULongArray.m284getSizeimpl(binarySearch));
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = binarySearch[mid];
            int cmp = UnsignedUtils.ulongCompare(midVal, element);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default */
    public static /* synthetic */ int m518binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m144getSizeimpl(bArr);
        }
        return UArraysKt.m517binarySearchWpHrYlw(bArr, b, i, i2);
    }

    /* renamed from: binarySearch-WpHrYlw */
    public static final int m517binarySearchWpHrYlw(byte[] binarySearch, byte element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UByteArray.m144getSizeimpl(binarySearch));
        int signedElement = element & UByte.MAX_VALUE;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            byte midVal = binarySearch[mid];
            int cmp = UnsignedUtils.uintCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default */
    public static /* synthetic */ int m514binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m380getSizeimpl(sArr);
        }
        return UArraysKt.m513binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    /* renamed from: binarySearch-EtDCXyQ */
    public static final int m513binarySearchEtDCXyQ(short[] binarySearch, short element, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(binarySearch, "$this$binarySearch");
        AbstractList.INSTANCE.checkRangeIndexes$kotlin_stdlib(fromIndex, toIndex, UShortArray.m380getSizeimpl(binarySearch));
        int signedElement = 65535 & element;
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            short midVal = binarySearch[mid];
            int cmp = UnsignedUtils.uintCompare(midVal, signedElement);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    private static final BigDecimal sumOfBigDecimal(int[] $this$sumOf, Functions2<? super UInt, ? extends BigDecimal> functions2) {
        BigDecimal sum = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "BigDecimal.valueOf(this.toLong())");
        for (int element : $this$sumOf) {
            BigDecimal bigDecimalAdd = sum.add(functions2.invoke(UInt.m156boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "this.add(other)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(long[] $this$sumOf, Functions2<? super ULong, ? extends BigDecimal> functions2) {
        BigDecimal sum = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "BigDecimal.valueOf(this.toLong())");
        for (long element : $this$sumOf) {
            BigDecimal bigDecimalAdd = sum.add(functions2.invoke(ULong.m226boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "this.add(other)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] $this$sumOf, Functions2<? super UByte, ? extends BigDecimal> functions2) {
        BigDecimal sum = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "BigDecimal.valueOf(this.toLong())");
        for (byte element : $this$sumOf) {
            BigDecimal bigDecimalAdd = sum.add(functions2.invoke(UByte.m88boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "this.add(other)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigDecimal sumOfBigDecimal(short[] $this$sumOf, Functions2<? super UShort, ? extends BigDecimal> functions2) {
        BigDecimal sum = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "BigDecimal.valueOf(this.toLong())");
        for (short element : $this$sumOf) {
            BigDecimal bigDecimalAdd = sum.add(functions2.invoke(UShort.m324boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "this.add(other)");
            sum = bigDecimalAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(int[] $this$sumOf, Functions2<? super UInt, ? extends BigInteger> functions2) {
        BigInteger sum = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "BigInteger.valueOf(this.toLong())");
        for (int element : $this$sumOf) {
            BigInteger bigIntegerAdd = sum.add(functions2.invoke(UInt.m156boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "this.add(other)");
            sum = bigIntegerAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(long[] $this$sumOf, Functions2<? super ULong, ? extends BigInteger> functions2) {
        BigInteger sum = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "BigInteger.valueOf(this.toLong())");
        for (long element : $this$sumOf) {
            BigInteger bigIntegerAdd = sum.add(functions2.invoke(ULong.m226boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "this.add(other)");
            sum = bigIntegerAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(byte[] $this$sumOf, Functions2<? super UByte, ? extends BigInteger> functions2) {
        BigInteger sum = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "BigInteger.valueOf(this.toLong())");
        for (byte element : $this$sumOf) {
            BigInteger bigIntegerAdd = sum.add(functions2.invoke(UByte.m88boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "this.add(other)");
            sum = bigIntegerAdd;
        }
        return sum;
    }

    private static final BigInteger sumOfBigInteger(short[] $this$sumOf, Functions2<? super UShort, ? extends BigInteger> functions2) {
        BigInteger sum = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(sum, "BigInteger.valueOf(this.toLong())");
        for (short element : $this$sumOf) {
            BigInteger bigIntegerAdd = sum.add(functions2.invoke(UShort.m324boximpl(element)));
            Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "this.add(other)");
            sum = bigIntegerAdd;
        }
        return sum;
    }
}
