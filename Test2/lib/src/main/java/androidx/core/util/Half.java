package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Half.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, m17d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.util.HalfKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Half {
    public static final android.util.Half toHalf(short $this$toHalf) {
        android.util.Half halfValueOf = android.util.Half.valueOf($this$toHalf);
        Intrinsics.checkExpressionValueIsNotNull(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    public static final android.util.Half toHalf(float $this$toHalf) {
        android.util.Half halfValueOf = android.util.Half.valueOf($this$toHalf);
        Intrinsics.checkExpressionValueIsNotNull(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    public static final android.util.Half toHalf(double $this$toHalf) {
        float $this$toHalf$iv = (float) $this$toHalf;
        android.util.Half halfValueOf = android.util.Half.valueOf($this$toHalf$iv);
        Intrinsics.checkExpressionValueIsNotNull(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }

    public static final android.util.Half toHalf(String toHalf) {
        Intrinsics.checkParameterIsNotNull(toHalf, "$this$toHalf");
        android.util.Half halfValueOf = android.util.Half.valueOf(toHalf);
        Intrinsics.checkExpressionValueIsNotNull(halfValueOf, "Half.valueOf(this)");
        return halfValueOf;
    }
}
