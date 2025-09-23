package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TimeSource.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000b\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0007J\u001b\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0011"}, m17d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdjustment-UwyO8pc", "()D", "D", "getMark", "()Lkotlin/time/TimeMark;", "elapsedNow", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.time.AdjustedTimeMark, reason: use source file name */
/* loaded from: classes.dex */
final class TimeSource2 extends TimeSource3 {
    private final double adjustment;
    private final TimeSource3 mark;

    private TimeSource2(TimeSource3 mark, double adjustment) {
        this.mark = mark;
        this.adjustment = adjustment;
    }

    public /* synthetic */ TimeSource2(TimeSource3 mark, double adjustment, DefaultConstructorMarker $constructor_marker) {
        this(mark, adjustment);
    }

    /* renamed from: getAdjustment-UwyO8pc, reason: not valid java name and from getter */
    public final double getAdjustment() {
        return this.adjustment;
    }

    public final TimeSource3 getMark() {
        return this.mark;
    }

    @Override // kotlin.time.TimeSource3
    /* renamed from: elapsedNow-UwyO8pc */
    public double mo1327elapsedNowUwyO8pc() {
        return Duration.m1357minusLRDsOJo(this.mark.mo1327elapsedNowUwyO8pc(), this.adjustment);
    }

    @Override // kotlin.time.TimeSource3
    /* renamed from: plus-LRDsOJo */
    public TimeSource3 mo1328plusLRDsOJo(double duration) {
        return new TimeSource2(this.mark, Duration.m1358plusLRDsOJo(this.adjustment, duration), null);
    }
}
