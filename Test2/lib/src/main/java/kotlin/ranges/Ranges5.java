package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.Range3;

/* compiled from: Ranges.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, m17d2 = {"Lkotlin/ranges/ComparableRange;", "T", "", "Lkotlin/ranges/ClosedRange;", "start", "endInclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)V", "getEndInclusive", "()Ljava/lang/Comparable;", "Ljava/lang/Comparable;", "getStart", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.ranges.ComparableRange, reason: use source file name */
/* loaded from: classes.dex */
class Ranges5<T extends Comparable<? super T>> implements Range3<T> {
    private final T endInclusive;
    private final T start;

    public Ranges5(T start, T endInclusive) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endInclusive, "endInclusive");
        this.start = start;
        this.endInclusive = endInclusive;
    }

    @Override // kotlin.ranges.Range3
    public boolean contains(T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Range3.DefaultImpls.contains(this, value);
    }

    @Override // kotlin.ranges.Range3
    public boolean isEmpty() {
        return Range3.DefaultImpls.isEmpty(this);
    }

    @Override // kotlin.ranges.Range3
    public T getStart() {
        return this.start;
    }

    @Override // kotlin.ranges.Range3
    public T getEndInclusive() {
        return this.endInclusive;
    }

    public boolean equals(Object other) {
        return (other instanceof Ranges5) && ((isEmpty() && ((Ranges5) other).isEmpty()) || (Intrinsics.areEqual(getStart(), ((Ranges5) other).getStart()) && Intrinsics.areEqual(getEndInclusive(), ((Ranges5) other).getEndInclusive())));
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getStart().hashCode() * 31) + getEndInclusive().hashCode();
    }

    public String toString() {
        return getStart() + ".." + getEndInclusive();
    }
}
