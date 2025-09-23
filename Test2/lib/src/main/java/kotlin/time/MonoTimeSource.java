package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* compiled from: MonoTimeSource.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bÁ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, m17d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "()V", "read", "", "toString", "", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.time.MonotonicTimeSource */
/* loaded from: classes.dex */
public final class MonoTimeSource extends TimeSources2 implements TimeSource {
    public static final MonoTimeSource INSTANCE = new MonoTimeSource();

    private MonoTimeSource() {
        super(TimeUnit.NANOSECONDS);
    }

    @Override // kotlin.time.TimeSources2
    /* renamed from: read */
    protected long getReading() {
        return System.nanoTime();
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
