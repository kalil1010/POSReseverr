package kotlin.time;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.TimeSource;

/* compiled from: measureTime.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a3\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\b0\u0003H\u0087\bø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m17d2 = {"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)D", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)D", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: kotlin.time.MeasureTimeKt, reason: use source file name */
/* loaded from: classes.dex */
public final class measureTime {
    public static final double measureTime(Functions<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        TimeSource $this$measureTime$iv = TimeSource.Monotonic.INSTANCE;
        TimeSource3 mark$iv = $this$measureTime$iv.markNow();
        block.invoke();
        return mark$iv.mo1327elapsedNowUwyO8pc();
    }

    public static final double measureTime(TimeSource measureTime, Functions<Unit> block) {
        Intrinsics.checkNotNullParameter(measureTime, "$this$measureTime");
        Intrinsics.checkNotNullParameter(block, "block");
        TimeSource3 mark = measureTime.markNow();
        block.invoke();
        return mark.mo1327elapsedNowUwyO8pc();
    }

    public static final <T> TimedValue<T> measureTimedValue(Functions<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        TimeSource $this$measureTimedValue$iv = TimeSource.Monotonic.INSTANCE;
        TimeSource3 mark$iv = $this$measureTimedValue$iv.markNow();
        Object result$iv = block.invoke();
        return new TimedValue<>(result$iv, mark$iv.mo1327elapsedNowUwyO8pc(), null);
    }

    public static final <T> TimedValue<T> measureTimedValue(TimeSource measureTimedValue, Functions<? extends T> block) {
        Intrinsics.checkNotNullParameter(measureTimedValue, "$this$measureTimedValue");
        Intrinsics.checkNotNullParameter(block, "block");
        TimeSource3 mark = measureTimedValue.markNow();
        Object result = block.invoke();
        return new TimedValue<>(result, mark.mo1327elapsedNowUwyO8pc(), null);
    }
}
