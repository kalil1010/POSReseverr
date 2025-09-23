package androidx.core.text;

import android.text.Spannable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.Ranges6;

/* compiled from: SpannableString.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b¨\u0006\r"}, m17d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", "start", "", "end", "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.text.SpannableStringKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SpannableString {
    public static final Spannable toSpannable(CharSequence toSpannable) {
        Intrinsics.checkParameterIsNotNull(toSpannable, "$this$toSpannable");
        android.text.SpannableString spannableStringValueOf = android.text.SpannableString.valueOf(toSpannable);
        Intrinsics.checkExpressionValueIsNotNull(spannableStringValueOf, "SpannableString.valueOf(this)");
        return spannableStringValueOf;
    }

    public static final void clearSpans(Spannable clearSpans) {
        Intrinsics.checkParameterIsNotNull(clearSpans, "$this$clearSpans");
        Spannable $this$getSpans$iv = clearSpans;
        int end$iv = $this$getSpans$iv.length();
        Object[] $this$forEach$iv = $this$getSpans$iv.getSpans(0, end$iv, Object.class);
        Intrinsics.checkExpressionValueIsNotNull($this$forEach$iv, "getSpans(start, end, T::class.java)");
        for (Object element$iv : $this$forEach$iv) {
            clearSpans.removeSpan(element$iv);
        }
    }

    public static final void set(Spannable set, int start, int end, Object span) {
        Intrinsics.checkParameterIsNotNull(set, "$this$set");
        Intrinsics.checkParameterIsNotNull(span, "span");
        set.setSpan(span, start, end, 17);
    }

    public static final void set(Spannable set, Ranges6 range, Object span) {
        Intrinsics.checkParameterIsNotNull(set, "$this$set");
        Intrinsics.checkParameterIsNotNull(range, "range");
        Intrinsics.checkParameterIsNotNull(span, "span");
        set.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }
}
