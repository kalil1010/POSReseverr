package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÆ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u001a2\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b¨\u0006\u0013"}, m17d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.transition.TransitionKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Transition2 {
    public static final Transition.TransitionListener doOnEnd(Transition doOnEnd, final Functions2<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnEnd, "$this$doOnEnd");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
                action.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }
        };
        doOnEnd.addListener(transitionListener);
        return transitionListener;
    }

    public static final Transition.TransitionListener doOnStart(Transition doOnStart, final Functions2<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnStart, "$this$doOnStart");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
                action.invoke(transition);
            }
        };
        doOnStart.addListener(transitionListener);
        return transitionListener;
    }

    public static final Transition.TransitionListener doOnCancel(Transition doOnCancel, final Functions2<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnCancel, "$this$doOnCancel");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
                action.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }
        };
        doOnCancel.addListener(transitionListener);
        return transitionListener;
    }

    public static final Transition.TransitionListener doOnResume(Transition doOnResume, final Functions2<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnResume, "$this$doOnResume");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
                action.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }
        };
        doOnResume.addListener(transitionListener);
        return transitionListener;
    }

    public static final Transition.TransitionListener doOnPause(Transition doOnPause, final Functions2<? super Transition, Unit> action) {
        Intrinsics.checkParameterIsNotNull(doOnPause, "$this$doOnPause");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
                action.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                Intrinsics.checkParameterIsNotNull(transition, "transition");
            }
        };
        doOnPause.addListener(transitionListener);
        return transitionListener;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition addListener, Functions2 onEnd, Functions2 onStart, Functions2 onCancel, Functions2 onResume, Functions2 onPause, int i, Object obj) {
        Functions2 onStart2;
        Functions2 onCancel2;
        Functions2 onResume2;
        Functions2 onPause2;
        if ((i & 1) != 0) {
            Functions2 onEnd2 = new Functions2<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.1
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onEnd = onEnd2;
        }
        if ((i & 2) == 0) {
            onStart2 = onStart;
        } else {
            Functions2 onStart3 = new Functions2<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.2
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onStart2 = onStart3;
        }
        if ((i & 4) == 0) {
            onCancel2 = onCancel;
        } else {
            Functions2 onCancel3 = new Functions2<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.3
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onCancel2 = onCancel3;
        }
        if ((i & 8) == 0) {
            onResume2 = onResume;
        } else {
            Functions2 onResume3 = new Functions2<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.4
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onResume2 = onResume3;
        }
        if ((i & 16) == 0) {
            onPause2 = onPause;
        } else {
            Functions2 onPause3 = new Functions2<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt.addListener.5
                @Override // kotlin.jvm.functions.Functions2
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                }
            };
            onPause2 = onPause3;
        }
        Intrinsics.checkParameterIsNotNull(addListener, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        Intrinsics.checkParameterIsNotNull(onStart2, "onStart");
        Intrinsics.checkParameterIsNotNull(onCancel2, "onCancel");
        Intrinsics.checkParameterIsNotNull(onResume2, "onResume");
        Intrinsics.checkParameterIsNotNull(onPause2, "onPause");
        Transition8 listener = new Transition8(onEnd, onResume2, onPause2, onCancel2, onStart2);
        addListener.addListener(listener);
        return listener;
    }

    public static final Transition.TransitionListener addListener(Transition addListener, Functions2<? super Transition, Unit> onEnd, Functions2<? super Transition, Unit> onStart, Functions2<? super Transition, Unit> onCancel, Functions2<? super Transition, Unit> onResume, Functions2<? super Transition, Unit> onPause) {
        Intrinsics.checkParameterIsNotNull(addListener, "$this$addListener");
        Intrinsics.checkParameterIsNotNull(onEnd, "onEnd");
        Intrinsics.checkParameterIsNotNull(onStart, "onStart");
        Intrinsics.checkParameterIsNotNull(onCancel, "onCancel");
        Intrinsics.checkParameterIsNotNull(onResume, "onResume");
        Intrinsics.checkParameterIsNotNull(onPause, "onPause");
        Transition8 listener = new Transition8(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(listener);
        return listener;
    }
}
