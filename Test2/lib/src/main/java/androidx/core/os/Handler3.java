package androidx.core.os;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions;

/* compiled from: Handler.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m17d2 = {"<anonymous>", "", "run"}, m18k = 3, m19mv = {1, 1, 16})
/* renamed from: androidx.core.os.HandlerKt$postAtTime$runnable$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Handler3 implements Runnable {
    final /* synthetic */ Functions $action;

    public Handler3(Functions functions) {
        this.$action = functions;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
