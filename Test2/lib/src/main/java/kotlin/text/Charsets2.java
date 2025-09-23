package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Charsets.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b¨\u0006\u0004"}, m17d2 = {"charset", "Ljava/nio/charset/Charset;", "charsetName", "", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: kotlin.text.CharsetsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Charsets2 {
    private static final Charset charset(String charsetName) {
        Charset charsetForName = Charset.forName(charsetName);
        Intrinsics.checkNotNullExpressionValue(charsetForName, "Charset.forName(charsetName)");
        return charsetForName;
    }
}
