package kotlin.text;

import java.util.regex.Pattern;
import kotlin.Metadata;

/* compiled from: RegexExtensionsJVM.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b¨\u0006\u0003"}, m17d2 = {"toRegex", "Lkotlin/text/Regex;", "Ljava/util/regex/Pattern;", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.StringsKt__RegexExtensionsJVMKt */
/* loaded from: classes.dex */
class RegexExtensionsJVM extends Indent {
    private static final Regex toRegex(Pattern $this$toRegex) {
        return new Regex($this$toRegex);
    }
}
