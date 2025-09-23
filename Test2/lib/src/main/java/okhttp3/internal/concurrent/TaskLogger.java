package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PrimitiveCompanionObjects10;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: TaskLogger.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a5\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, m17d2 = {"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", "queue", "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", "T", "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: okhttp3.internal.concurrent.TaskLoggerKt, reason: use source file name */
/* loaded from: classes.dex */
public final class TaskLogger {
    public static final void taskLog(Task task, TaskQueue queue, Functions<String> messageBlock) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(messageBlock, "messageBlock");
        if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
            log(task, queue, messageBlock.invoke());
        }
    }

    public static final <T> T logElapsed(Task task, TaskQueue queue, Functions<? extends T> block) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(block, "block");
        long startNs = -1;
        boolean loggingEnabled = TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE);
        if (loggingEnabled) {
            startNs = queue.getTaskRunner$okhttp().getBackend().nanoTime();
            log(task, queue, "starting");
        }
        try {
            T tInvoke = block.invoke();
            InlineMarker.finallyStart(1);
            if (loggingEnabled) {
                log(task, queue, "finished run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - startNs));
            }
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            if (loggingEnabled) {
                long elapsedNs = queue.getTaskRunner$okhttp().getBackend().nanoTime() - startNs;
                if (0 != 0) {
                    log(task, queue, "finished run in " + formatDuration(elapsedNs));
                } else {
                    log(task, queue, "failed a run in " + formatDuration(elapsedNs));
                }
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue queue, String message) {
        Logger logger = TaskRunner.INSTANCE.getLogger();
        StringBuilder sb = new StringBuilder();
        sb.append(queue.getName$okhttp());
        sb.append(' ');
        PrimitiveCompanionObjects10 primitiveCompanionObjects10 = PrimitiveCompanionObjects10.INSTANCE;
        String str = String.format("%-22s", Arrays.copyOf(new Object[]{message}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        sb.append(str);
        sb.append(": ");
        sb.append(task.getName());
        logger.fine(sb.toString());
    }

    public static final String formatDuration(long ns) {
        String s;
        if (ns <= -999500000) {
            s = ((ns - 500000000) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS) + " s ";
        } else if (ns <= -999500) {
            s = ((ns - 500000) / 1000000) + " ms";
        } else if (ns <= 0) {
            s = ((ns - 500) / 1000) + " µs";
        } else if (ns < 999500) {
            s = ((500 + ns) / 1000) + " µs";
        } else if (ns < 999500000) {
            s = ((500000 + ns) / 1000000) + " ms";
        } else {
            s = ((500000000 + ns) / Http2Connection.DEGRADED_PONG_TIMEOUT_NS) + " s ";
        }
        PrimitiveCompanionObjects10 primitiveCompanionObjects10 = PrimitiveCompanionObjects10.INSTANCE;
        String str = String.format("%6s", Arrays.copyOf(new Object[]{s}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        return str;
    }
}
