package kotlin;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContextImpl5;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Functions17;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: DeepRecursive.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004BK\u00129\u0010\u0005\u001a5\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b\u0012\u0006\u0010\t\u001a\u00028\u0000ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u0015\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0016Jc\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000429\u0010\u0018\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u000b\u0010\u001d\u001a\u00028\u0001¢\u0006\u0002\u0010\u001eJ5\u0010\u0015\u001a\u0002H\u001f\"\u0004\b\u0002\u0010 \"\u0004\b\u0003\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u001f0!2\u0006\u0010\t\u001a\u0002H H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\"R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fRF\u0010\u0010\u001a5\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0002\b\bX\u0082\u000eø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0011R\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006#"}, m17d2 = {"Lkotlin/DeepRecursiveScopeImpl;", "T", "R", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function3;", "", "Lkotlin/ExtensionFunctionType;", "value", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;)V", "cont", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "function", "Lkotlin/jvm/functions/Function3;", "result", "Lkotlin/Result;", "Ljava/lang/Object;", "callRecursive", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "crossFunctionCompletion", "currentFunction", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "resumeWith", "", "(Ljava/lang/Object;)V", "runCallLoop", "()Ljava/lang/Object;", "S", "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.DeepRecursiveScopeImpl, reason: use source file name */
/* loaded from: classes.dex */
final class DeepRecursive4<T, R> extends DeepRecursive3<T, R> implements Continuation<R> {
    private Continuation<Object> cont;
    private Functions17<? super DeepRecursive3<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function;
    private Object result;
    private Object value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeepRecursive4(Functions17<? super DeepRecursive3<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> block, T t) {
        super(null);
        Intrinsics.checkNotNullParameter(block, "block");
        this.function = block;
        this.value = t;
        this.cont = this;
        this.result = DeepRecursive2.UNDEFINED_RESULT;
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public CoroutineContext get$context() {
        return CoroutineContextImpl5.INSTANCE;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        this.cont = (Continuation) null;
        this.result = result;
    }

    @Override // kotlin.DeepRecursive3
    public Object callRecursive(T t, Continuation<? super R> continuation) {
        if (continuation != null) {
            this.cont = continuation;
            this.value = t;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return coroutine_suspended;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    @Override // kotlin.DeepRecursive3
    public <U, S> Object callRecursive(DeepRecursive<U, S> deepRecursive, U u, Continuation<? super S> continuation) {
        Functions17 function = deepRecursive.getBlock$kotlin_stdlib();
        if (function == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.DeepRecursiveFunctionBlock /* = suspend kotlin.DeepRecursiveScope<*, *>.(kotlin.Any?) -> kotlin.Any? */");
        }
        DeepRecursive4<T, R> $this$with = this;
        Functions17 currentFunction = $this$with.function;
        if (function != currentFunction) {
            $this$with.function = function;
            if (continuation != null) {
                $this$with.cont = $this$with.crossFunctionCompletion(currentFunction, continuation);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
        } else if (continuation != null) {
            $this$with.cont = continuation;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        $this$with.value = u;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    private final Continuation<Object> crossFunctionCompletion(final Functions17<? super DeepRecursive3<?, ?>, Object, ? super Continuation<Object>, ? extends Object> currentFunction, final Continuation<Object> cont) {
        final CoroutineContextImpl5 coroutineContextImpl5 = CoroutineContextImpl5.INSTANCE;
        return new Continuation<Object>() { // from class: kotlin.DeepRecursiveScopeImpl$crossFunctionCompletion$$inlined$Continuation$1
            @Override // kotlin.coroutines.Continuation
            /* renamed from: getContext, reason: from getter */
            public CoroutineContext get$context() {
                return coroutineContextImpl5;
            }

            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object result) {
                this.function = currentFunction;
                this.cont = cont;
                this.result = result;
            }
        };
    }

    public final R runCallLoop() {
        while (true) {
            R r = (R) this.result;
            Continuation<Object> continuation = this.cont;
            if (continuation != null) {
                if (!Result.m78equalsimpl0(DeepRecursive2.UNDEFINED_RESULT, r)) {
                    this.result = DeepRecursive2.UNDEFINED_RESULT;
                    continuation.resumeWith(r);
                } else {
                    try {
                        Functions17<? super DeepRecursive3<?, ?>, Object, ? super Continuation<Object>, ? extends Object> functions17 = this.function;
                        Object obj = this.value;
                        if (functions17 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type (R, P, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                        }
                        Object objInvoke = ((Functions17) TypeIntrinsics.beforeCheckcastToFunctionOfArity(functions17, 3)).invoke(this, obj, continuation);
                        if (objInvoke != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            Result.Companion companion = Result.INSTANCE;
                            continuation.resumeWith(Result.m76constructorimpl(objInvoke));
                        }
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation.resumeWith(Result.m76constructorimpl(Result2.createFailure(th)));
                    }
                }
            } else {
                Result2.throwOnFailure(r);
                return r;
            }
        }
    }
}
