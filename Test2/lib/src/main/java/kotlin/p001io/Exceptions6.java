package kotlin.p001io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m17d2 = {"Lkotlin/io/FileSystemException;", "Ljava/io/IOException;", "file", "Ljava/io/File;", "other", "reason", "", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getOther", "getReason", "()Ljava/lang/String;", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.io.FileSystemException, reason: use source file name */
/* loaded from: classes.dex */
public class Exceptions6 extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Exceptions6(File file, File other, String reason) {
        super(Exceptions4.constructMessage(file, other, reason));
        Intrinsics.checkNotNullParameter(file, "file");
        this.file = file;
        this.other = other;
        this.reason = reason;
    }

    public final File getFile() {
        return this.file;
    }

    public /* synthetic */ Exceptions6(File file, File file2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? (File) null : file2, (i & 4) != 0 ? (String) null : str);
    }

    public final File getOther() {
        return this.other;
    }

    public final String getReason() {
        return this.reason;
    }
}
