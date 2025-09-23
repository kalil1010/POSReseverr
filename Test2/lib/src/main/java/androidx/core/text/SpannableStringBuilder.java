package androidx.core.text;

import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpannableStringBuilder.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\b\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a?\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¢\u0006\u0002\u0010\u0010\u001a&\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¨\u0006\u0019"}, m17d2 = {"buildSpannedString", "Landroid/text/SpannedString;", "builderAction", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "backgroundColor", "color", "", "bold", "inSpans", "span", "", "spans", "", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "scale", "proportion", "", "strikeThrough", "subscript", "superscript", "underline", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.text.SpannableStringBuilderKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SpannableStringBuilder {
    public static final SpannedString buildSpannedString(Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        android.text.SpannableStringBuilder builder = new android.text.SpannableStringBuilder();
        builderAction.invoke(builder);
        return new SpannedString(builder);
    }

    public static final android.text.SpannableStringBuilder inSpans(android.text.SpannableStringBuilder inSpans, Object[] spans, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(inSpans, "$this$inSpans");
        Intrinsics.checkParameterIsNotNull(spans, "spans");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        int start = inSpans.length();
        builderAction.invoke(inSpans);
        for (Object span : spans) {
            inSpans.setSpan(span, start, inSpans.length(), 17);
        }
        return inSpans;
    }

    public static final android.text.SpannableStringBuilder inSpans(android.text.SpannableStringBuilder inSpans, Object span, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(inSpans, "$this$inSpans");
        Intrinsics.checkParameterIsNotNull(span, "span");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        int start = inSpans.length();
        builderAction.invoke(inSpans);
        inSpans.setSpan(span, start, inSpans.length(), 17);
        return inSpans;
    }

    public static final android.text.SpannableStringBuilder bold(android.text.SpannableStringBuilder bold, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(bold, "$this$bold");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        Object span$iv = new StyleSpan(1);
        int start$iv = bold.length();
        builderAction.invoke(bold);
        bold.setSpan(span$iv, start$iv, bold.length(), 17);
        return bold;
    }

    public static final android.text.SpannableStringBuilder italic(android.text.SpannableStringBuilder italic, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(italic, "$this$italic");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        Object span$iv = new StyleSpan(2);
        int start$iv = italic.length();
        builderAction.invoke(italic);
        italic.setSpan(span$iv, start$iv, italic.length(), 17);
        return italic;
    }

    public static final android.text.SpannableStringBuilder underline(android.text.SpannableStringBuilder underline, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(underline, "$this$underline");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        Object span$iv = new UnderlineSpan();
        int start$iv = underline.length();
        builderAction.invoke(underline);
        underline.setSpan(span$iv, start$iv, underline.length(), 17);
        return underline;
    }

    public static final android.text.SpannableStringBuilder color(android.text.SpannableStringBuilder color, int color2, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(color, "$this$color");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        Object span$iv = new ForegroundColorSpan(color2);
        int start$iv = color.length();
        builderAction.invoke(color);
        color.setSpan(span$iv, start$iv, color.length(), 17);
        return color;
    }

    public static final android.text.SpannableStringBuilder backgroundColor(android.text.SpannableStringBuilder backgroundColor, int color, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(backgroundColor, "$this$backgroundColor");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        Object span$iv = new BackgroundColorSpan(color);
        int start$iv = backgroundColor.length();
        builderAction.invoke(backgroundColor);
        backgroundColor.setSpan(span$iv, start$iv, backgroundColor.length(), 17);
        return backgroundColor;
    }

    public static final android.text.SpannableStringBuilder strikeThrough(android.text.SpannableStringBuilder strikeThrough, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(strikeThrough, "$this$strikeThrough");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        Object span$iv = new StrikethroughSpan();
        int start$iv = strikeThrough.length();
        builderAction.invoke(strikeThrough);
        strikeThrough.setSpan(span$iv, start$iv, strikeThrough.length(), 17);
        return strikeThrough;
    }

    public static final android.text.SpannableStringBuilder scale(android.text.SpannableStringBuilder scale, float proportion, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(scale, "$this$scale");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        Object span$iv = new RelativeSizeSpan(proportion);
        int start$iv = scale.length();
        builderAction.invoke(scale);
        scale.setSpan(span$iv, start$iv, scale.length(), 17);
        return scale;
    }

    public static final android.text.SpannableStringBuilder superscript(android.text.SpannableStringBuilder superscript, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(superscript, "$this$superscript");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        Object span$iv = new SuperscriptSpan();
        int start$iv = superscript.length();
        builderAction.invoke(superscript);
        superscript.setSpan(span$iv, start$iv, superscript.length(), 17);
        return superscript;
    }

    public static final android.text.SpannableStringBuilder subscript(android.text.SpannableStringBuilder subscript, Functions2<? super android.text.SpannableStringBuilder, Unit> builderAction) {
        Intrinsics.checkParameterIsNotNull(subscript, "$this$subscript");
        Intrinsics.checkParameterIsNotNull(builderAction, "builderAction");
        Object span$iv = new SubscriptSpan();
        int start$iv = subscript.length();
        builderAction.invoke(subscript);
        subscript.setSpan(span$iv, start$iv, subscript.length(), 17);
        return subscript;
    }
}
