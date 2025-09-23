package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMarkers;

/* compiled from: Region.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\u0017"}, m17d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.RegionKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Region {
    public static final boolean contains(android.graphics.Region contains, Point p) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Intrinsics.checkParameterIsNotNull(p, "p");
        return contains.contains(p.x, p.y);
    }

    public static final android.graphics.Region plus(android.graphics.Region plus, Rect r) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply = new android.graphics.Region(plus);
        $this$apply.union(r);
        return $this$apply;
    }

    public static final android.graphics.Region plus(android.graphics.Region plus, android.graphics.Region r) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply = new android.graphics.Region(plus);
        $this$apply.op(r, Region.Op.UNION);
        return $this$apply;
    }

    public static final android.graphics.Region minus(android.graphics.Region minus, Rect r) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply = new android.graphics.Region(minus);
        $this$apply.op(r, Region.Op.DIFFERENCE);
        return $this$apply;
    }

    public static final android.graphics.Region minus(android.graphics.Region minus, android.graphics.Region r) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply = new android.graphics.Region(minus);
        $this$apply.op(r, Region.Op.DIFFERENCE);
        return $this$apply;
    }

    public static final android.graphics.Region unaryMinus(android.graphics.Region unaryMinus) {
        Intrinsics.checkParameterIsNotNull(unaryMinus, "$this$unaryMinus");
        android.graphics.Region $this$apply = new android.graphics.Region(unaryMinus.getBounds());
        $this$apply.op(unaryMinus, Region.Op.DIFFERENCE);
        return $this$apply;
    }

    public static final android.graphics.Region not(android.graphics.Region not) {
        Intrinsics.checkParameterIsNotNull(not, "$this$not");
        android.graphics.Region $this$apply$iv = new android.graphics.Region(not.getBounds());
        $this$apply$iv.op(not, Region.Op.DIFFERENCE);
        return $this$apply$iv;
    }

    /* renamed from: or */
    public static final android.graphics.Region m9or(android.graphics.Region or, Rect r) {
        Intrinsics.checkParameterIsNotNull(or, "$this$or");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply$iv = new android.graphics.Region(or);
        $this$apply$iv.union(r);
        return $this$apply$iv;
    }

    /* renamed from: or */
    public static final android.graphics.Region m10or(android.graphics.Region or, android.graphics.Region r) {
        Intrinsics.checkParameterIsNotNull(or, "$this$or");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply$iv = new android.graphics.Region(or);
        $this$apply$iv.op(r, Region.Op.UNION);
        return $this$apply$iv;
    }

    public static final android.graphics.Region and(android.graphics.Region and, Rect r) {
        Intrinsics.checkParameterIsNotNull(and, "$this$and");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply = new android.graphics.Region(and);
        $this$apply.op(r, Region.Op.INTERSECT);
        return $this$apply;
    }

    public static final android.graphics.Region and(android.graphics.Region and, android.graphics.Region r) {
        Intrinsics.checkParameterIsNotNull(and, "$this$and");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply = new android.graphics.Region(and);
        $this$apply.op(r, Region.Op.INTERSECT);
        return $this$apply;
    }

    public static final android.graphics.Region xor(android.graphics.Region xor, Rect r) {
        Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply = new android.graphics.Region(xor);
        $this$apply.op(r, Region.Op.XOR);
        return $this$apply;
    }

    public static final android.graphics.Region xor(android.graphics.Region xor, android.graphics.Region r) {
        Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region $this$apply = new android.graphics.Region(xor);
        $this$apply.op(r, Region.Op.XOR);
        return $this$apply;
    }

    public static final void forEach(android.graphics.Region forEach, Functions2<? super Rect, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(action, "action");
        RegionIterator iterator = new RegionIterator(forEach);
        while (true) {
            Rect r = new Rect();
            if (iterator.next(r)) {
                action.invoke(r);
            } else {
                return;
            }
        }
    }

    /* compiled from: Region.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\b\u001a\u00020\u0004H\u0096\u0002J\t\u0010\t\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m17d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "hasMore", "", "iterator", "Landroid/graphics/RegionIterator;", "rect", "hasNext", "next", "core-ktx_release"}, m18k = 1, m19mv = {1, 1, 16})
    /* renamed from: androidx.core.graphics.RegionKt$iterator$1 */
    public static final class C01471 implements Iterator<Rect>, KMarkers {
        final /* synthetic */ android.graphics.Region $this_iterator;
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C01471(android.graphics.Region $receiver) {
            this.$this_iterator = $receiver;
            this.iterator = new RegionIterator(this.$this_iterator);
            Rect rect = new Rect();
            this.rect = rect;
            this.hasMore = this.iterator.next(rect);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rect next() {
            if (this.hasMore) {
                Rect r = new Rect(this.rect);
                this.hasMore = this.iterator.next(this.rect);
                return r;
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public static final Iterator<Rect> iterator(android.graphics.Region iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new C01471(iterator);
    }
}
