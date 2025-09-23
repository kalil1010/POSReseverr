package kotlin;

import kotlin.ranges.ULongRange;
import okhttp3.internal.p005ws.WebSocketProtocol;

/* compiled from: ULong.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001mB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\rHÖ\u0001J\u0016\u0010'\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0005J\u0016\u0010)\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u0005J\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001dJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u001fJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b.\u0010\u000bJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\"J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b1\u0010\u000bJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001dJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u001fJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u000bJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\"J\u001b\u00107\u001a\u0002082\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001dJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u001fJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\"J\u001e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010\u001fJ\u001e\u0010C\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u001dJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bG\u0010\u001fJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bH\u0010\u000bJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\"J\u0010\u0010J\u001a\u00020KH\u0087\b¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\rH\u0087\b¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bZ\u0010\u0005J\u0010\u0010[\u001a\u00020\\H\u0087\b¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020`H\u0016¢\u0006\u0004\ba\u0010bJ\u0016\u0010c\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bd\u0010MJ\u0016\u0010e\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bf\u0010XJ\u0016\u0010g\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bh\u0010\u0005J\u0016\u0010i\u001a\u00020\u0016H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bj\u0010^J\u001b\u0010k\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bl\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006n"}, m17d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "hashCode", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class ULong implements Comparable<ULong> {
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    /* renamed from: box-impl */
    public static final /* synthetic */ ULong m226boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: compareTo-VKZWuLQ */
    private int m228compareToVKZWuLQ(long j) {
        return m229compareToVKZWuLQ(this.data, j);
    }

    /* renamed from: equals-impl */
    public static boolean m238equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).getData();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m239equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m240hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public boolean equals(Object other) {
        return m238equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m240hashCodeimpl(this.data);
    }

    public String toString() {
        return m269toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ long getData() {
        return this.data;
    }

    private /* synthetic */ ULong(long data) {
        this.data = data;
    }

    /* renamed from: constructor-impl */
    public static long m232constructorimpl(long data) {
        return data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return m228compareToVKZWuLQ(uLong.getData());
    }

    /* renamed from: compareTo-7apg3OU */
    private static final int m227compareTo7apg3OU(long $this, byte other) {
        return UnsignedUtils.ulongCompare($this, m232constructorimpl(other & 255));
    }

    /* renamed from: compareTo-xj2QHRw */
    private static final int m231compareToxj2QHRw(long $this, short other) {
        return UnsignedUtils.ulongCompare($this, m232constructorimpl(other & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: compareTo-WZ4Q5Ns */
    private static final int m230compareToWZ4Q5Ns(long $this, int other) {
        return UnsignedUtils.ulongCompare($this, m232constructorimpl(other & 4294967295L));
    }

    /* renamed from: compareTo-VKZWuLQ */
    private static int m229compareToVKZWuLQ(long $this, long other) {
        return UnsignedUtils.ulongCompare($this, other);
    }

    /* renamed from: plus-7apg3OU */
    private static final long m248plus7apg3OU(long $this, byte other) {
        return m232constructorimpl(m232constructorimpl(other & 255) + $this);
    }

    /* renamed from: plus-xj2QHRw */
    private static final long m251plusxj2QHRw(long $this, short other) {
        return m232constructorimpl(m232constructorimpl(other & WebSocketProtocol.PAYLOAD_SHORT_MAX) + $this);
    }

    /* renamed from: plus-WZ4Q5Ns */
    private static final long m250plusWZ4Q5Ns(long $this, int other) {
        return m232constructorimpl(m232constructorimpl(other & 4294967295L) + $this);
    }

    /* renamed from: plus-VKZWuLQ */
    private static final long m249plusVKZWuLQ(long $this, long other) {
        return m232constructorimpl($this + other);
    }

    /* renamed from: minus-7apg3OU */
    private static final long m243minus7apg3OU(long $this, byte other) {
        return m232constructorimpl($this - m232constructorimpl(other & 255));
    }

    /* renamed from: minus-xj2QHRw */
    private static final long m246minusxj2QHRw(long $this, short other) {
        return m232constructorimpl($this - m232constructorimpl(other & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: minus-WZ4Q5Ns */
    private static final long m245minusWZ4Q5Ns(long $this, int other) {
        return m232constructorimpl($this - m232constructorimpl(other & 4294967295L));
    }

    /* renamed from: minus-VKZWuLQ */
    private static final long m244minusVKZWuLQ(long $this, long other) {
        return m232constructorimpl($this - other);
    }

    /* renamed from: times-7apg3OU */
    private static final long m259times7apg3OU(long $this, byte other) {
        return m232constructorimpl(m232constructorimpl(other & 255) * $this);
    }

    /* renamed from: times-xj2QHRw */
    private static final long m262timesxj2QHRw(long $this, short other) {
        return m232constructorimpl(m232constructorimpl(other & WebSocketProtocol.PAYLOAD_SHORT_MAX) * $this);
    }

    /* renamed from: times-WZ4Q5Ns */
    private static final long m261timesWZ4Q5Ns(long $this, int other) {
        return m232constructorimpl(m232constructorimpl(other & 4294967295L) * $this);
    }

    /* renamed from: times-VKZWuLQ */
    private static final long m260timesVKZWuLQ(long $this, long other) {
        return m232constructorimpl($this * other);
    }

    /* renamed from: div-7apg3OU */
    private static final long m234div7apg3OU(long $this, byte other) {
        return UnsignedUtils.m393ulongDivideeb3DHEI($this, m232constructorimpl(other & 255));
    }

    /* renamed from: div-xj2QHRw */
    private static final long m237divxj2QHRw(long $this, short other) {
        return UnsignedUtils.m393ulongDivideeb3DHEI($this, m232constructorimpl(other & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: div-WZ4Q5Ns */
    private static final long m236divWZ4Q5Ns(long $this, int other) {
        return UnsignedUtils.m393ulongDivideeb3DHEI($this, m232constructorimpl(other & 4294967295L));
    }

    /* renamed from: div-VKZWuLQ */
    private static final long m235divVKZWuLQ(long $this, long other) {
        return UnsignedUtils.m393ulongDivideeb3DHEI($this, other);
    }

    /* renamed from: rem-7apg3OU */
    private static final long m253rem7apg3OU(long $this, byte other) {
        return UnsignedUtils.m394ulongRemaindereb3DHEI($this, m232constructorimpl(other & 255));
    }

    /* renamed from: rem-xj2QHRw */
    private static final long m256remxj2QHRw(long $this, short other) {
        return UnsignedUtils.m394ulongRemaindereb3DHEI($this, m232constructorimpl(other & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: rem-WZ4Q5Ns */
    private static final long m255remWZ4Q5Ns(long $this, int other) {
        return UnsignedUtils.m394ulongRemaindereb3DHEI($this, m232constructorimpl(other & 4294967295L));
    }

    /* renamed from: rem-VKZWuLQ */
    private static final long m254remVKZWuLQ(long $this, long other) {
        return UnsignedUtils.m394ulongRemaindereb3DHEI($this, other);
    }

    /* renamed from: inc-s-VKNKU */
    private static final long m241incsVKNKU(long $this) {
        return m232constructorimpl(1 + $this);
    }

    /* renamed from: dec-s-VKNKU */
    private static final long m233decsVKNKU(long $this) {
        return m232constructorimpl((-1) + $this);
    }

    /* renamed from: rangeTo-VKZWuLQ */
    private static final ULongRange m252rangeToVKZWuLQ(long $this, long other) {
        return new ULongRange($this, other, null);
    }

    /* renamed from: shl-s-VKNKU */
    private static final long m257shlsVKNKU(long $this, int bitCount) {
        return m232constructorimpl($this << bitCount);
    }

    /* renamed from: shr-s-VKNKU */
    private static final long m258shrsVKNKU(long $this, int bitCount) {
        return m232constructorimpl($this >>> bitCount);
    }

    /* renamed from: and-VKZWuLQ */
    private static final long m225andVKZWuLQ(long $this, long other) {
        return m232constructorimpl($this & other);
    }

    /* renamed from: or-VKZWuLQ */
    private static final long m247orVKZWuLQ(long $this, long other) {
        return m232constructorimpl($this | other);
    }

    /* renamed from: xor-VKZWuLQ */
    private static final long m274xorVKZWuLQ(long $this, long other) {
        return m232constructorimpl($this ^ other);
    }

    /* renamed from: inv-s-VKNKU */
    private static final long m242invsVKNKU(long $this) {
        return m232constructorimpl(~$this);
    }

    /* renamed from: toByte-impl */
    private static final byte m263toByteimpl(long $this) {
        return (byte) $this;
    }

    /* renamed from: toShort-impl */
    private static final short m268toShortimpl(long $this) {
        return (short) $this;
    }

    /* renamed from: toInt-impl */
    private static final int m266toIntimpl(long $this) {
        return (int) $this;
    }

    /* renamed from: toLong-impl */
    private static final long m267toLongimpl(long $this) {
        return $this;
    }

    /* renamed from: toUByte-w2LRezQ */
    private static final byte m270toUBytew2LRezQ(long $this) {
        return UByte.m94constructorimpl((byte) $this);
    }

    /* renamed from: toUShort-Mh2AYeg */
    private static final short m273toUShortMh2AYeg(long $this) {
        return UShort.m330constructorimpl((short) $this);
    }

    /* renamed from: toUInt-pVg5ArA */
    private static final int m271toUIntpVg5ArA(long $this) {
        return UInt.m162constructorimpl((int) $this);
    }

    /* renamed from: toULong-s-VKNKU */
    private static final long m272toULongsVKNKU(long $this) {
        return $this;
    }

    /* renamed from: toFloat-impl */
    private static final float m265toFloatimpl(long $this) {
        return (float) UnsignedUtils.ulongToDouble($this);
    }

    /* renamed from: toDouble-impl */
    private static final double m264toDoubleimpl(long $this) {
        return UnsignedUtils.ulongToDouble($this);
    }

    /* renamed from: toString-impl */
    public static String m269toStringimpl(long $this) {
        return UnsignedUtils.ulongToString($this);
    }
}
