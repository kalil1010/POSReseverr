package androidx.core.net;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Uri.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, m17d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.net.UriKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Uri {
    public static final android.net.Uri toUri(String toUri) {
        Intrinsics.checkParameterIsNotNull(toUri, "$this$toUri");
        android.net.Uri uri = android.net.Uri.parse(toUri);
        Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
        return uri;
    }

    public static final android.net.Uri toUri(File toUri) {
        Intrinsics.checkParameterIsNotNull(toUri, "$this$toUri");
        android.net.Uri uriFromFile = android.net.Uri.fromFile(toUri);
        Intrinsics.checkExpressionValueIsNotNull(uriFromFile, "Uri.fromFile(this)");
        return uriFromFile;
    }

    public static final File toFile(android.net.Uri toFile) {
        Intrinsics.checkParameterIsNotNull(toFile, "$this$toFile");
        if (!Intrinsics.areEqual(toFile.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + toFile).toString());
        }
        String path = toFile.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + toFile).toString());
    }
}
