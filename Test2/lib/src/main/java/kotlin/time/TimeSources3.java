package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.PrimitiveCompanionObjects8;

/* compiled from: TimeSources.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m17d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(D)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.time.TestTimeSource, reason: use source file name */
/* loaded from: classes.dex */
public final class TimeSources3 extends TimeSources2 {
    private long reading;

    public TimeSources3() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.time.TimeSources2
    /* renamed from: read, reason: from getter */
    protected long getReading() {
        return this.reading;
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1383plusAssignLRDsOJo(double duration) {
        long newReading;
        double delta = Duration.m1366toDoubleimpl(duration, getUnit());
        long longDelta = (long) delta;
        if (longDelta != Long.MIN_VALUE && longDelta != PrimitiveCompanionObjects8.MAX_VALUE) {
            long j = this.reading;
            newReading = j + longDelta;
            if ((j ^ longDelta) >= 0 && (j ^ newReading) < 0) {
                m1382overflowLRDsOJo(duration);
            }
        } else {
            double newReading2 = this.reading + delta;
            if (newReading2 > PrimitiveCompanionObjects8.MAX_VALUE || newReading2 < Long.MIN_VALUE) {
                m1382overflowLRDsOJo(duration);
            }
            newReading = (long) newReading2;
        }
        this.reading = newReading;
    }

    /* renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1382overflowLRDsOJo(double duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + Duration.m1372toStringimpl(duration) + '.');
    }
}
