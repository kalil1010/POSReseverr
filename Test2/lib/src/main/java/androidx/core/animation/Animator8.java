package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, m17d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release"}, m18k = 1, m19mv = {1, 1, 16})
/* renamed from: androidx.core.animation.AnimatorKt$addListener$listener$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Animator8 implements Animator.AnimatorListener {
    final /* synthetic */ Functions2 $onCancel;
    final /* synthetic */ Functions2 $onEnd;
    final /* synthetic */ Functions2 $onRepeat;
    final /* synthetic */ Functions2 $onStart;

    public Animator8(Functions2 $captured_local_variable$0, Functions2 $captured_local_variable$1, Functions2 $captured_local_variable$2, Functions2 $captured_local_variable$3) {
        this.$onRepeat = $captured_local_variable$0;
        this.$onEnd = $captured_local_variable$1;
        this.$onCancel = $captured_local_variable$2;
        this.$onStart = $captured_local_variable$3;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
