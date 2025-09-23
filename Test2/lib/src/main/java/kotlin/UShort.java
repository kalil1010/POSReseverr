package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import okhttp3.internal.p005ws.WebSocketProtocol;

/* compiled from: UShort.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0016\u0010%\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0005J\u0016\u0010'\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0010J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0013J\u001b\u0010)\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0010J\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0013J\u001b\u00100\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0010J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0013J\u001b\u00109\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0010J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0013J\u001b\u0010>\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020DH\u0087\b¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020HH\u0087\b¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020LH\u0087\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\rH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0016\u0010\\\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b]\u0010FJ\u0016\u0010^\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b_\u0010QJ\u0016\u0010`\u001a\u00020\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\ba\u0010UJ\u0016\u0010b\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010\u0005J\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006g"}, m17d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* renamed from: box-impl */
    public static final /* synthetic */ UShort m324boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: compareTo-xj2QHRw */
    private int m328compareToxj2QHRw(short s) {
        return m329compareToxj2QHRw(this.data, s);
    }

    /* renamed from: equals-impl */
    public static boolean m336equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).getData();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m337equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m338hashCodeimpl(short s) {
        return s;
    }

    public boolean equals(Object other) {
        return m336equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m338hashCodeimpl(this.data);
    }

    public String toString() {
        return m365toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    private /* synthetic */ UShort(short data) {
        this.data = data;
    }

    /* renamed from: constructor-impl */
    public static short m330constructorimpl(short data) {
        return data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return m328compareToxj2QHRw(uShort.getData());
    }

    /* renamed from: compareTo-7apg3OU */
    private static final int m325compareTo7apg3OU(short $this, byte other) {
        return Intrinsics.compare(65535 & $this, other & UByte.MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw */
    private static int m329compareToxj2QHRw(short $this, short other) {
        return Intrinsics.compare($this & MAX_VALUE, 65535 & other);
    }

    /* renamed from: compareTo-WZ4Q5Ns */
    private static final int m327compareToWZ4Q5Ns(short $this, int other) {
        return UnsignedUtils.uintCompare(UInt.m162constructorimpl(65535 & $this), other);
    }

    /* renamed from: compareTo-VKZWuLQ */
    private static final int m326compareToVKZWuLQ(short $this, long other) {
        return UnsignedUtils.ulongCompare(ULong.m232constructorimpl($this & WebSocketProtocol.PAYLOAD_SHORT_MAX), other);
    }

    /* renamed from: plus-7apg3OU */
    private static final int m346plus7apg3OU(short $this, byte other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl(65535 & $this) + UInt.m162constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: plus-xj2QHRw */
    private static final int m349plusxj2QHRw(short $this, short other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) + UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: plus-WZ4Q5Ns */
    private static final int m348plusWZ4Q5Ns(short $this, int other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl(65535 & $this) + other);
    }

    /* renamed from: plus-VKZWuLQ */
    private static final long m347plusVKZWuLQ(short $this, long other) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl($this & WebSocketProtocol.PAYLOAD_SHORT_MAX) + other);
    }

    /* renamed from: minus-7apg3OU */
    private static final int m341minus7apg3OU(short $this, byte other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl(65535 & $this) - UInt.m162constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: minus-xj2QHRw */
    private static final int m344minusxj2QHRw(short $this, short other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) - UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: minus-WZ4Q5Ns */
    private static final int m343minusWZ4Q5Ns(short $this, int other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl(65535 & $this) - other);
    }

    /* renamed from: minus-VKZWuLQ */
    private static final long m342minusVKZWuLQ(short $this, long other) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl($this & WebSocketProtocol.PAYLOAD_SHORT_MAX) - other);
    }

    /* renamed from: times-7apg3OU */
    private static final int m355times7apg3OU(short $this, byte other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl(65535 & $this) * UInt.m162constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: times-xj2QHRw */
    private static final int m358timesxj2QHRw(short $this, short other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl($this & MAX_VALUE) * UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: times-WZ4Q5Ns */
    private static final int m357timesWZ4Q5Ns(short $this, int other) {
        return UInt.m162constructorimpl(UInt.m162constructorimpl(65535 & $this) * other);
    }

    /* renamed from: times-VKZWuLQ */
    private static final long m356timesVKZWuLQ(short $this, long other) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl($this & WebSocketProtocol.PAYLOAD_SHORT_MAX) * other);
    }

    /* renamed from: div-7apg3OU */
    private static final int m332div7apg3OU(short $this, byte other) {
        return UnsignedUtils.m391uintDivideJ1ME1BU(UInt.m162constructorimpl(65535 & $this), UInt.m162constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: div-xj2QHRw */
    private static final int m335divxj2QHRw(short $this, short other) {
        return UnsignedUtils.m391uintDivideJ1ME1BU(UInt.m162constructorimpl($this & MAX_VALUE), UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: div-WZ4Q5Ns */
    private static final int m334divWZ4Q5Ns(short $this, int other) {
        return UnsignedUtils.m391uintDivideJ1ME1BU(UInt.m162constructorimpl(65535 & $this), other);
    }

    /* renamed from: div-VKZWuLQ */
    private static final long m333divVKZWuLQ(short $this, long other) {
        return UnsignedUtils.m393ulongDivideeb3DHEI(ULong.m232constructorimpl($this & WebSocketProtocol.PAYLOAD_SHORT_MAX), other);
    }

    /* renamed from: rem-7apg3OU */
    private static final int m351rem7apg3OU(short $this, byte other) {
        return UnsignedUtils.m392uintRemainderJ1ME1BU(UInt.m162constructorimpl(65535 & $this), UInt.m162constructorimpl(other & UByte.MAX_VALUE));
    }

    /* renamed from: rem-xj2QHRw */
    private static final int m354remxj2QHRw(short $this, short other) {
        return UnsignedUtils.m392uintRemainderJ1ME1BU(UInt.m162constructorimpl($this & MAX_VALUE), UInt.m162constructorimpl(65535 & other));
    }

    /* renamed from: rem-WZ4Q5Ns */
    private static final int m353remWZ4Q5Ns(short $this, int other) {
        return UnsignedUtils.m392uintRemainderJ1ME1BU(UInt.m162constructorimpl(65535 & $this), other);
    }

    /* renamed from: rem-VKZWuLQ */
    private static final long m352remVKZWuLQ(short $this, long other) {
        return UnsignedUtils.m394ulongRemaindereb3DHEI(ULong.m232constructorimpl($this & WebSocketProtocol.PAYLOAD_SHORT_MAX), other);
    }

    /* renamed from: inc-Mh2AYeg */
    private static final short m339incMh2AYeg(short $this) {
        return m330constructorimpl((short) ($this + 1));
    }

    /* renamed from: dec-Mh2AYeg */
    private static final short m331decMh2AYeg(short $this) {
        return m330constructorimpl((short) ($this - 1));
    }

    /* renamed from: rangeTo-xj2QHRw */
    private static final UIntRange m350rangeToxj2QHRw(short $this, short other) {
        return new UIntRange(UInt.m162constructorimpl($this & MAX_VALUE), UInt.m162constructorimpl(65535 & other), null);
    }

    /* renamed from: and-xj2QHRw */
    private static final short m323andxj2QHRw(short $this, short other) {
        return m330constructorimpl((short) ($this & other));
    }

    /* renamed from: or-xj2QHRw */
    private static final short m345orxj2QHRw(short $this, short other) {
        return m330constructorimpl((short) ($this | other));
    }

    /* renamed from: xor-xj2QHRw */
    private static final short m370xorxj2QHRw(short $this, short other) {
        return m330constructorimpl((short) ($this ^ other));
    }

    /* renamed from: inv-Mh2AYeg */
    private static final short m340invMh2AYeg(short $this) {
        return m330constructorimpl((short) (~$this));
    }

    /* renamed from: toByte-impl */
    private static final byte m359toByteimpl(short $this) {
        return (byte) $this;
    }

    /* renamed from: toShort-impl */
    private static final short m364toShortimpl(short $this) {
        return $this;
    }

    /* renamed from: toInt-impl */
    private static final int m362toIntimpl(short $this) {
        return 65535 & $this;
    }

    /* renamed from: toLong-impl */
    private static final long m363toLongimpl(short $this) {
        return $this & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    /* renamed from: toUByte-w2LRezQ */
    private static final byte m366toUBytew2LRezQ(short $this) {
        return UByte.m94constructorimpl((byte) $this);
    }

    /* renamed from: toUShort-Mh2AYeg */
    private static final short m369toUShortMh2AYeg(short $this) {
        return $this;
    }

    /* renamed from: toUInt-pVg5ArA */
    private static final int m367toUIntpVg5ArA(short $this) {
        return UInt.m162constructorimpl(65535 & $this);
    }

    /* renamed from: toULong-s-VKNKU */
    private static final long m368toULongsVKNKU(short $this) {
        return ULong.m232constructorimpl($this & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* renamed from: toFloat-impl */
    private static final float m361toFloatimpl(short $this) {
        return 65535 & $this;
    }

    /* renamed from: toDouble-impl */
    private static final double m360toDoubleimpl(short $this) {
        return 65535 & $this;
    }

    /* renamed from: toString-impl */
    public static String m365toStringimpl(short $this) {
        return String.valueOf(65535 & $this);
    }
}
