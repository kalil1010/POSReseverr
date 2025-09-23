package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedUtils;

/* compiled from: UProgressionUtil.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a*\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m17d2 = {"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: kotlin.internal.UProgressionUtilKt */
/* loaded from: classes.dex */
public final class UProgressionUtil {
    /* renamed from: differenceModulo-WZ9TVnA */
    private static final int m1240differenceModuloWZ9TVnA(int a, int b, int c) {
        int ac = UnsignedUtils.m392uintRemainderJ1ME1BU(a, c);
        int bc = UnsignedUtils.m392uintRemainderJ1ME1BU(b, c);
        return UInt.m162constructorimpl(UnsignedUtils.uintCompare(ac, bc) >= 0 ? ac - bc : UInt.m162constructorimpl(ac - bc) + c);
    }

    /* renamed from: differenceModulo-sambcqE */
    private static final long m1241differenceModulosambcqE(long a, long b, long c) {
        long ac = UnsignedUtils.m394ulongRemaindereb3DHEI(a, c);
        long bc = UnsignedUtils.m394ulongRemaindereb3DHEI(b, c);
        return ULong.m232constructorimpl(UnsignedUtils.ulongCompare(ac, bc) >= 0 ? ac - bc : ULong.m232constructorimpl(ac - bc) + c);
    }

    /* renamed from: getProgressionLastElement-Nkh28Cs */
    public static final int m1243getProgressionLastElementNkh28Cs(int start, int end, int step) {
        if (step > 0) {
            if (UnsignedUtils.uintCompare(start, end) < 0) {
                return UInt.m162constructorimpl(end - m1240differenceModuloWZ9TVnA(end, start, UInt.m162constructorimpl(step)));
            }
        } else {
            if (step >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (UnsignedUtils.uintCompare(start, end) > 0) {
                return UInt.m162constructorimpl(m1240differenceModuloWZ9TVnA(start, end, UInt.m162constructorimpl(-step)) + end);
            }
        }
        return end;
    }

    /* renamed from: getProgressionLastElement-7ftBX0g */
    public static final long m1242getProgressionLastElement7ftBX0g(long start, long end, long step) {
        if (step > 0) {
            if (UnsignedUtils.ulongCompare(start, end) < 0) {
                return ULong.m232constructorimpl(end - m1241differenceModulosambcqE(end, start, ULong.m232constructorimpl(step)));
            }
        } else {
            if (step >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (UnsignedUtils.ulongCompare(start, end) > 0) {
                return ULong.m232constructorimpl(m1241differenceModulosambcqE(start, end, ULong.m232constructorimpl(-step)) + end);
            }
        }
        return end;
    }
}
