package kotlin;

import kotlin.LazyKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyJVM.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\t"}, m17d2 = {"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/LazyKt")
/* renamed from: kotlin.LazyKt__LazyJVMKt */
/* loaded from: classes.dex */
public class LazyJVM {
    public static final <T> Lazy<T> lazy(Functions<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new LazyJVM3(initializer, null, 2, null);
    }

    public static final <T> Lazy<T> lazy(Lazy4 mode, Functions<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        int i = LazyKt.WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            return new LazyJVM3(initializer, null, 2, null);
        }
        if (i == 2) {
            return new LazyJVM2(initializer);
        }
        if (i == 3) {
            return new Lazy6(initializer);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> Lazy<T> lazy(Object lock, Functions<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return new LazyJVM3(initializer, lock);
    }
}
