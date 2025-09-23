package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedUtils;
import kotlin.collections.UIterators3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ULongRange.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0002J\u0015\u0010\r\u001a\u00020\u0003H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u00020\u0003X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\t\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, m17d2 = {"Lkotlin/ranges/ULongProgressionIterator;", "Lkotlin/collections/ULongIterator;", "first", "Lkotlin/ULong;", "last", "step", "", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "finalElement", "J", "hasNext", "", "next", "nextULong", "nextULong-s-VKNKU", "()J", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.ranges.ULongProgressionIterator, reason: use source file name */
/* loaded from: classes.dex */
final class ULongRange3 extends UIterators3 {
    private final long finalElement;
    private boolean hasNext;
    private long next;
    private final long step;

    private ULongRange3(long first, long last, long step) {
        this.finalElement = last;
        boolean z = true;
        int iUlongCompare = UnsignedUtils.ulongCompare(first, last);
        if (step <= 0 ? iUlongCompare < 0 : iUlongCompare > 0) {
            z = false;
        }
        this.hasNext = z;
        this.step = ULong.m232constructorimpl(step);
        this.next = this.hasNext ? first : this.finalElement;
    }

    public /* synthetic */ ULongRange3(long first, long last, long step, DefaultConstructorMarker $constructor_marker) {
        this(first, last, step);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.UIterators3
    /* renamed from: nextULong-s-VKNKU */
    public long mo293nextULongsVKNKU() {
        long value = this.next;
        if (value == this.finalElement) {
            if (!this.hasNext) {
                throw new NoSuchElementException();
            }
            this.hasNext = false;
        } else {
            this.next = ULong.m232constructorimpl(this.next + this.step);
        }
        return value;
    }
}
