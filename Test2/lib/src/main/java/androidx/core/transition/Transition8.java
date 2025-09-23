package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, m17d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, m18k = 1, m19mv = {1, 1, 16})
/* renamed from: androidx.core.transition.TransitionKt$addListener$listener$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Transition8 implements Transition.TransitionListener {
    final /* synthetic */ Functions2 $onCancel;
    final /* synthetic */ Functions2 $onEnd;
    final /* synthetic */ Functions2 $onPause;
    final /* synthetic */ Functions2 $onResume;
    final /* synthetic */ Functions2 $onStart;

    public Transition8(Functions2 $captured_local_variable$0, Functions2 $captured_local_variable$1, Functions2 $captured_local_variable$2, Functions2 $captured_local_variable$3, Functions2 $captured_local_variable$4) {
        this.$onEnd = $captured_local_variable$0;
        this.$onResume = $captured_local_variable$1;
        this.$onPause = $captured_local_variable$2;
        this.$onCancel = $captured_local_variable$3;
        this.$onStart = $captured_local_variable$4;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
        this.$onEnd.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
        this.$onResume.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
        this.$onPause.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
        this.$onCancel.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Intrinsics.checkParameterIsNotNull(transition, "transition");
        this.$onStart.invoke(transition);
    }
}
