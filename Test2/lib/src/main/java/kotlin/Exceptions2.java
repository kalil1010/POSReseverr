package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.internal.PlatformImplementations2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Exceptions.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u00004\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0007\u001a\r\u0010\u0010\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\f\u0010\u0015\u001a\u00020\u0016*\u00020\u0003H\u0007\"!\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, m17d2 = {"stackTrace", "", "Ljava/lang/StackTraceElement;", "", "getStackTrace$annotations", "(Ljava/lang/Throwable;)V", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "suppressedExceptions", "", "getSuppressedExceptions$annotations", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "addSuppressed", "", "exception", "printStackTrace", "stream", "Ljava/io/PrintStream;", "writer", "Ljava/io/PrintWriter;", "stackTraceToString", "", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/ExceptionsKt")
/* renamed from: kotlin.ExceptionsKt__ExceptionsKt, reason: use source file name */
/* loaded from: classes.dex */
public class Exceptions2 {
    public static /* synthetic */ void getStackTrace$annotations(Throwable th) {
    }

    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable th) {
    }

    private static final void printStackTrace(Throwable $this$printStackTrace) {
        if ($this$printStackTrace == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        }
        $this$printStackTrace.printStackTrace();
    }

    private static final void printStackTrace(Throwable $this$printStackTrace, PrintWriter writer) {
        if ($this$printStackTrace == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        }
        $this$printStackTrace.printStackTrace(writer);
    }

    private static final void printStackTrace(Throwable $this$printStackTrace, PrintStream stream) {
        if ($this$printStackTrace == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Throwable");
        }
        $this$printStackTrace.printStackTrace(stream);
    }

    public static final StackTraceElement[] getStackTrace(Throwable stackTrace) {
        Intrinsics.checkNotNullParameter(stackTrace, "$this$stackTrace");
        StackTraceElement[] stackTrace2 = stackTrace.getStackTrace();
        Intrinsics.checkNotNull(stackTrace2);
        return stackTrace2;
    }

    public static final String stackTraceToString(Throwable stackTraceToString) {
        Intrinsics.checkNotNullParameter(stackTraceToString, "$this$stackTraceToString");
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        stackTraceToString.printStackTrace(pw);
        pw.flush();
        String string = sw.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sw.toString()");
        return string;
    }

    public static final void addSuppressed(Throwable addSuppressed, Throwable exception) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(addSuppressed, "$this$addSuppressed");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (addSuppressed != exception) {
            PlatformImplementations2.IMPLEMENTATIONS.addSuppressed(addSuppressed, exception);
        }
    }

    public static final List<Throwable> getSuppressedExceptions(Throwable suppressedExceptions) {
        Intrinsics.checkNotNullParameter(suppressedExceptions, "$this$suppressedExceptions");
        return PlatformImplementations2.IMPLEMENTATIONS.getSuppressed(suppressedExceptions);
    }
}
