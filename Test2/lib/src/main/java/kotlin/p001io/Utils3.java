package kotlin.p001io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utils.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m17d2 = {"Lkotlin/io/TerminateException;", "Lkotlin/io/FileSystemException;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.io.TerminateException, reason: use source file name */
/* loaded from: classes.dex */
final class Utils3 extends Exceptions6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Utils3(File file) {
        super(file, null, null, 6, null);
        Intrinsics.checkNotNullParameter(file, "file");
    }
}
