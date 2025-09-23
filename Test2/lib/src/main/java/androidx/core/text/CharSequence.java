package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CharSequence.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0086\b¨\u0006\u0005"}, m17d2 = {"isDigitsOnly", "", "", "trimmedLength", "", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.text.CharSequenceKt, reason: use source file name */
/* loaded from: classes.dex */
public final class CharSequence {
    public static final boolean isDigitsOnly(java.lang.CharSequence isDigitsOnly) {
        Intrinsics.checkParameterIsNotNull(isDigitsOnly, "$this$isDigitsOnly");
        return TextUtils.isDigitsOnly(isDigitsOnly);
    }

    public static final int trimmedLength(java.lang.CharSequence trimmedLength) {
        Intrinsics.checkParameterIsNotNull(trimmedLength, "$this$trimmedLength");
        return TextUtils.getTrimmedLength(trimmedLength);
    }
}
