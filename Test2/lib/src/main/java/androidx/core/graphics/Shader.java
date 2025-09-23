package androidx.core.graphics;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Shader.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086\b¨\u0006\u0007"}, m17d2 = {"transform", "", "Landroid/graphics/Shader;", "block", "Lkotlin/Function1;", "Landroid/graphics/Matrix;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.ShaderKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Shader {
    public static final void transform(android.graphics.Shader transform, Functions2<? super Matrix, Unit> block) {
        Intrinsics.checkParameterIsNotNull(transform, "$this$transform");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Matrix matrix = new Matrix();
        transform.getLocalMatrix(matrix);
        block.invoke(matrix);
        transform.setLocalMatrix(matrix);
    }
}
