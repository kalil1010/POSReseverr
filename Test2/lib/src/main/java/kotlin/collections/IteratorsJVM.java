package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMarkers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IteratorsJVM.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002¨\u0006\u0004"}, m17d2 = {"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.CollectionsKt__IteratorsJVMKt, reason: use source file name */
/* loaded from: classes.dex */
public class IteratorsJVM extends Iterables10 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: IteratorsJVM.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0096\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m17d2 = {"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
    /* renamed from: kotlin.collections.CollectionsKt__IteratorsJVMKt$iterator$1 */
    public static final class C04301<T> implements Iterator<T>, KMarkers {
        final /* synthetic */ Enumeration $this_iterator;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C04301(Enumeration<T> enumeration) {
            this.$this_iterator = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.$this_iterator.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.$this_iterator.nextElement();
        }
    }

    public static final <T> Iterator<T> iterator(Enumeration<T> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "$this$iterator");
        return new C04301(iterator);
    }
}
