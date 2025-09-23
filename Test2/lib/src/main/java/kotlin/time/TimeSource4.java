package kotlin.time;

import kotlin.Annotations;
import kotlin.Annotations3;
import kotlin.Annotations8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeSource.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u001a\u001d\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0002\u0010\u0006*\\\b\u0007\u0010\u0007\"\u00020\b2\u00020\bB\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bB\u0002\b\fB<\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\"\b\u0010\u0012\u001e\b\u000bB\u001a\b\u0011\u0012\f\b\u0012\u0012\b\b\fJ\u0004\b\b(\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\n\b\u0016\u0012\u0006\b\n0\u00178\u0018*\\\b\u0007\u0010\u0019\"\u00020\u00022\u00020\u0002B\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000bB\u0002\b\fB<\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001a\u0012\"\b\u0010\u0012\u001e\b\u000bB\u001a\b\u0011\u0012\f\b\u0012\u0012\b\b\fJ\u0004\b\b(\u001b\u0012\b\b\u0014\u0012\u0004\b\b(\u001c\u0012\n\b\u0016\u0012\u0006\b\n0\u00178\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m17d2 = {"compareTo", "", "Lkotlin/time/TimeMark;", "other", "minus", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;Lkotlin/time/TimeMark;)D", "Clock", "Lkotlin/time/TimeSource;", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/time/ExperimentalTime;", "Lkotlin/Deprecated;", "message", "Use TimeSource interface instead.", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "kotlin.time.TimeSource", "expression", "TimeSource", "level", "Lkotlin/DeprecationLevel;", "ERROR", "ClockMark", "Use TimeMark class instead.", "kotlin.time.TimeMark", "TimeMark", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: kotlin.time.TimeSourceKt, reason: use source file name */
/* loaded from: classes.dex */
public final class TimeSource4 {
    @Annotations(level = Annotations3.ERROR, message = "Use TimeSource interface instead.", replaceWith = @Annotations8(expression = "TimeSource", imports = {"kotlin.time.TimeSource"}))
    public static /* synthetic */ void Clock$annotations() {
    }

    @Annotations(level = Annotations3.ERROR, message = "Use TimeMark class instead.", replaceWith = @Annotations8(expression = "TimeMark", imports = {"kotlin.time.TimeMark"}))
    public static /* synthetic */ void ClockMark$annotations() {
    }

    @Annotations(level = Annotations3.ERROR, message = "Subtracting one TimeMark from another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    private static final double minus(TimeSource3 minus, TimeSource3 other) {
        Intrinsics.checkNotNullParameter(minus, "$this$minus");
        throw new Error("Operation is disallowed.");
    }

    @Annotations(level = Annotations3.ERROR, message = "Comparing one TimeMark to another is not a well defined operation because these time marks could have been obtained from the different time sources.")
    private static final int compareTo(TimeSource3 compareTo, TimeSource3 other) {
        Intrinsics.checkNotNullParameter(compareTo, "$this$compareTo");
        throw new Error("Operation is disallowed.");
    }
}
