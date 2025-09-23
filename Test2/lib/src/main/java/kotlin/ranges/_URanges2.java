package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandom;
import okhttp3.internal.p005ws.WebSocketProtocol;

/* compiled from: _URanges.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\n\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001e\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0004\u001a\u001e\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007\u001a\u001e\u0010\u000e\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u001e\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\r\u001a&\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a&\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a&\u0010\u0014\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a$\u0010\u0014\u001a\u00020\b*\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\nø\u0001\u0000¢\u0006\u0002\b*\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\b\u0010)\u001a\u0004\u0018\u00010\bH\u0087\nø\u0001\u0000¢\u0006\u0002\b4\u001a\u001f\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001f\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u001f\u00107\u001a\u00020>*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001f\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u0015\u0010C\u001a\u00020\u0005*\u00020%H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010D\u001a\u001c\u0010C\u001a\u00020\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010F\u001a\u0015\u0010C\u001a\u00020\b*\u00020/H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010G\u001a\u001c\u0010C\u001a\u00020\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000¢\u0006\u0002\u0010H\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0087\bø\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000\u001a\u0012\u0010I\u001a\u0004\u0018\u00010\b*\u00020/H\u0087\bø\u0001\u0000\u001a\u0019\u0010I\u001a\u0004\u0018\u00010\b*\u00020/2\u0006\u0010C\u001a\u00020EH\u0007ø\u0001\u0000\u001a\f\u0010J\u001a\u000208*\u000208H\u0007\u001a\f\u0010J\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010K\u001a\u000208*\u0002082\u0006\u0010K\u001a\u00020LH\u0087\u0004\u001a\u0015\u0010K\u001a\u00020>*\u00020>2\u0006\u0010K\u001a\u00020MH\u0087\u0004\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a\u001f\u0010N\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a\u001f\u0010N\u001a\u00020/*\u00020\b2\u0006\u00109\u001a\u00020\bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001f\u0010N\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006W"}, m17d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/ranges/URangesKt")
/* renamed from: kotlin.ranges.URangesKt___URangesKt, reason: use source file name */
/* loaded from: classes.dex */
class _URanges2 {
    private static final int random(UIntRange $this$random) {
        return _URanges.random($this$random, Random.INSTANCE);
    }

    private static final long random(ULongRange $this$random) {
        return _URanges.random($this$random, Random.INSTANCE);
    }

    public static final int random(UIntRange random, Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        try {
            return URandom.nextUInt(random2, random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(ULongRange random, Random random2) {
        Intrinsics.checkNotNullParameter(random, "$this$random");
        Intrinsics.checkNotNullParameter(random2, "random");
        try {
            return URandom.nextULong(random2, random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange $this$randomOrNull) {
        return _URanges.randomOrNull($this$randomOrNull, Random.INSTANCE);
    }

    private static final ULong randomOrNull(ULongRange $this$randomOrNull) {
        return _URanges.randomOrNull($this$randomOrNull, Random.INSTANCE);
    }

    public static final UInt randomOrNull(UIntRange randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.m156boximpl(URandom.nextUInt(random, randomOrNull));
    }

    public static final ULong randomOrNull(ULongRange randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter(randomOrNull, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.m226boximpl(URandom.nextULong(random, randomOrNull));
    }

    /* renamed from: contains-biwQdVI, reason: not valid java name */
    private static final boolean m1288containsbiwQdVI(UIntRange contains, UInt element) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return element != null && contains.m1260containsWZ4Q5Ns(element.getData());
    }

    /* renamed from: contains-GYNo2lE, reason: not valid java name */
    private static final boolean m1284containsGYNo2lE(ULongRange contains, ULong element) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return element != null && contains.m1266containsVKZWuLQ(element.getData());
    }

    /* renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m1283contains68kG9v0(UIntRange contains, byte value) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1260containsWZ4Q5Ns(UInt.m162constructorimpl(value & UByte.MAX_VALUE));
    }

    /* renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m1286containsULbyJY(ULongRange contains, byte value) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1266containsVKZWuLQ(ULong.m232constructorimpl(value & 255));
    }

    /* renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m1285containsGab390E(ULongRange contains, int value) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1266containsVKZWuLQ(ULong.m232constructorimpl(value & 4294967295L));
    }

    /* renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m1289containsfz5IDCE(UIntRange contains, long value) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return ULong.m232constructorimpl(value >>> 32) == 0 && contains.m1260containsWZ4Q5Ns(UInt.m162constructorimpl((int) value));
    }

    /* renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m1287containsZsK3CEQ(UIntRange contains, short value) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1260containsWZ4Q5Ns(UInt.m162constructorimpl(65535 & value));
    }

    /* renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m1290containsuhHAxoY(ULongRange contains, short value) {
        Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m1266containsVKZWuLQ(ULong.m232constructorimpl(value & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final UIntRange2 m1293downToKr8caGY(byte $this$downTo, byte to) {
        return UIntRange2.INSTANCE.m1259fromClosedRangeNkh28Cs(UInt.m162constructorimpl($this$downTo & UByte.MAX_VALUE), UInt.m162constructorimpl(to & UByte.MAX_VALUE), -1);
    }

    /* renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final UIntRange2 m1292downToJ1ME1BU(int $this$downTo, int to) {
        return UIntRange2.INSTANCE.m1259fromClosedRangeNkh28Cs($this$downTo, to, -1);
    }

    /* renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final ULongRange2 m1294downToeb3DHEI(long $this$downTo, long to) {
        return ULongRange2.INSTANCE.m1265fromClosedRange7ftBX0g($this$downTo, to, -1L);
    }

    /* renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final UIntRange2 m1291downTo5PvTz6A(short $this$downTo, short to) {
        return UIntRange2.INSTANCE.m1259fromClosedRangeNkh28Cs(UInt.m162constructorimpl($this$downTo & UShort.MAX_VALUE), UInt.m162constructorimpl(65535 & to), -1);
    }

    public static final UIntRange2 reversed(UIntRange2 reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        return UIntRange2.INSTANCE.m1259fromClosedRangeNkh28Cs(reversed.getLast(), reversed.getFirst(), -reversed.getStep());
    }

    public static final ULongRange2 reversed(ULongRange2 reversed) {
        Intrinsics.checkNotNullParameter(reversed, "$this$reversed");
        return ULongRange2.INSTANCE.m1265fromClosedRange7ftBX0g(reversed.getLast(), reversed.getFirst(), -reversed.getStep());
    }

    public static final UIntRange2 step(UIntRange2 step, int step2) {
        Intrinsics.checkNotNullParameter(step, "$this$step");
        RangesKt.checkStepIsPositive(step2 > 0, Integer.valueOf(step2));
        return UIntRange2.INSTANCE.m1259fromClosedRangeNkh28Cs(step.getFirst(), step.getLast(), step.getStep() > 0 ? step2 : -step2);
    }

    public static final ULongRange2 step(ULongRange2 step, long step2) {
        Intrinsics.checkNotNullParameter(step, "$this$step");
        RangesKt.checkStepIsPositive(step2 > 0, Long.valueOf(step2));
        return ULongRange2.INSTANCE.m1265fromClosedRange7ftBX0g(step.getFirst(), step.getLast(), step.getStep() > 0 ? step2 : -step2);
    }

    /* renamed from: until-Kr8caGY, reason: not valid java name */
    public static final UIntRange m1297untilKr8caGY(byte $this$until, byte to) {
        return Intrinsics.compare(to & UByte.MAX_VALUE, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m162constructorimpl($this$until & UByte.MAX_VALUE), UInt.m162constructorimpl(UInt.m162constructorimpl(to & UByte.MAX_VALUE) - 1), null);
    }

    /* renamed from: until-J1ME1BU, reason: not valid java name */
    public static final UIntRange m1296untilJ1ME1BU(int $this$until, int to) {
        return UnsignedUtils.uintCompare(to, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange($this$until, UInt.m162constructorimpl(to - 1), null);
    }

    /* renamed from: until-eb3DHEI, reason: not valid java name */
    public static final ULongRange m1298untileb3DHEI(long $this$until, long to) {
        return UnsignedUtils.ulongCompare(to, 0L) <= 0 ? ULongRange.INSTANCE.getEMPTY() : new ULongRange($this$until, ULong.m232constructorimpl(to - ULong.m232constructorimpl(1 & 4294967295L)), null);
    }

    /* renamed from: until-5PvTz6A, reason: not valid java name */
    public static final UIntRange m1295until5PvTz6A(short $this$until, short to) {
        return Intrinsics.compare(to & UShort.MAX_VALUE, 0) <= 0 ? UIntRange.INSTANCE.getEMPTY() : new UIntRange(UInt.m162constructorimpl($this$until & UShort.MAX_VALUE), UInt.m162constructorimpl(UInt.m162constructorimpl(65535 & to) - 1), null);
    }

    /* renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m1270coerceAtLeastJ1ME1BU(int $this$coerceAtLeast, int minimumValue) {
        return UnsignedUtils.uintCompare($this$coerceAtLeast, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast;
    }

    /* renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m1272coerceAtLeasteb3DHEI(long $this$coerceAtLeast, long minimumValue) {
        return UnsignedUtils.ulongCompare($this$coerceAtLeast, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast;
    }

    /* renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m1271coerceAtLeastKr8caGY(byte $this$coerceAtLeast, byte minimumValue) {
        return Intrinsics.compare($this$coerceAtLeast & UByte.MAX_VALUE, minimumValue & UByte.MAX_VALUE) < 0 ? minimumValue : $this$coerceAtLeast;
    }

    /* renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m1269coerceAtLeast5PvTz6A(short $this$coerceAtLeast, short minimumValue) {
        return Intrinsics.compare($this$coerceAtLeast & UShort.MAX_VALUE, 65535 & minimumValue) < 0 ? minimumValue : $this$coerceAtLeast;
    }

    /* renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m1274coerceAtMostJ1ME1BU(int $this$coerceAtMost, int maximumValue) {
        return UnsignedUtils.uintCompare($this$coerceAtMost, maximumValue) > 0 ? maximumValue : $this$coerceAtMost;
    }

    /* renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m1276coerceAtMosteb3DHEI(long $this$coerceAtMost, long maximumValue) {
        return UnsignedUtils.ulongCompare($this$coerceAtMost, maximumValue) > 0 ? maximumValue : $this$coerceAtMost;
    }

    /* renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m1275coerceAtMostKr8caGY(byte $this$coerceAtMost, byte maximumValue) {
        return Intrinsics.compare($this$coerceAtMost & UByte.MAX_VALUE, maximumValue & UByte.MAX_VALUE) > 0 ? maximumValue : $this$coerceAtMost;
    }

    /* renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m1273coerceAtMost5PvTz6A(short $this$coerceAtMost, short maximumValue) {
        return Intrinsics.compare($this$coerceAtMost & UShort.MAX_VALUE, 65535 & maximumValue) > 0 ? maximumValue : $this$coerceAtMost;
    }

    /* renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m1279coerceInWZ9TVnA(int $this$coerceIn, int minimumValue, int maximumValue) {
        if (UnsignedUtils.uintCompare(minimumValue, maximumValue) <= 0) {
            return UnsignedUtils.uintCompare($this$coerceIn, minimumValue) < 0 ? minimumValue : UnsignedUtils.uintCompare($this$coerceIn, maximumValue) > 0 ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m199toStringimpl(maximumValue) + " is less than minimum " + UInt.m199toStringimpl(minimumValue) + '.');
    }

    /* renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m1281coerceInsambcqE(long $this$coerceIn, long minimumValue, long maximumValue) {
        if (UnsignedUtils.ulongCompare(minimumValue, maximumValue) <= 0) {
            return UnsignedUtils.ulongCompare($this$coerceIn, minimumValue) < 0 ? minimumValue : UnsignedUtils.ulongCompare($this$coerceIn, maximumValue) > 0 ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m269toStringimpl(maximumValue) + " is less than minimum " + ULong.m269toStringimpl(minimumValue) + '.');
    }

    /* renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m1280coerceInb33U2AM(byte $this$coerceIn, byte minimumValue, byte maximumValue) {
        if (Intrinsics.compare(minimumValue & UByte.MAX_VALUE, maximumValue & UByte.MAX_VALUE) <= 0) {
            return Intrinsics.compare($this$coerceIn & UByte.MAX_VALUE, minimumValue & UByte.MAX_VALUE) < 0 ? minimumValue : Intrinsics.compare($this$coerceIn & UByte.MAX_VALUE, maximumValue & UByte.MAX_VALUE) > 0 ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.m129toStringimpl(maximumValue) + " is less than minimum " + UByte.m129toStringimpl(minimumValue) + '.');
    }

    /* renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m1278coerceInVKSA0NQ(short $this$coerceIn, short minimumValue, short maximumValue) {
        if (Intrinsics.compare(minimumValue & UShort.MAX_VALUE, maximumValue & UShort.MAX_VALUE) <= 0) {
            return Intrinsics.compare($this$coerceIn & UShort.MAX_VALUE, minimumValue & UShort.MAX_VALUE) < 0 ? minimumValue : Intrinsics.compare($this$coerceIn & UShort.MAX_VALUE, 65535 & maximumValue) > 0 ? maximumValue : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.m365toStringimpl(maximumValue) + " is less than minimum " + UShort.m365toStringimpl(minimumValue) + '.');
    }

    /* renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m1282coerceInwuiCnnA(int $this$coerceIn, Range3<UInt> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof Ranges4) {
            return ((UInt) RangesKt.coerceIn(UInt.m156boximpl($this$coerceIn), (Ranges4<UInt>) range)).getData();
        }
        if (!range.isEmpty()) {
            return UnsignedUtils.uintCompare($this$coerceIn, ((UInt) range.getStart()).getData()) < 0 ? ((UInt) range.getStart()).getData() : UnsignedUtils.uintCompare($this$coerceIn, ((UInt) range.getEndInclusive()).getData()) > 0 ? ((UInt) range.getEndInclusive()).getData() : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    /* renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m1277coerceInJPwROB0(long $this$coerceIn, Range3<ULong> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof Ranges4) {
            return ((ULong) RangesKt.coerceIn(ULong.m226boximpl($this$coerceIn), (Ranges4<ULong>) range)).getData();
        }
        if (!range.isEmpty()) {
            return UnsignedUtils.ulongCompare($this$coerceIn, ((ULong) range.getStart()).getData()) < 0 ? ((ULong) range.getStart()).getData() : UnsignedUtils.ulongCompare($this$coerceIn, ((ULong) range.getEndInclusive()).getData()) > 0 ? ((ULong) range.getEndInclusive()).getData() : $this$coerceIn;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }
}
