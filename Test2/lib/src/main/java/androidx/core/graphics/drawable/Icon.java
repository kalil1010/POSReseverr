package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Icon.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, m17d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.drawable.IconKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Icon {
    public static final android.graphics.drawable.Icon toAdaptiveIcon(Bitmap toAdaptiveIcon) {
        Intrinsics.checkParameterIsNotNull(toAdaptiveIcon, "$this$toAdaptiveIcon");
        android.graphics.drawable.Icon iconCreateWithAdaptiveBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap(toAdaptiveIcon);
        Intrinsics.checkExpressionValueIsNotNull(iconCreateWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return iconCreateWithAdaptiveBitmap;
    }

    public static final android.graphics.drawable.Icon toIcon(Bitmap toIcon) {
        Intrinsics.checkParameterIsNotNull(toIcon, "$this$toIcon");
        android.graphics.drawable.Icon iconCreateWithBitmap = android.graphics.drawable.Icon.createWithBitmap(toIcon);
        Intrinsics.checkExpressionValueIsNotNull(iconCreateWithBitmap, "Icon.createWithBitmap(this)");
        return iconCreateWithBitmap;
    }

    public static final android.graphics.drawable.Icon toIcon(Uri toIcon) {
        Intrinsics.checkParameterIsNotNull(toIcon, "$this$toIcon");
        android.graphics.drawable.Icon iconCreateWithContentUri = android.graphics.drawable.Icon.createWithContentUri(toIcon);
        Intrinsics.checkExpressionValueIsNotNull(iconCreateWithContentUri, "Icon.createWithContentUri(this)");
        return iconCreateWithContentUri;
    }

    public static final android.graphics.drawable.Icon toIcon(byte[] toIcon) {
        Intrinsics.checkParameterIsNotNull(toIcon, "$this$toIcon");
        android.graphics.drawable.Icon iconCreateWithData = android.graphics.drawable.Icon.createWithData(toIcon, 0, toIcon.length);
        Intrinsics.checkExpressionValueIsNotNull(iconCreateWithData, "Icon.createWithData(this, 0, size)");
        return iconCreateWithData;
    }
}
