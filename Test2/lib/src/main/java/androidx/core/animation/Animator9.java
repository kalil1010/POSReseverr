package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, m17d2 = {"androidx/core/animation/AnimatorKt$addPauseListener$listener$1", "Landroid/animation/Animator$AnimatorPauseListener;", "onAnimationPause", "", "animator", "Landroid/animation/Animator;", "onAnimationResume", "core-ktx_release"}, m18k = 1, m19mv = {1, 1, 16})
/* renamed from: androidx.core.animation.AnimatorKt$addPauseListener$listener$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Animator9 implements Animator.AnimatorPauseListener {
    final /* synthetic */ Functions2 $onPause;
    final /* synthetic */ Functions2 $onResume;

    public Animator9(Functions2 $captured_local_variable$0, Functions2 $captured_local_variable$1) {
        this.$onPause = $captured_local_variable$0;
        this.$onResume = $captured_local_variable$1;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
