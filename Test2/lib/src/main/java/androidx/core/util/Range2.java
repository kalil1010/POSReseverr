package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.Range3;

/* compiled from: Range.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\f\u001a6\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0007\u001a7\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\n\u001a0\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u0002H\u0087\f¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a(\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007¨\u0006\u000e"}, m17d2 = {"and", "Landroid/util/Range;", "T", "", "other", "plus", "value", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "rangeTo", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "toClosedRange", "Lkotlin/ranges/ClosedRange;", "toRange", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.util.RangeKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Range2 {
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T rangeTo, T that) {
        Intrinsics.checkParameterIsNotNull(rangeTo, "$this$rangeTo");
        Intrinsics.checkParameterIsNotNull(that, "that");
        return new Range<>(rangeTo, that);
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> plus, T value) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(value, "value");
        Range<T> rangeExtend = plus.extend((Range<T>) value);
        Intrinsics.checkExpressionValueIsNotNull(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> plus, Range<T> other) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Range<T> rangeExtend = plus.extend(other);
        Intrinsics.checkExpressionValueIsNotNull(rangeExtend, "extend(other)");
        return rangeExtend;
    }

    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> and, Range<T> other) {
        Intrinsics.checkParameterIsNotNull(and, "$this$and");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Range<T> rangeIntersect = and.intersect(other);
        Intrinsics.checkExpressionValueIsNotNull(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    public static final <T extends Comparable<? super T>> Range3<T> toClosedRange(final Range<T> toClosedRange) {
        Intrinsics.checkParameterIsNotNull(toClosedRange, "$this$toClosedRange");
        return (Range3) new Range3<T>() { // from class: androidx.core.util.RangeKt.toClosedRange.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // kotlin.ranges.Range3
            public boolean contains(Comparable value) {
                Intrinsics.checkParameterIsNotNull(value, "value");
                return Range3.DefaultImpls.contains(this, value);
            }

            @Override // kotlin.ranges.Range3
            public boolean isEmpty() {
                return Range3.DefaultImpls.isEmpty(this);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.ranges.Range3
            public Comparable getEndInclusive() {
                return toClosedRange.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.ranges.Range3
            public Comparable getStart() {
                return toClosedRange.getLower();
            }
        };
    }

    public static final <T extends Comparable<? super T>> Range<T> toRange(Range3<T> toRange) {
        Intrinsics.checkParameterIsNotNull(toRange, "$this$toRange");
        return new Range<>(toRange.getStart(), toRange.getEndInclusive());
    }
}
