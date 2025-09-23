package kotlin;

import kotlin.ranges.UIntRange;

/* compiled from: UInt.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 j2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001jB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u0013\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0016\u0010#\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\u0005J\u0016\u0010%\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0005J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\u000fJ\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010\u000bJ\u001b\u0010'\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u001dJ\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0016J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b-\u0010\u000bJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u000fJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u000bJ\u001b\u0010.\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u001dJ\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0016J\u001b\u00103\u001a\u0002042\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b8\u0010\u000fJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010\u000bJ\u001b\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u001dJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0016J\u001e\u0010<\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0003H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010\u000bJ\u001e\u0010?\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0003H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010\u000bJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u000fJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u000bJ\u001b\u0010A\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001dJ\u001b\u0010A\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u0016J\u0010\u0010F\u001a\u00020GH\u0087\b¢\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u00020KH\u0087\b¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bS\u0010\u0005J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u000f\u0010\\\u001a\u00020]H\u0016¢\u0006\u0004\b^\u0010_J\u0016\u0010`\u001a\u00020\rH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\ba\u0010IJ\u0016\u0010b\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010\u0005J\u0016\u0010d\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\be\u0010WJ\u0016\u0010f\u001a\u00020\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bg\u0010[J\u001b\u0010h\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bi\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006k"}, m17d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UInt implements Comparable<UInt> {
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    /* renamed from: box-impl */
    public static final /* synthetic */ UInt m156boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: compareTo-WZ4Q5Ns */
    private int m159compareToWZ4Q5Ns(int i) {
        return m160compareToWZ4Q5Ns(this.data, i);
    }

    /* renamed from: equals-impl */
    public static boolean m168equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).getData();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m169equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m170hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object other) {
        return m168equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m170hashCodeimpl(this.data);
    }

    public String toString() {
        return m199toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ int getData() {
        return this.data;
    }

    private /* synthetic */ UInt(int data) {
        this.data = data;
    }

    /* renamed from: constructor-impl */
    public static int m162constructorimpl(int data) {
        return data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return m159compareToWZ4Q5Ns(uInt.getData());
    }

    /* renamed from: compareTo-7apg3OU */
    private static final int m157compareTo7apg3OU(int $this, byte other) {
        return UnsignedUtils.uintCompare($this, m162constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: compareTo-xj2QHRw */
    private static final int m161compareToxj2QHRw(int $this, short other) {
        return UnsignedUtils.uintCompare($this, m162constructorimpl(65535 & other));
    }

    /* renamed from: compareTo-WZ4Q5Ns */
    private static int m160compareToWZ4Q5Ns(int $this, int other) {
        return UnsignedUtils.uintCompare($this, other);
    }

    /* renamed from: compareTo-VKZWuLQ */
    private static final int m158compareToVKZWuLQ(int $this, long other) {
        return UnsignedUtils.ulongCompare(ULong.m232constructorimpl($this & 4294967295L), other);
    }

    /* renamed from: plus-7apg3OU */
    private static final int m178plus7apg3OU(int $this, byte other) {
        return m162constructorimpl(m162constructorimpl(other & UByte.MAX_VALUE) + $this);
    }

    /* renamed from: plus-xj2QHRw */
    private static final int m181plusxj2QHRw(int $this, short other) {
        return m162constructorimpl(m162constructorimpl(65535 & other) + $this);
    }

    /* renamed from: plus-WZ4Q5Ns */
    private static final int m180plusWZ4Q5Ns(int $this, int other) {
        return m162constructorimpl($this + other);
    }

    /* renamed from: plus-VKZWuLQ */
    private static final long m179plusVKZWuLQ(int $this, long other) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl($this & 4294967295L) + other);
    }

    /* renamed from: minus-7apg3OU */
    private static final int m173minus7apg3OU(int $this, byte other) {
        return m162constructorimpl($this - m162constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: minus-xj2QHRw */
    private static final int m176minusxj2QHRw(int $this, short other) {
        return m162constructorimpl($this - m162constructorimpl(65535 & other));
    }

    /* renamed from: minus-WZ4Q5Ns */
    private static final int m175minusWZ4Q5Ns(int $this, int other) {
        return m162constructorimpl($this - other);
    }

    /* renamed from: minus-VKZWuLQ */
    private static final long m174minusVKZWuLQ(int $this, long other) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl($this & 4294967295L) - other);
    }

    /* renamed from: times-7apg3OU */
    private static final int m189times7apg3OU(int $this, byte other) {
        return m162constructorimpl(m162constructorimpl(other & UByte.MAX_VALUE) * $this);
    }

    /* renamed from: times-xj2QHRw */
    private static final int m192timesxj2QHRw(int $this, short other) {
        return m162constructorimpl(m162constructorimpl(65535 & other) * $this);
    }

    /* renamed from: times-WZ4Q5Ns */
    private static final int m191timesWZ4Q5Ns(int $this, int other) {
        return m162constructorimpl($this * other);
    }

    /* renamed from: times-VKZWuLQ */
    private static final long m190timesVKZWuLQ(int $this, long other) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl($this & 4294967295L) * other);
    }

    /* renamed from: div-7apg3OU */
    private static final int m164div7apg3OU(int $this, byte other) {
        return UnsignedUtils.m391uintDivideJ1ME1BU($this, m162constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: div-xj2QHRw */
    private static final int m167divxj2QHRw(int $this, short other) {
        return UnsignedUtils.m391uintDivideJ1ME1BU($this, m162constructorimpl(65535 & other));
    }

    /* renamed from: div-WZ4Q5Ns */
    private static final int m166divWZ4Q5Ns(int $this, int other) {
        return UnsignedUtils.m391uintDivideJ1ME1BU($this, other);
    }

    /* renamed from: div-VKZWuLQ */
    private static final long m165divVKZWuLQ(int $this, long other) {
        return UnsignedUtils.m393ulongDivideeb3DHEI(ULong.m232constructorimpl($this & 4294967295L), other);
    }

    /* renamed from: rem-7apg3OU */
    private static final int m183rem7apg3OU(int $this, byte other) {
        return UnsignedUtils.m392uintRemainderJ1ME1BU($this, m162constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: rem-xj2QHRw */
    private static final int m186remxj2QHRw(int $this, short other) {
        return UnsignedUtils.m392uintRemainderJ1ME1BU($this, m162constructorimpl(65535 & other));
    }

    /* renamed from: rem-WZ4Q5Ns */
    private static final int m185remWZ4Q5Ns(int $this, int other) {
        return UnsignedUtils.m392uintRemainderJ1ME1BU($this, other);
    }

    /* renamed from: rem-VKZWuLQ */
    private static final long m184remVKZWuLQ(int $this, long other) {
        return UnsignedUtils.m394ulongRemaindereb3DHEI(ULong.m232constructorimpl($this & 4294967295L), other);
    }

    /* renamed from: inc-pVg5ArA */
    private static final int m171incpVg5ArA(int $this) {
        return m162constructorimpl($this + 1);
    }

    /* renamed from: dec-pVg5ArA */
    private static final int m163decpVg5ArA(int $this) {
        return m162constructorimpl($this - 1);
    }

    /* renamed from: rangeTo-WZ4Q5Ns */
    private static final UIntRange m182rangeToWZ4Q5Ns(int $this, int other) {
        return new UIntRange($this, other, null);
    }

    /* renamed from: shl-pVg5ArA */
    private static final int m187shlpVg5ArA(int $this, int bitCount) {
        return m162constructorimpl($this << bitCount);
    }

    /* renamed from: shr-pVg5ArA */
    private static final int m188shrpVg5ArA(int $this, int bitCount) {
        return m162constructorimpl($this >>> bitCount);
    }

    /* renamed from: and-WZ4Q5Ns */
    private static final int m155andWZ4Q5Ns(int $this, int other) {
        return m162constructorimpl($this & other);
    }

    /* renamed from: or-WZ4Q5Ns */
    private static final int m177orWZ4Q5Ns(int $this, int other) {
        return m162constructorimpl($this | other);
    }

    /* renamed from: xor-WZ4Q5Ns */
    private static final int m204xorWZ4Q5Ns(int $this, int other) {
        return m162constructorimpl($this ^ other);
    }

    /* renamed from: inv-pVg5ArA */
    private static final int m172invpVg5ArA(int $this) {
        return m162constructorimpl(~$this);
    }

    /* renamed from: toByte-impl */
    private static final byte m193toByteimpl(int $this) {
        return (byte) $this;
    }

    /* renamed from: toShort-impl */
    private static final short m198toShortimpl(int $this) {
        return (short) $this;
    }

    /* renamed from: toInt-impl */
    private static final int m196toIntimpl(int $this) {
        return $this;
    }

    /* renamed from: toLong-impl */
    private static final long m197toLongimpl(int $this) {
        return $this & 4294967295L;
    }

    /* renamed from: toUByte-w2LRezQ */
    private static final byte m200toUBytew2LRezQ(int $this) {
        return UByte.m94constructorimpl((byte) $this);
    }

    /* renamed from: toUShort-Mh2AYeg */
    private static final short m203toUShortMh2AYeg(int $this) {
        return UShort.m330constructorimpl((short) $this);
    }

    /* renamed from: toUInt-pVg5ArA */
    private static final int m201toUIntpVg5ArA(int $this) {
        return $this;
    }

    /* renamed from: toULong-s-VKNKU */
    private static final long m202toULongsVKNKU(int $this) {
        return ULong.m232constructorimpl($this & 4294967295L);
    }

    /* renamed from: toFloat-impl */
    private static final float m195toFloatimpl(int $this) {
        return (float) UnsignedUtils.uintToDouble($this);
    }

    /* renamed from: toDouble-impl */
    private static final double m194toDoubleimpl(int $this) {
        return UnsignedUtils.uintToDouble($this);
    }

    /* renamed from: toString-impl */
    public static String m199toStringimpl(int $this) {
        return String.valueOf($this & 4294967295L);
    }
}
