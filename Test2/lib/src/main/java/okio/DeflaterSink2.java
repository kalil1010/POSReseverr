package okio;

import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeflaterSink.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, m17d2 = {"deflate", "Lokio/DeflaterSink;", "Lokio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "okio"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: okio.-DeflaterSinkExtensions, reason: use source file name */
/* loaded from: classes.dex */
public final class DeflaterSink2 {
    public static /* synthetic */ DeflaterSink deflate$default(Sink deflate, Deflater deflater, int i, Object obj) {
        if ((i & 1) != 0) {
            deflater = new Deflater();
        }
        Intrinsics.checkNotNullParameter(deflate, "$this$deflate");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        return new DeflaterSink(deflate, deflater);
    }

    public static final DeflaterSink deflate(Sink deflate, Deflater deflater) {
        Intrinsics.checkNotNullParameter(deflate, "$this$deflate");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        return new DeflaterSink(deflate, deflater);
    }
}
