package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

/* compiled from: UByte.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0016\u0010%\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0005J\u0016\u0010'\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u000fJ\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0012J\u001b\u0010)\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u000fJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0012J\u001b\u00100\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u000fJ\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0012J\u001b\u00109\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u000fJ\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0012J\u001b\u0010>\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bD\u0010\u0005J\u0010\u0010E\u001a\u00020FH\u0087\b¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020JH\u0087\b¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020\rH\u0087\b¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020QH\u0087\b¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0016\u0010\\\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b]\u0010\u0005J\u0016\u0010^\u001a\u00020\u0010H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b_\u0010OJ\u0016\u0010`\u001a\u00020\u0013H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\ba\u0010SJ\u0016\u0010b\u001a\u00020\u0016H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010WJ\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006g"}, m17d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UByte implements Comparable<UByte> {
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* renamed from: box-impl */
    public static final /* synthetic */ UByte m88boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: compareTo-7apg3OU */
    private int m89compareTo7apg3OU(byte b) {
        return m90compareTo7apg3OU(this.data, b);
    }

    /* renamed from: equals-impl */
    public static boolean m100equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).getData();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m101equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m102hashCodeimpl(byte b) {
        return b;
    }

    public boolean equals(Object other) {
        return m100equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m102hashCodeimpl(this.data);
    }

    public String toString() {
        return m129toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ byte getData() {
        return this.data;
    }

    private /* synthetic */ UByte(byte data) {
        this.data = data;
    }

    /* renamed from: constructor-impl */
    public static byte m94constructorimpl(byte data) {
        return data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return m89compareTo7apg3OU(uByte.getData());
    }

    /* renamed from: compareTo-7apg3OU */
    private static int m90compareTo7apg3OU(byte $this, byte other) {
        return Intrinsics.compare($this & MAX_VALUE, other & MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw */
    private static final int m93compareToxj2QHRw(byte $this, short other) {
        return Intrinsics.compare($this & MAX_VALUE, 65535 & other);
    }

    /* renamed from: compareTo-WZ4Q5Ns */
    private static final int m92compareToWZ4Q5Ns(byte $this, int other) {
        return UnsignedUtils.uintCompare(UInt.m162constructorimpl($this & MAX_VALUE), other);
    }

    /* renamed from: compareTo-VKZWuLQ */
    private static final int m91compareToVKZWuLQ(byte $this, long other) {
        return UnsignedUtils.ulongCompare(ULong.m232constructorimpl($this & 255), other);
    }

    /* renamed from: plus-7apg3OU */
    private static final int m110plus7apg3OU(byte $this, byte other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) + UInt.m162constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: plus-xj2QHRw */
    private static final int m113plusxj2QHRw(byte $this, short other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) + UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: plus-WZ4Q5Ns */
    private static final int m112plusWZ4Q5Ns(byte $this, int other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) + other);
    }

    /* renamed from: plus-VKZWuLQ */
    private static final long m111plusVKZWuLQ(byte $this, long other) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl($this & 255) + other);
    }

    /* renamed from: minus-7apg3OU */
    private static final int m105minus7apg3OU(byte $this, byte other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) - UInt.m162constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: minus-xj2QHRw */
    private static final int m108minusxj2QHRw(byte $this, short other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) - UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: minus-WZ4Q5Ns */
    private static final int m107minusWZ4Q5Ns(byte $this, int other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) - other);
    }

    /* renamed from: minus-VKZWuLQ */
    private static final long m106minusVKZWuLQ(byte $this, long other) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl($this & 255) - other);
    }

    /* renamed from: times-7apg3OU */
    private static final int m119times7apg3OU(byte $this, byte other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) * UInt.m162constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: times-xj2QHRw */
    private static final int m122timesxj2QHRw(byte $this, short other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) * UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: times-WZ4Q5Ns */
    private static final int m121timesWZ4Q5Ns(byte $this, int other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) * other);
    }

    /* renamed from: times-VKZWuLQ */
    private static final long m120timesVKZWuLQ(byte $this, long other) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl($this & 255) * other);
    }

    /* renamed from: div-7apg3OU */
    private static final int m96div7apg3OU(byte $this, byte other) {
        return UnsignedUtils.m391uintDivideJ1ME1BU(UInt.m162constructorimpl($this & MAX_VALUE), UInt.m162constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: div-xj2QHRw */
    private static final int m99divxj2QHRw(byte $this, short other) {
        return UnsignedUtils.m391uintDivideJ1ME1BU(UInt.m162constructorimpl($this & MAX_VALUE), UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: div-WZ4Q5Ns */
    private static final int m98divWZ4Q5Ns(byte $this, int other) {
        return UnsignedUtils.m391uintDivideJ1ME1BU(UInt.m162constructorimpl($this & MAX_VALUE), other);
    }

    /* renamed from: div-VKZWuLQ */
    private static final long m97divVKZWuLQ(byte $this, long other) {
        return UnsignedUtils.m393ulongDivideeb3DHEI(ULong.m232constructorimpl($this & 255), other);
    }

    /* renamed from: rem-7apg3OU */
    private static final int m115rem7apg3OU(byte $this, byte other) {
        return UnsignedUtils.m392uintRemainderJ1ME1BU(UInt.m162constructorimpl($this & MAX_VALUE), UInt.m162constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: rem-xj2QHRw */
    private static final int m118remxj2QHRw(byte $this, short other) {
        return UnsignedUtils.m392uintRemainderJ1ME1BU(UInt.m162constructorimpl($this & MAX_VALUE), UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: rem-WZ4Q5Ns */
    private static final int m117remWZ4Q5Ns(byte $this, int other) {
        return UnsignedUtils.m392uintRemainderJ1ME1BU(UInt.m162constructorimpl($this & MAX_VALUE), other);
    }

    /* renamed from: rem-VKZWuLQ */
    private static final long m116remVKZWuLQ(byte $this, long other) {
        return UnsignedUtils.m394ulongRemaindereb3DHEI(ULong.m232constructorimpl($this & 255), other);
    }

    /* renamed from: inc-w2LRezQ */
    private static final byte m103incw2LRezQ(byte $this) {
        return m94constructorimpl((byte) ($this + 1));
    }

    /* renamed from: dec-w2LRezQ */
    private static final byte m95decw2LRezQ(byte $this) {
        return m94constructorimpl((byte) ($this - 1));
    }

    /* renamed from: rangeTo-7apg3OU */
    private static final UIntRange m114rangeTo7apg3OU(byte $this, byte other) {
        return new UIntRange(UInt.m162constructorimpl($this & MAX_VALUE), UInt.m162constructorimpl(other & MAX_VALUE), null);
    }

    /* renamed from: and-7apg3OU */
    private static final byte m87and7apg3OU(byte $this, byte other) {
        return m94constructorimpl((byte) ($this & other));
    }

    /* renamed from: or-7apg3OU */
    private static final byte m109or7apg3OU(byte $this, byte other) {
        return m94constructorimpl((byte) ($this | other));
    }

    /* renamed from: xor-7apg3OU */
    private static final byte m134xor7apg3OU(byte $this, byte other) {
        return m94constructorimpl((byte) ($this ^ other));
    }

    /* renamed from: inv-w2LRezQ */
    private static final byte m104invw2LRezQ(byte $this) {
        return m94constructorimpl((byte) (~$this));
    }

    /* renamed from: toByte-impl */
    private static final byte m123toByteimpl(byte $this) {
        return $this;
    }

    /* renamed from: toShort-impl */
    private static final short m128toShortimpl(byte $this) {
        return (short) ($this & 255);
    }

    /* renamed from: toInt-impl */
    private static final int m126toIntimpl(byte $this) {
        return $this & MAX_VALUE;
    }

    /* renamed from: toLong-impl */
    private static final long m127toLongimpl(byte $this) {
        return $this & 255;
    }

    /* renamed from: toUByte-w2LRezQ */
    private static final byte m130toUBytew2LRezQ(byte $this) {
        return $this;
    }

    /* renamed from: toUShort-Mh2AYeg */
    private static final short m133toUShortMh2AYeg(byte $this) {
        return UShort.m330constructorimpl((short) ($this & 255));
    }

    /* renamed from: toUInt-pVg5ArA */
    private static final int m131toUIntpVg5ArA(byte $this) {
        return UInt.m162constructorimpl($this & MAX_VALUE);
    }

    /* renamed from: toULong-s-VKNKU */
    private static final long m132toULongsVKNKU(byte $this) {
        return ULong.m232constructorimpl($this & 255);
    }

    /* renamed from: toFloat-impl */
    private static final float m125toFloatimpl(byte $this) {
        return $this & MAX_VALUE;
    }

    /* renamed from: toDouble-impl */
    private static final double m124toDoubleimpl(byte $this) {
        return $this & MAX_VALUE;
    }

    /* renamed from: toString-impl */
    public static String m129toStringimpl(byte $this) {
        return String.valueOf($this & MAX_VALUE);
    }
}
