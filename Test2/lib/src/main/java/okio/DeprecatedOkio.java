package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Annotations;
import kotlin.Annotations3;
import kotlin.Annotations8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: -DeprecatedOkio.kt */
@Annotations(message = "changed in Okio 2.x")
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\n\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, m17d2 = {"Lokio/-DeprecatedOkio;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Ljava/io/File;", "blackhole", "buffer", "Lokio/BufferedSink;", "sink", "Lokio/BufferedSource;", "source", "Lokio/Source;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "path", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* loaded from: classes.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "file.appendingSink()", imports = {"okio.appendingSink"}))
    public final Sink appendingSink(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.appendingSink(file);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "sink.buffer()", imports = {"okio.buffer"}))
    public final BufferedSink buffer(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return Okio.buffer(sink);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "source.buffer()", imports = {"okio.buffer"}))
    public final BufferedSource buffer(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return Okio.buffer(source);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "file.sink()", imports = {"okio.sink"}))
    public final Sink sink(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return JvmOkio2.sink$default(file, false, 1, null);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "outputStream.sink()", imports = {"okio.sink"}))
    public final Sink sink(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "path.sink(*options)", imports = {"okio.sink"}))
    public final Sink sink(Path path, OpenOption... options) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(options, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "socket.sink()", imports = {"okio.sink"}))
    public final Sink sink(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return Okio.sink(socket);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "file.source()", imports = {"okio.source"}))
    public final Source source(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.source(file);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "inputStream.source()", imports = {"okio.source"}))
    public final Source source(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "path.source(*options)", imports = {"okio.source"}))
    public final Source source(Path path, OpenOption... options) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(options, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "socket.source()", imports = {"okio.source"}))
    public final Source source(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return Okio.source(socket);
    }

    @Annotations(level = Annotations3.ERROR, message = "moved to extension function", replaceWith = @Annotations8(expression = "blackholeSink()", imports = {"okio.blackholeSink"}))
    public final Sink blackhole() {
        return Okio.blackhole();
    }
}
