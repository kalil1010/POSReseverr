package androidx.core.graphics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Paint.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086\b¨\u0006\u0005"}, m17d2 = {"setBlendMode", "", "Landroid/graphics/Paint;", "blendModeCompat", "Landroidx/core/graphics/BlendModeCompat;", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.PaintKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Paint {
    public static final boolean setBlendMode(android.graphics.Paint setBlendMode, BlendModeCompat blendModeCompat) {
        Intrinsics.checkParameterIsNotNull(setBlendMode, "$this$setBlendMode");
        return PaintCompat.setBlendMode(setBlendMode, blendModeCompat);
    }
}
