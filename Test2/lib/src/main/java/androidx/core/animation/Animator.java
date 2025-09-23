package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Animator.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a¡\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001aW\u0010\f\u001a\u00020\r*\u00020\u00022#\b\u0006\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0013\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0014\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b\u001a2\u0010\u0015\u001a\u00020\r*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0016\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0086\b¨\u0006\u0017"}, m17d2 = {"addListener", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "animator", "", "onStart", "onCancel", "onRepeat", "addPauseListener", "Landroid/animation/Animator$AnimatorPauseListener;", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnRepeat", "doOnResume", "doOnStart", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.animation.AnimatorKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Animator {
    public static final Animator.AnimatorListener doOnEnd(android.animation.Animator doOnEnd, final Functions2<? super android.animation.Animator, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnEnd, "$this$doOnEnd");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
                action.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }
        };
        doOnEnd.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorListener doOnStart(android.animation.Animator doOnStart, final Functions2<? super android.animation.Animator, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnStart, "$this$doOnStart");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
                action.invoke(animator);
            }
        };
        doOnStart.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorListener doOnCancel(android.animation.Animator doOnCancel, final Functions2<? super android.animation.Animator, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnCancel, "$this$doOnCancel");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
                action.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }
        };
        doOnCancel.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorListener doOnRepeat(android.animation.Animator doOnRepeat, final Functions2<? super android.animation.Animator, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnRepeat, "$this$doOnRepeat");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
                action.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }
        };
        doOnRepeat.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorPauseListener doOnResume(android.animation.Animator doOnResume, final Functions2<? super android.animation.Animator, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnResume, "$this$doOnResume");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
                action.invoke(animator);
            }
        };
        doOnResume.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static final Animator.AnimatorPauseListener doOnPause(android.animation.Animator doOnPause, final Functions2<? super android.animation.Animator, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnPause, "$this$doOnPause");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
                action.invoke(animator);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator) {
                Intrinsics.checkParameterIsNotNull(animator, "animator");
            }
        };
        doOnPause.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(android.animation.Animator addListener, Functions2 onEnd, Functions2 onStart, Functions2 onCancel, Functions2 onRepeat, int i, Object obj) {
        if ((i & 1) != 0) {
            Functions2 onEnd2 = new Functions2<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addListener.1
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(android.animation.Animator animator) {
                    invoke2(animator);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.animation.Animator it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onEnd = onEnd2;
        }
        if ((i & 2) != 0) {
            Functions2 onStart2 = new Functions2<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addListener.2
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(android.animation.Animator animator) {
                    invoke2(animator);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.animation.Animator it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onStart = onStart2;
        }
        if ((i & 4) != 0) {
            Functions2 onCancel2 = new Functions2<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addListener.3
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(android.animation.Animator animator) {
                    invoke2(animator);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.animation.Animator it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onCancel = onCancel2;
        }
        if ((i & 8) != 0) {
            Functions2 onRepeat2 = new Functions2<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addListener.4
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(android.animation.Animator animator) {
                    invoke2(animator);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.animation.Animator it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onRepeat = onRepeat2;
        }
        Intrinsics.checkParameterIsNotNull(addListener, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        Intrinsics.checkParameterIsNotNull(onStart, "onStart");
        Intrinsics.checkParameterIsNotNull(onCancel, "onCancel");
        Intrinsics.checkParameterIsNotNull(onRepeat, "onRepeat");
        Animator8 listener = new Animator8(onRepeat, onEnd, onCancel, onStart);
        addListener.addListener(listener);
        return listener;
    }

    public static final Animator.AnimatorListener addListener(android.animation.Animator addListener, Functions2<? super android.animation.Animator, Unit> onEnd, Functions2<? super android.animation.Animator, Unit> onStart, Functions2<? super android.animation.Animator, Unit> onCancel, Functions2<? super android.animation.Animator, Unit> onRepeat) {
        Intrinsics.checkParameterIsNotNull(addListener, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        Intrinsics.checkParameterIsNotNull(onStart, "onStart");
        Intrinsics.checkParameterIsNotNull(onCancel, "onCancel");
        Intrinsics.checkParameterIsNotNull(onRepeat, "onRepeat");
        Animator8 listener = new Animator8(onRepeat, onEnd, onCancel, onStart);
        addListener.addListener(listener);
        return listener;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(android.animation.Animator addPauseListener, Functions2 onResume, Functions2 onPause, int i, Object obj) {
        if ((i & 1) != 0) {
            Functions2 onResume2 = new Functions2<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addPauseListener.1
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(android.animation.Animator animator) {
                    invoke2(animator);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.animation.Animator it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onResume = onResume2;
        }
        if ((i & 2) != 0) {
            Functions2 onPause2 = new Functions2<android.animation.Animator, Unit>() { // from class: androidx.core.animation.AnimatorKt.addPauseListener.2
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(android.animation.Animator animator) {
                    invoke2(animator);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(android.animation.Animator it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onPause = onPause2;
        }
        Intrinsics.checkParameterIsNotNull(addPauseListener, "$this$addPauseListener");
        Intrinsics.checkParameterIsNotNull(onResume, "onResume");
        Intrinsics.checkParameterIsNotNull(onPause, "onPause");
        Animator9 listener = new Animator9(onPause, onResume);
        addPauseListener.addPauseListener(listener);
        return listener;
    }

    public static final Animator.AnimatorPauseListener addPauseListener(android.animation.Animator addPauseListener, Functions2<? super android.animation.Animator, Unit> onResume, Functions2<? super android.animation.Animator, Unit> onPause) {
        Intrinsics.checkParameterIsNotNull(addPauseListener, "$this$addPauseListener");
        Intrinsics.checkParameterIsNotNull(onResume, "onResume");
        Intrinsics.checkParameterIsNotNull(onPause, "onPause");
        Animator9 listener = new Animator9(onPause, onResume);
        addPauseListener.addPauseListener(listener);
        return listener;
    }
}
