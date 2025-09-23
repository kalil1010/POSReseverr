package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.internal.markers.KMarkers;

/* compiled from: UIterators.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\t"}, m17d2 = {"Lkotlin/collections/UByteIterator;", "", "Lkotlin/UByte;", "()V", "next", "next-w2LRezQ", "()B", "nextUByte", "nextUByte-w2LRezQ", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.collections.UByteIterator, reason: use source file name */
/* loaded from: classes.dex */
public abstract class UIterators implements Iterator<UByte>, KMarkers {
    /* renamed from: nextUByte-w2LRezQ */
    public abstract byte mo153nextUBytew2LRezQ();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UByte next() {
        return UByte.m88boximpl(m503nextw2LRezQ());
    }

    /* renamed from: next-w2LRezQ, reason: not valid java name */
    public final byte m503nextw2LRezQ() {
        return mo153nextUBytew2LRezQ();
    }
}
