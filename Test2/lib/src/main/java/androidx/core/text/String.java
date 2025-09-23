package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: String.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0086\b¨\u0006\u0002"}, m17d2 = {"htmlEncode", "", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.text.StringKt, reason: use source file name */
/* loaded from: classes.dex */
public final class String {
    public static final java.lang.String htmlEncode(java.lang.String htmlEncode) {
        Intrinsics.checkParameterIsNotNull(htmlEncode, "$this$htmlEncode");
        java.lang.String strHtmlEncode = TextUtils.htmlEncode(htmlEncode);
        Intrinsics.checkExpressionValueIsNotNull(strHtmlEncode, "TextUtils.htmlEncode(this)");
        return strHtmlEncode;
    }
}
