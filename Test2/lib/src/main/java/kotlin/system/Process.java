package kotlin.system;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;

/* compiled from: Process.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b¨\u0006\u0004"}, m17d2 = {"exitProcess", "", NotificationCompat.CATEGORY_STATUS, "", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: kotlin.system.ProcessKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Process {
    private static final Void exitProcess(int status) {
        System.exit(status);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
