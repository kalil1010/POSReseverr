package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Region;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Rect.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f¨\u0006\u001d"}, m17d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "times", "factor", "toRect", "toRectF", "toRegion", "transform", "m", "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.RectKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Rect {
    public static final int component1(android.graphics.Rect component1) {
        Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.left;
    }

    public static final int component2(android.graphics.Rect component2) {
        Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.top;
    }

    public static final int component3(android.graphics.Rect component3) {
        Intrinsics.checkParameterIsNotNull(component3, "$this$component3");
        return component3.right;
    }

    public static final int component4(android.graphics.Rect component4) {
        Intrinsics.checkParameterIsNotNull(component4, "$this$component4");
        return component4.bottom;
    }

    public static final float component1(RectF component1) {
        Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.left;
    }

    public static final float component2(RectF component2) {
        Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.top;
    }

    public static final float component3(RectF component3) {
        Intrinsics.checkParameterIsNotNull(component3, "$this$component3");
        return component3.right;
    }

    public static final float component4(RectF component4) {
        Intrinsics.checkParameterIsNotNull(component4, "$this$component4");
        return component4.bottom;
    }

    public static final android.graphics.Rect plus(android.graphics.Rect plus, android.graphics.Rect r) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect $this$apply = new android.graphics.Rect(plus);
        $this$apply.union(r);
        return $this$apply;
    }

    public static final RectF plus(RectF plus, RectF r) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        RectF $this$apply = new RectF(plus);
        $this$apply.union(r);
        return $this$apply;
    }

    public static final android.graphics.Rect plus(android.graphics.Rect plus, int xy) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        android.graphics.Rect $this$apply = new android.graphics.Rect(plus);
        $this$apply.offset(xy, xy);
        return $this$apply;
    }

    public static final RectF plus(RectF plus, float xy) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        RectF $this$apply = new RectF(plus);
        $this$apply.offset(xy, xy);
        return $this$apply;
    }

    public static final android.graphics.Rect plus(android.graphics.Rect plus, Point xy) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(xy, "xy");
        android.graphics.Rect $this$apply = new android.graphics.Rect(plus);
        $this$apply.offset(xy.x, xy.y);
        return $this$apply;
    }

    public static final RectF plus(RectF plus, PointF xy) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(xy, "xy");
        RectF $this$apply = new RectF(plus);
        $this$apply.offset(xy.x, xy.y);
        return $this$apply;
    }

    public static final Region minus(android.graphics.Rect minus, android.graphics.Rect r) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $this$apply = new Region(minus);
        $this$apply.op(r, Region.Op.DIFFERENCE);
        return $this$apply;
    }

    public static final Region minus(RectF minus, RectF r) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect r$iv = new android.graphics.Rect();
        minus.roundOut(r$iv);
        Region $this$apply = new Region(r$iv);
        android.graphics.Rect r$iv2 = new android.graphics.Rect();
        r.roundOut(r$iv2);
        $this$apply.op(r$iv2, Region.Op.DIFFERENCE);
        return $this$apply;
    }

    public static final android.graphics.Rect minus(android.graphics.Rect minus, int xy) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        android.graphics.Rect $this$apply = new android.graphics.Rect(minus);
        $this$apply.offset(-xy, -xy);
        return $this$apply;
    }

    public static final RectF minus(RectF minus, float xy) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        RectF $this$apply = new RectF(minus);
        $this$apply.offset(-xy, -xy);
        return $this$apply;
    }

    public static final android.graphics.Rect minus(android.graphics.Rect minus, Point xy) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(xy, "xy");
        android.graphics.Rect $this$apply = new android.graphics.Rect(minus);
        $this$apply.offset(-xy.x, -xy.y);
        return $this$apply;
    }

    public static final RectF minus(RectF minus, PointF xy) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(xy, "xy");
        RectF $this$apply = new RectF(minus);
        $this$apply.offset(-xy.x, -xy.y);
        return $this$apply;
    }

    public static final android.graphics.Rect times(android.graphics.Rect times, int factor) {
        Intrinsics.checkParameterIsNotNull(times, "$this$times");
        android.graphics.Rect $this$apply = new android.graphics.Rect(times);
        $this$apply.top *= factor;
        $this$apply.left *= factor;
        $this$apply.right *= factor;
        $this$apply.bottom *= factor;
        return $this$apply;
    }

    public static final RectF times(RectF times, int factor) {
        Intrinsics.checkParameterIsNotNull(times, "$this$times");
        float factor$iv = factor;
        RectF $this$apply$iv = new RectF(times);
        $this$apply$iv.top *= factor$iv;
        $this$apply$iv.left *= factor$iv;
        $this$apply$iv.right *= factor$iv;
        $this$apply$iv.bottom *= factor$iv;
        return $this$apply$iv;
    }

    public static final RectF times(RectF times, float factor) {
        Intrinsics.checkParameterIsNotNull(times, "$this$times");
        RectF $this$apply = new RectF(times);
        $this$apply.top *= factor;
        $this$apply.left *= factor;
        $this$apply.right *= factor;
        $this$apply.bottom *= factor;
        return $this$apply;
    }

    /* renamed from: or */
    public static final android.graphics.Rect m7or(android.graphics.Rect or, android.graphics.Rect r) {
        Intrinsics.checkParameterIsNotNull(or, "$this$or");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect $this$apply$iv = new android.graphics.Rect(or);
        $this$apply$iv.union(r);
        return $this$apply$iv;
    }

    /* renamed from: or */
    public static final RectF m8or(RectF or, RectF r) {
        Intrinsics.checkParameterIsNotNull(or, "$this$or");
        Intrinsics.checkParameterIsNotNull(r, "r");
        RectF $this$apply$iv = new RectF(or);
        $this$apply$iv.union(r);
        return $this$apply$iv;
    }

    public static final android.graphics.Rect and(android.graphics.Rect and, android.graphics.Rect r) {
        Intrinsics.checkParameterIsNotNull(and, "$this$and");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect $this$apply = new android.graphics.Rect(and);
        $this$apply.intersect(r);
        return $this$apply;
    }

    public static final RectF and(RectF and, RectF r) {
        Intrinsics.checkParameterIsNotNull(and, "$this$and");
        Intrinsics.checkParameterIsNotNull(r, "r");
        RectF $this$apply = new RectF(and);
        $this$apply.intersect(r);
        return $this$apply;
    }

    public static final Region xor(android.graphics.Rect xor, android.graphics.Rect r) {
        Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region $this$apply = new Region(xor);
        $this$apply.op(r, Region.Op.XOR);
        return $this$apply;
    }

    public static final Region xor(RectF xor, RectF r) {
        Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect r$iv = new android.graphics.Rect();
        xor.roundOut(r$iv);
        Region $this$apply = new Region(r$iv);
        android.graphics.Rect r$iv2 = new android.graphics.Rect();
        r.roundOut(r$iv2);
        $this$apply.op(r$iv2, Region.Op.XOR);
        return $this$apply;
    }

    public static final boolean contains(android.graphics.Rect contains, Point p) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Intrinsics.checkParameterIsNotNull(p, "p");
        return contains.contains(p.x, p.y);
    }

    public static final boolean contains(RectF contains, PointF p) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Intrinsics.checkParameterIsNotNull(p, "p");
        return contains.contains(p.x, p.y);
    }

    public static final RectF toRectF(android.graphics.Rect toRectF) {
        Intrinsics.checkParameterIsNotNull(toRectF, "$this$toRectF");
        return new RectF(toRectF);
    }

    public static final android.graphics.Rect toRect(RectF toRect) {
        Intrinsics.checkParameterIsNotNull(toRect, "$this$toRect");
        android.graphics.Rect r = new android.graphics.Rect();
        toRect.roundOut(r);
        return r;
    }

    public static final Region toRegion(android.graphics.Rect toRegion) {
        Intrinsics.checkParameterIsNotNull(toRegion, "$this$toRegion");
        return new Region(toRegion);
    }

    public static final Region toRegion(RectF toRegion) {
        Intrinsics.checkParameterIsNotNull(toRegion, "$this$toRegion");
        android.graphics.Rect r$iv = new android.graphics.Rect();
        toRegion.roundOut(r$iv);
        return new Region(r$iv);
    }

    public static final RectF transform(RectF transform, Matrix m) {
        Intrinsics.checkParameterIsNotNull(transform, "$this$transform");
        Intrinsics.checkParameterIsNotNull(m, "m");
        m.mapRect(transform);
        return transform;
    }
}
