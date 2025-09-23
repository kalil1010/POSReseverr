package androidx.core.os;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Handler.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b\u001a1\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b¨\u0006\f"}, m17d2 = {"postAtTime", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "uptimeMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postDelayed", "delayInMillis", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.os.HandlerKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Handler2 {
    public static /* synthetic */ Runnable postDelayed$default(Handler postDelayed, long delayInMillis, Object token, Functions action, int i, Object obj) {
        if ((i & 2) != 0) {
            token = null;
        }
        Intrinsics.checkParameterIsNotNull(postDelayed, "$this$postDelayed");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Runnable runnable = new Handler4(action);
        if (token == null) {
            postDelayed.postDelayed(runnable, delayInMillis);
        } else {
            HandlerCompat.postDelayed(postDelayed, runnable, token, delayInMillis);
        }
        return runnable;
    }

    public static final Runnable postDelayed(Handler postDelayed, long delayInMillis, Object token, Functions<Unit> action) {
        Intrinsics.checkParameterIsNotNull(postDelayed, "$this$postDelayed");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Runnable runnable = new Handler4(action);
        if (token == null) {
            postDelayed.postDelayed(runnable, delayInMillis);
        } else {
            HandlerCompat.postDelayed(postDelayed, runnable, token, delayInMillis);
        }
        return runnable;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler postAtTime, long uptimeMillis, Object token, Functions action, int i, Object obj) {
        if ((i & 2) != 0) {
            token = null;
        }
        Intrinsics.checkParameterIsNotNull(postAtTime, "$this$postAtTime");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Runnable runnable = new Handler3(action);
        postAtTime.postAtTime(runnable, token, uptimeMillis);
        return runnable;
    }

    public static final Runnable postAtTime(Handler postAtTime, long uptimeMillis, Object token, Functions<Unit> action) {
        Intrinsics.checkParameterIsNotNull(postAtTime, "$this$postAtTime");
        Intrinsics.checkParameterIsNotNull(action, "action");
        Runnable runnable = new Handler3(action);
        postAtTime.postAtTime(runnable, token, uptimeMillis);
        return runnable;
    }
}
