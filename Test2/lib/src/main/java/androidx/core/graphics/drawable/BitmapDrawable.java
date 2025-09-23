package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BitmapDrawable.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, m17d2 = {"toDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Bitmap;", "resources", "Landroid/content/res/Resources;", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.drawable.BitmapDrawableKt, reason: use source file name */
/* loaded from: classes.dex */
public final class BitmapDrawable {
    public static final android.graphics.drawable.BitmapDrawable toDrawable(Bitmap toDrawable, Resources resources) {
        Intrinsics.checkParameterIsNotNull(toDrawable, "$this$toDrawable");
        Intrinsics.checkParameterIsNotNull(resources, "resources");
        return new android.graphics.drawable.BitmapDrawable(resources, toDrawable);
    }
}
