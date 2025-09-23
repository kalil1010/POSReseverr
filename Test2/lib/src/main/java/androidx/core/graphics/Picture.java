package androidx.core.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Picture.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0086\b¨\u0006\n"}, m17d2 = {"record", "Landroid/graphics/Picture;", "width", "", "height", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.graphics.PictureKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Picture {
    public static final android.graphics.Picture record(android.graphics.Picture record, int width, int height, Functions2<? super Canvas, Unit> block) {
        Intrinsics.checkParameterIsNotNull(record, "$this$record");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Canvas c = record.beginRecording(width, height);
        try {
            Intrinsics.checkExpressionValueIsNotNull(c, "c");
            block.invoke(c);
            return record;
        } finally {
            InlineMarker.finallyStart(1);
            record.endRecording();
            InlineMarker.finallyEnd(1);
        }
    }
}
