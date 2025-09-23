package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import kotlin.Metadata;

@Metadata(m15bv = {1, 0, 3}, m16d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, m18k = 4, m19mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Okio {
    public static final Sink appendingSink(File $this$appendingSink) throws FileNotFoundException {
        return JvmOkio2.appendingSink($this$appendingSink);
    }

    public static final Sink blackhole() {
        return Okio3.blackhole();
    }

    public static final BufferedSink buffer(Sink $this$buffer) {
        return Okio3.buffer($this$buffer);
    }

    public static final BufferedSource buffer(Source $this$buffer) {
        return Okio3.buffer($this$buffer);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError $this$isAndroidGetsocknameError) {
        return JvmOkio2.isAndroidGetsocknameError($this$isAndroidGetsocknameError);
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        return JvmOkio2.sink$default(file, false, 1, null);
    }

    public static final Sink sink(File $this$sink, boolean append) throws FileNotFoundException {
        return JvmOkio2.sink($this$sink, append);
    }

    public static final Sink sink(OutputStream $this$sink) {
        return JvmOkio2.sink($this$sink);
    }

    public static final Sink sink(Socket $this$sink) throws IOException {
        return JvmOkio2.sink($this$sink);
    }

    public static final Sink sink(Path $this$sink, OpenOption... options) throws IOException {
        return JvmOkio2.sink($this$sink, options);
    }

    public static final Source source(File $this$source) throws FileNotFoundException {
        return JvmOkio2.source($this$source);
    }

    public static final Source source(InputStream $this$source) {
        return JvmOkio2.source($this$source);
    }

    public static final Source source(Socket $this$source) throws IOException {
        return JvmOkio2.source($this$source);
    }

    public static final Source source(Path $this$source, OpenOption... options) throws IOException {
        return JvmOkio2.source($this$source, options);
    }
}
