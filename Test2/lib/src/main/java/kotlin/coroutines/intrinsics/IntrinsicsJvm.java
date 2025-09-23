package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.Result2;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContextImpl5;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl2;
import kotlin.coroutines.jvm.internal.ContinuationImpl4;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.functions.Functions17;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: IntrinsicsJvm.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\u001c\b\u0004\u0010\u0005\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0083\b¢\u0006\u0002\b\b\u001aD\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a]\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0007\u001aA\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0003*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0003*#\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001an\u0010\u0011\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0014\"\u0004\b\u0002\u0010\u0003*)\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015¢\u0006\u0002\b\r2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0006\u0010\u0016\u001a\u0002H\u00142\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m17d2 = {"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/coroutines/intrinsics/IntrinsicsKt")
/* renamed from: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt */
/* loaded from: classes.dex */
public class IntrinsicsJvm {
    private static final <T> Object startCoroutineUninterceptedOrReturn(Functions2<? super Continuation<? super T>, ? extends Object> functions2, Continuation<? super T> continuation) {
        if (functions2 != null) {
            return ((Functions2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(functions2, 1)).invoke(continuation);
        }
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    private static final <R, T> Object startCoroutineUninterceptedOrReturn(Functions13<? super R, ? super Continuation<? super T>, ? extends Object> functions13, R r, Continuation<? super T> continuation) {
        if (functions13 != null) {
            return ((Functions13) TypeIntrinsics.beforeCheckcastToFunctionOfArity(functions13, 2)).invoke(r, continuation);
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(Functions17<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> functions17, R r, P p, Continuation<? super T> continuation) {
        if (functions17 != null) {
            return ((Functions17) TypeIntrinsics.beforeCheckcastToFunctionOfArity(functions17, 3)).invoke(r, p, continuation);
        }
        throw new NullPointerException("null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<Unit> createCoroutineUnintercepted(final Functions2<? super Continuation<? super T>, ? extends Object> createCoroutineUnintercepted, Continuation<? super T> completion) {
        ContinuationImpl continuationImpl;
        Intrinsics.checkNotNullParameter(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation probeCompletion = DebugProbes.probeCoroutineCreated(completion);
        if (createCoroutineUnintercepted instanceof ContinuationImpl2) {
            return ((ContinuationImpl2) createCoroutineUnintercepted).create(probeCompletion);
        }
        final CoroutineContext context$iv = probeCompletion.get$context();
        if (context$iv == CoroutineContextImpl5.INSTANCE) {
            if (probeCompletion == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            continuationImpl = new ContinuationImpl4(probeCompletion) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$1
                private int label;

                @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
                protected Object invokeSuspend(Object result) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            Result2.throwOnFailure(result);
                            return result;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    Result2.throwOnFailure(result);
                    IntrinsicsJvm2 intrinsicsJvm2 = this;
                    Functions2 functions2 = createCoroutineUnintercepted;
                    if (functions2 != null) {
                        return ((Functions2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(functions2, 1)).invoke(intrinsicsJvm2);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        } else if (probeCompletion != null) {
            continuationImpl = new ContinuationImpl(probeCompletion, context$iv) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$2
                private int label;

                @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
                protected Object invokeSuspend(Object result) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            Result2.throwOnFailure(result);
                            return result;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    Result2.throwOnFailure(result);
                    IntrinsicsJvm3 intrinsicsJvm3 = this;
                    Functions2 functions2 = createCoroutineUnintercepted;
                    if (functions2 != null) {
                        return ((Functions2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(functions2, 1)).invoke(intrinsicsJvm3);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return continuationImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(final Functions13<? super R, ? super Continuation<? super T>, ? extends Object> createCoroutineUnintercepted, final R r, Continuation<? super T> completion) {
        ContinuationImpl continuationImpl;
        Intrinsics.checkNotNullParameter(createCoroutineUnintercepted, "$this$createCoroutineUnintercepted");
        Intrinsics.checkNotNullParameter(completion, "completion");
        final Continuation probeCompletion = DebugProbes.probeCoroutineCreated(completion);
        if (createCoroutineUnintercepted instanceof ContinuationImpl2) {
            return ((ContinuationImpl2) createCoroutineUnintercepted).create(r, probeCompletion);
        }
        final CoroutineContext context$iv = probeCompletion.get$context();
        if (context$iv == CoroutineContextImpl5.INSTANCE) {
            if (probeCompletion == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            continuationImpl = new ContinuationImpl4(probeCompletion) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
                private int label;

                @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
                protected Object invokeSuspend(Object result) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            Result2.throwOnFailure(result);
                            return result;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    Result2.throwOnFailure(result);
                    IntrinsicsJvm4 intrinsicsJvm4 = this;
                    Functions13 functions13 = createCoroutineUnintercepted;
                    if (functions13 != null) {
                        return ((Functions13) TypeIntrinsics.beforeCheckcastToFunctionOfArity(functions13, 2)).invoke(r, intrinsicsJvm4);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        } else if (probeCompletion != null) {
            continuationImpl = new ContinuationImpl(probeCompletion, context$iv) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
                private int label;

                @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
                protected Object invokeSuspend(Object result) {
                    int i = this.label;
                    if (i != 0) {
                        if (i == 1) {
                            this.label = 2;
                            Result2.throwOnFailure(result);
                            return result;
                        }
                        throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                    this.label = 1;
                    Result2.throwOnFailure(result);
                    IntrinsicsJvm5 intrinsicsJvm5 = this;
                    Functions13 functions13 = createCoroutineUnintercepted;
                    if (functions13 != null) {
                        return ((Functions13) TypeIntrinsics.beforeCheckcastToFunctionOfArity(functions13, 2)).invoke(r, intrinsicsJvm5);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                }
            };
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return continuationImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> intercepted(Continuation<? super T> intercepted) {
        Continuation<T> continuation;
        Intrinsics.checkNotNullParameter(intercepted, "$this$intercepted");
        ContinuationImpl continuationImpl = !(intercepted instanceof ContinuationImpl) ? null : intercepted;
        return (continuationImpl == null || (continuation = (Continuation<T>) continuationImpl.intercepted()) == null) ? intercepted : continuation;
    }

    private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> continuation, final Functions2<? super Continuation<? super T>, ? extends Object> functions2) {
        ContinuationImpl continuationImpl;
        final CoroutineContext context = continuation.get$context();
        if (context == CoroutineContextImpl5.INSTANCE) {
            if (continuation == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
            continuationImpl = new ContinuationImpl4(continuation) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1
                private int label;

                @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
                protected Object invokeSuspend(Object result) {
                    int i = this.label;
                    if (i == 0) {
                        this.label = 1;
                        Result2.throwOnFailure(result);
                        return functions2.invoke(this);
                    }
                    if (i == 1) {
                        this.label = 2;
                        Result2.throwOnFailure(result);
                        return result;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            };
        } else if (continuation != null) {
            continuationImpl = new ContinuationImpl(continuation, context) { // from class: kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2
                private int label;

                @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
                protected Object invokeSuspend(Object result) {
                    int i = this.label;
                    if (i == 0) {
                        this.label = 1;
                        Result2.throwOnFailure(result);
                        return functions2.invoke(this);
                    }
                    if (i == 1) {
                        this.label = 2;
                        Result2.throwOnFailure(result);
                        return result;
                    }
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
            };
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return continuationImpl;
    }
}
