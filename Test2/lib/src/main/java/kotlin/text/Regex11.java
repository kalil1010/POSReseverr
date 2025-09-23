package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LITERAL' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: Regex.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, m17d2 = {"Lkotlin/text/RegexOption;", "", "Lkotlin/text/FlagEnum;", "value", "", "mask", "(Ljava/lang/String;III)V", "getMask", "()I", "getValue", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.text.RegexOption, reason: use source file name */
/* loaded from: classes.dex */
public final class Regex11 implements Regex2 {
    private static final /* synthetic */ Regex11[] $VALUES;
    public static final Regex11 CANON_EQ;
    public static final Regex11 COMMENTS;
    public static final Regex11 DOT_MATCHES_ALL;
    public static final Regex11 IGNORE_CASE;
    public static final Regex11 LITERAL;
    public static final Regex11 MULTILINE;
    public static final Regex11 UNIX_LINES;
    private final int mask;
    private final int value;

    public static Regex11 valueOf(String str) {
        return (Regex11) Enum.valueOf(Regex11.class, str);
    }

    public static Regex11[] values() {
        return (Regex11[]) $VALUES.clone();
    }

    private Regex11(String $enum$name, int $enum$ordinal, int value, int mask) {
        this.value = value;
        this.mask = mask;
    }

    /* synthetic */ Regex11(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i4 & 2) != 0 ? i2 : i3);
    }

    @Override // kotlin.text.Regex2
    public int getMask() {
        return this.mask;
    }

    @Override // kotlin.text.Regex2
    public int getValue() {
        return this.value;
    }

    static {
        Regex11 regex11 = new Regex11("IGNORE_CASE", 0, 2, 0, 2, null);
        IGNORE_CASE = regex11;
        Regex11 regex112 = new Regex11("MULTILINE", 1, 8, 0, 2, null);
        MULTILINE = regex112;
        int i = 0;
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Regex11 regex113 = new Regex11("LITERAL", 2, 16, i, i2, defaultConstructorMarker);
        LITERAL = regex113;
        Regex11 regex114 = new Regex11("UNIX_LINES", 3, 1, i, i2, defaultConstructorMarker);
        UNIX_LINES = regex114;
        Regex11 regex115 = new Regex11("COMMENTS", 4, 4, i, i2, defaultConstructorMarker);
        COMMENTS = regex115;
        Regex11 regex116 = new Regex11("DOT_MATCHES_ALL", 5, 32, i, i2, defaultConstructorMarker);
        DOT_MATCHES_ALL = regex116;
        Regex11 regex117 = new Regex11("CANON_EQ", 6, 128, i, i2, defaultConstructorMarker);
        CANON_EQ = regex117;
        $VALUES = new Regex11[]{regex11, regex112, regex113, regex114, regex115, regex116, regex117};
    }
}
