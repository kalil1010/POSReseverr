package kotlin;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepRecursive.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J5\u0010\u0005\u001a\u0002H\b\"\u0004\b\u0002\u0010\t\"\u0004\b\u0003\u0010\b*\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u0006\u001a\u0002H\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\f\u001a\u00020\r*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0087\u0002\u0082\u0001\u0001\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m17d2 = {"Lkotlin/DeepRecursiveScope;", "T", "R", "", "()V", "callRecursive", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "S", "U", "Lkotlin/DeepRecursiveFunction;", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "", "Lkotlin/DeepRecursiveScopeImpl;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.DeepRecursiveScope, reason: use source file name */
/* loaded from: classes.dex */
public abstract class DeepRecursive3<T, R> {
    public abstract Object callRecursive(T t, Continuation<? super R> continuation);

    public abstract <U, S> Object callRecursive(DeepRecursive<U, S> deepRecursive, U u, Continuation<? super S> continuation);

    private DeepRecursive3() {
    }

    public /* synthetic */ DeepRecursive3(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    @Annotations(level = Annotations3.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @Annotations8(expression = "this.callRecursive(value)", imports = {}))
    public final Void invoke(DeepRecursive<?, ?> invoke, Object value) {
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }
}
