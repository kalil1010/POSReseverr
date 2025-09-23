package androidx.core.graphics;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Point.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\f\u001a\u00020\u0004*\u00020\u0004H\u0086\n¨\u0006\r"}, m17d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "minus", "p", "xy", "plus", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.PointKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Point {
    public static final int component1(android.graphics.Point component1) {
        Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.x;
    }

    public static final int component2(android.graphics.Point component2) {
        Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.y;
    }

    public static final float component1(PointF component1) {
        Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.x;
    }

    public static final float component2(PointF component2) {
        Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.y;
    }

    public static final android.graphics.Point plus(android.graphics.Point plus, android.graphics.Point p) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(p, "p");
        android.graphics.Point $this$apply = new android.graphics.Point(plus.x, plus.y);
        $this$apply.offset(p.x, p.y);
        return $this$apply;
    }

    public static final PointF plus(PointF plus, PointF p) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(p, "p");
        PointF $this$apply = new PointF(plus.x, plus.y);
        $this$apply.offset(p.x, p.y);
        return $this$apply;
    }

    public static final android.graphics.Point plus(android.graphics.Point plus, int xy) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        android.graphics.Point $this$apply = new android.graphics.Point(plus.x, plus.y);
        $this$apply.offset(xy, xy);
        return $this$apply;
    }

    public static final PointF plus(PointF plus, float xy) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        PointF $this$apply = new PointF(plus.x, plus.y);
        $this$apply.offset(xy, xy);
        return $this$apply;
    }

    public static final android.graphics.Point minus(android.graphics.Point minus, android.graphics.Point p) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(p, "p");
        android.graphics.Point $this$apply = new android.graphics.Point(minus.x, minus.y);
        $this$apply.offset(-p.x, -p.y);
        return $this$apply;
    }

    public static final PointF minus(PointF minus, PointF p) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(p, "p");
        PointF $this$apply = new PointF(minus.x, minus.y);
        $this$apply.offset(-p.x, -p.y);
        return $this$apply;
    }

    public static final android.graphics.Point minus(android.graphics.Point minus, int xy) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        android.graphics.Point $this$apply = new android.graphics.Point(minus.x, minus.y);
        $this$apply.offset(-xy, -xy);
        return $this$apply;
    }

    public static final PointF minus(PointF minus, float xy) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        PointF $this$apply = new PointF(minus.x, minus.y);
        $this$apply.offset(-xy, -xy);
        return $this$apply;
    }

    public static final android.graphics.Point unaryMinus(android.graphics.Point unaryMinus) {
        Intrinsics.checkParameterIsNotNull(unaryMinus, "$this$unaryMinus");
        return new android.graphics.Point(-unaryMinus.x, -unaryMinus.y);
    }

    public static final PointF unaryMinus(PointF unaryMinus) {
        Intrinsics.checkParameterIsNotNull(unaryMinus, "$this$unaryMinus");
        return new PointF(-unaryMinus.x, -unaryMinus.y);
    }

    public static final PointF toPointF(android.graphics.Point toPointF) {
        Intrinsics.checkParameterIsNotNull(toPointF, "$this$toPointF");
        return new PointF(toPointF);
    }

    public static final android.graphics.Point toPoint(PointF toPoint) {
        Intrinsics.checkParameterIsNotNull(toPoint, "$this$toPoint");
        return new android.graphics.Point((int) toPoint.x, (int) toPoint.y);
    }
}
