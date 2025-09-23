package kotlin;

import kotlin.jvm.functions.Functions;

/* compiled from: AssertionsJVM.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, m17d2 = {"assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/PreconditionsKt")
/* renamed from: kotlin.PreconditionsKt__AssertionsJVMKt */
/* loaded from: classes.dex */
class AssertionsJVM {
    /* renamed from: assert */
    private static final void m73assert(boolean value) {
        if (AssertionsJVM2.ENABLED && !value) {
            throw new AssertionError("Assertion failed");
        }
    }

    /* renamed from: assert */
    private static final void m74assert(boolean value, Functions<? extends Object> functions) {
        if (AssertionsJVM2.ENABLED && !value) {
            Object message = functions.invoke();
            throw new AssertionError(message);
        }
    }
}
