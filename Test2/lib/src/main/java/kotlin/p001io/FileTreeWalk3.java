package kotlin.p001io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileTreeWalk.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, m17d2 = {"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", "direction", "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/io/FilesKt")
/* renamed from: kotlin.io.FilesKt__FileTreeWalkKt */
/* loaded from: classes.dex */
class FileTreeWalk3 extends FileReadWrite2 {
    public static /* synthetic */ FileTreeWalk walk$default(File file, FileTreeWalk2 fileTreeWalk2, int i, Object obj) {
        if ((i & 1) != 0) {
            fileTreeWalk2 = FileTreeWalk2.TOP_DOWN;
        }
        return FilesKt.walk(file, fileTreeWalk2);
    }

    public static final FileTreeWalk walk(File walk, FileTreeWalk2 direction) {
        Intrinsics.checkNotNullParameter(walk, "$this$walk");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new FileTreeWalk(walk, direction);
    }

    public static final FileTreeWalk walkTopDown(File walkTopDown) {
        Intrinsics.checkNotNullParameter(walkTopDown, "$this$walkTopDown");
        return FilesKt.walk(walkTopDown, FileTreeWalk2.TOP_DOWN);
    }

    public static final FileTreeWalk walkBottomUp(File walkBottomUp) {
        Intrinsics.checkNotNullParameter(walkBottomUp, "$this$walkBottomUp");
        return FilesKt.walk(walkBottomUp, FileTreeWalk2.BOTTOM_UP);
    }
}
