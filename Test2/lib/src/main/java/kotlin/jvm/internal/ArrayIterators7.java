package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.Iterators;
import kotlin.collections.Iterators10;
import kotlin.collections.Iterators2;
import kotlin.collections.Iterators3;
import kotlin.collections.Iterators5;
import kotlin.collections.Iterators6;
import kotlin.collections.Iterators8;
import kotlin.collections.Iterators9;

/* compiled from: ArrayIterators.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007\u001a\u000e\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\t\u001a\u000e\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000b\u001a\u000e\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r\u001a\u000e\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000f\u001a\u000e\u0010\u0000\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0011¨\u0006\u0012"}, m17d2 = {"iterator", "Lkotlin/collections/BooleanIterator;", "array", "", "Lkotlin/collections/ByteIterator;", "", "Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/ShortIterator;", "", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: kotlin.jvm.internal.ArrayIteratorsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ArrayIterators7 {
    public static final Iterators2 iterator(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterators2(array);
    }

    public static final Iterators3 iterator(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterators3(array);
    }

    public static final Iterators10 iterator(short[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterators9(array);
    }

    public static final Iterators8 iterator(int[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterators6(array);
    }

    public static final Iterators9 iterator(long[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterators8(array);
    }

    public static final Iterators6 iterator(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterators5(array);
    }

    public static final Iterators5 iterator(double[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterators4(array);
    }

    public static final Iterators iterator(boolean[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIterators(array);
    }
}
