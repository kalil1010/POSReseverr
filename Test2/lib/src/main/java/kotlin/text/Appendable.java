package kotlin.text;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Appendable.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a5\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\"\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\n\u001a\u0002H\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0000¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\b\u001a\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0087\b\u001a\u001f\u0010\u000e\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0006H\u0087\b\u001a7\u0010\u0010\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, m17d2 = {"append", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "appendLine", "", "appendRange", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.StringsKt__AppendableKt, reason: use source file name */
/* loaded from: classes.dex */
public class Appendable {
    public static final <T extends java.lang.Appendable> T appendRange(T appendRange, CharSequence value, int i, int i2) {
        Intrinsics.checkNotNullParameter(appendRange, "$this$appendRange");
        Intrinsics.checkNotNullParameter(value, "value");
        T t = (T) appendRange.append(value, i, i2);
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public static final <T extends java.lang.Appendable> T append(T append, CharSequence... value) throws IOException {
        Intrinsics.checkNotNullParameter(append, "$this$append");
        Intrinsics.checkNotNullParameter(value, "value");
        for (CharSequence item : value) {
            append.append(item);
        }
        return append;
    }

    private static final java.lang.Appendable appendLine(java.lang.Appendable $this$appendLine) throws IOException {
        java.lang.Appendable appendableAppend = $this$appendLine.append('\n');
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append('\\n')");
        return appendableAppend;
    }

    private static final java.lang.Appendable appendLine(java.lang.Appendable $this$appendLine, CharSequence value) throws IOException {
        java.lang.Appendable appendableAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(value)");
        java.lang.Appendable appendableAppend2 = appendableAppend.append('\n');
        Intrinsics.checkNotNullExpressionValue(appendableAppend2, "append('\\n')");
        return appendableAppend2;
    }

    private static final java.lang.Appendable appendLine(java.lang.Appendable $this$appendLine, char value) throws IOException {
        java.lang.Appendable appendableAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(value)");
        java.lang.Appendable appendableAppend2 = appendableAppend.append('\n');
        Intrinsics.checkNotNullExpressionValue(appendableAppend2, "append('\\n')");
        return appendableAppend2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void appendElement(java.lang.Appendable appendElement, T t, Functions2<? super T, ? extends CharSequence> functions2) throws IOException {
        Intrinsics.checkNotNullParameter(appendElement, "$this$appendElement");
        if (functions2 == null) {
            if (!(t != 0 ? t instanceof CharSequence : true)) {
                if (!(t instanceof Character)) {
                    appendElement.append(String.valueOf(t));
                    return;
                } else {
                    appendElement.append(((Character) t).charValue());
                    return;
                }
            }
            appendElement.append((CharSequence) t);
            return;
        }
        appendElement.append(functions2.invoke(t));
    }
}
