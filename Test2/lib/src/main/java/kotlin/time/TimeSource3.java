package kotlin.time;

import kotlin.Metadata;

/* compiled from: TimeSource.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u001b\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\r\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0010"}, m17d2 = {"Lkotlin/time/TimeMark;", "", "()V", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()D", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.time.TimeMark */
/* loaded from: classes.dex */
public abstract class TimeSource3 {
    /* renamed from: elapsedNow-UwyO8pc */
    public abstract double mo1327elapsedNowUwyO8pc();

    /* renamed from: plus-LRDsOJo */
    public TimeSource3 mo1328plusLRDsOJo(double duration) {
        return new TimeSource2(this, duration, null);
    }

    /* renamed from: minus-LRDsOJo */
    public TimeSource3 m1384minusLRDsOJo(double duration) {
        return mo1328plusLRDsOJo(Duration.m1375unaryMinusUwyO8pc(duration));
    }

    public final boolean hasPassedNow() {
        return !Duration.m1355isNegativeimpl(mo1327elapsedNowUwyO8pc());
    }

    public final boolean hasNotPassedNow() {
        return Duration.m1355isNegativeimpl(mo1327elapsedNowUwyO8pc());
    }
}
