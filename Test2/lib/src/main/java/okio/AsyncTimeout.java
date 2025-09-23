package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncTimeout.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J%\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m17d2 = {"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, m18k = 1, m19mv = {1, 4, 0})
/* loaded from: classes.dex */
public class AsyncTimeout extends Timeout {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    public final void enter() {
        if (!(!this.inQueue)) {
            throw new IllegalStateException("Unbalanced enter/exit".toString());
        }
        long timeoutNanos = getTimeoutNanos();
        boolean hasDeadline = getHasDeadline();
        if (timeoutNanos == 0 && !hasDeadline) {
            return;
        }
        this.inQueue = true;
        INSTANCE.scheduleTimeout(this, timeoutNanos, hasDeadline);
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return INSTANCE.cancelScheduledTimeout(this);
    }

    public final long remainingNanos(long now) {
        return this.timeoutAt - now;
    }

    protected void timedOut() {
    }

    /* compiled from: AsyncTimeout.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, m17d2 = {"okio/AsyncTimeout$sink$1", "Lokio/Sink;", "close", "", "flush", "timeout", "Lokio/AsyncTimeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, m18k = 1, m19mv = {1, 4, 0})
    /* renamed from: okio.AsyncTimeout$sink$1 */
    public static final class C05521 implements Sink {
        final /* synthetic */ Sink $sink;

        C05521(Sink $captured_local_variable$1) {
            $captured_local_variable$1 = $captured_local_variable$1;
        }

        @Override // okio.Sink
        public void write(Buffer source, long byteCount) throws IOException {
            long toWrite;
            Intrinsics.checkNotNullParameter(source, "source");
            Util.checkOffsetAndCount(source.size(), 0L, byteCount);
            for (long remaining = byteCount; remaining > 0; remaining -= toWrite) {
                toWrite = 0;
                Segment s = source.head;
                Intrinsics.checkNotNull(s);
                while (true) {
                    if (toWrite >= 65536) {
                        break;
                    }
                    int segmentSize = s.limit - s.pos;
                    toWrite += segmentSize;
                    if (toWrite >= remaining) {
                        toWrite = remaining;
                        break;
                    } else {
                        Segment segment = s.next;
                        Intrinsics.checkNotNull(segment);
                        s = segment;
                    }
                }
                AsyncTimeout this_$iv = AsyncTimeout.this;
                this_$iv.enter();
                try {
                    try {
                        $captured_local_variable$1.write(source, toWrite);
                        Unit unit = Unit.INSTANCE;
                        boolean timedOut$iv = this_$iv.exit();
                        if (timedOut$iv) {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (!this_$iv.exit()) {
                            throw e$iv;
                        }
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (timedOut$iv2 && 0 != 0) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                    throw th;
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            AsyncTimeout this_$iv = AsyncTimeout.this;
            this_$iv.enter();
            try {
                try {
                    $captured_local_variable$1.flush();
                    Unit unit = Unit.INSTANCE;
                    boolean timedOut$iv = this_$iv.exit();
                    if (!timedOut$iv) {
                    } else {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                } catch (IOException e$iv) {
                    if (!this_$iv.exit()) {
                        throw e$iv;
                    }
                    throw this_$iv.access$newTimeoutException(e$iv);
                }
            } catch (Throwable th) {
                boolean timedOut$iv2 = this_$iv.exit();
                if (timedOut$iv2 && 0 != 0) {
                    throw this_$iv.access$newTimeoutException(null);
                }
                throw th;
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            AsyncTimeout this_$iv = AsyncTimeout.this;
            this_$iv.enter();
            try {
                try {
                    $captured_local_variable$1.close();
                    Unit unit = Unit.INSTANCE;
                    boolean timedOut$iv = this_$iv.exit();
                    if (!timedOut$iv) {
                    } else {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                } catch (IOException e$iv) {
                    if (!this_$iv.exit()) {
                        throw e$iv;
                    }
                    throw this_$iv.access$newTimeoutException(e$iv);
                }
            } catch (Throwable th) {
                boolean timedOut$iv2 = this_$iv.exit();
                if (timedOut$iv2 && 0 != 0) {
                    throw this_$iv.access$newTimeoutException(null);
                }
                throw th;
            }
        }

        @Override // okio.Sink
        /* renamed from: timeout, reason: from getter */
        public AsyncTimeout getThis$0() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + $captured_local_variable$1 + ')';
        }
    }

    public final Sink sink(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout.sink.1
            final /* synthetic */ Sink $sink;

            C05521(Sink sink2) {
                $captured_local_variable$1 = sink2;
            }

            @Override // okio.Sink
            public void write(Buffer source, long byteCount) throws IOException {
                long toWrite;
                Intrinsics.checkNotNullParameter(source, "source");
                Util.checkOffsetAndCount(source.size(), 0L, byteCount);
                for (long remaining = byteCount; remaining > 0; remaining -= toWrite) {
                    toWrite = 0;
                    Segment s = source.head;
                    Intrinsics.checkNotNull(s);
                    while (true) {
                        if (toWrite >= 65536) {
                            break;
                        }
                        int segmentSize = s.limit - s.pos;
                        toWrite += segmentSize;
                        if (toWrite >= remaining) {
                            toWrite = remaining;
                            break;
                        } else {
                            Segment segment = s.next;
                            Intrinsics.checkNotNull(segment);
                            s = segment;
                        }
                    }
                    AsyncTimeout this_$iv = AsyncTimeout.this;
                    this_$iv.enter();
                    try {
                        try {
                            $captured_local_variable$1.write(source, toWrite);
                            Unit unit = Unit.INSTANCE;
                            boolean timedOut$iv = this_$iv.exit();
                            if (timedOut$iv) {
                                throw this_$iv.access$newTimeoutException(null);
                            }
                        } catch (IOException e$iv) {
                            if (!this_$iv.exit()) {
                                throw e$iv;
                            }
                            throw this_$iv.access$newTimeoutException(e$iv);
                        }
                    } catch (Throwable th) {
                        boolean timedOut$iv2 = this_$iv.exit();
                        if (timedOut$iv2 && 0 != 0) {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                        throw th;
                    }
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout this_$iv = AsyncTimeout.this;
                this_$iv.enter();
                try {
                    try {
                        $captured_local_variable$1.flush();
                        Unit unit = Unit.INSTANCE;
                        boolean timedOut$iv = this_$iv.exit();
                        if (!timedOut$iv) {
                        } else {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (!this_$iv.exit()) {
                            throw e$iv;
                        }
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (timedOut$iv2 && 0 != 0) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                    throw th;
                }
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout this_$iv = AsyncTimeout.this;
                this_$iv.enter();
                try {
                    try {
                        $captured_local_variable$1.close();
                        Unit unit = Unit.INSTANCE;
                        boolean timedOut$iv = this_$iv.exit();
                        if (!timedOut$iv) {
                        } else {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (!this_$iv.exit()) {
                            throw e$iv;
                        }
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (timedOut$iv2 && 0 != 0) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                    throw th;
                }
            }

            @Override // okio.Sink
            /* renamed from: timeout, reason: from getter */
            public AsyncTimeout getThis$0() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.sink(" + $captured_local_variable$1 + ')';
            }
        };
    }

    /* compiled from: AsyncTimeout.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, m17d2 = {"okio/AsyncTimeout$source$1", "Lokio/Source;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/AsyncTimeout;", "toString", "", "okio"}, m18k = 1, m19mv = {1, 4, 0})
    /* renamed from: okio.AsyncTimeout$source$1 */
    public static final class C05531 implements Source {
        final /* synthetic */ Source $source;

        C05531(Source $captured_local_variable$1) {
            $captured_local_variable$1 = $captured_local_variable$1;
        }

        @Override // okio.Source
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            AsyncTimeout this_$iv = AsyncTimeout.this;
            this_$iv.enter();
            try {
                try {
                    long result$iv = $captured_local_variable$1.read(sink, byteCount);
                    boolean timedOut$iv = this_$iv.exit();
                    if (!timedOut$iv) {
                        return result$iv;
                    }
                    throw this_$iv.access$newTimeoutException(null);
                } catch (IOException e$iv) {
                    if (this_$iv.exit()) {
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                    throw e$iv;
                }
            } catch (Throwable th) {
                boolean timedOut$iv2 = this_$iv.exit();
                if (!timedOut$iv2 || 0 == 0) {
                    throw th;
                }
                throw this_$iv.access$newTimeoutException(null);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            AsyncTimeout this_$iv = AsyncTimeout.this;
            this_$iv.enter();
            try {
                try {
                    $captured_local_variable$1.close();
                    Unit unit = Unit.INSTANCE;
                    boolean timedOut$iv = this_$iv.exit();
                    if (!timedOut$iv) {
                    } else {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                } catch (IOException e$iv) {
                    if (!this_$iv.exit()) {
                        throw e$iv;
                    }
                    throw this_$iv.access$newTimeoutException(e$iv);
                }
            } catch (Throwable th) {
                boolean timedOut$iv2 = this_$iv.exit();
                if (timedOut$iv2 && 0 != 0) {
                    throw this_$iv.access$newTimeoutException(null);
                }
                throw th;
            }
        }

        @Override // okio.Source
        /* renamed from: timeout, reason: from getter */
        public AsyncTimeout getThis$0() {
            return AsyncTimeout.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + $captured_local_variable$1 + ')';
        }
    }

    public final Source source(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new Source() { // from class: okio.AsyncTimeout.source.1
            final /* synthetic */ Source $source;

            C05531(Source source2) {
                $captured_local_variable$1 = source2;
            }

            @Override // okio.Source
            public long read(Buffer sink, long byteCount) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                AsyncTimeout this_$iv = AsyncTimeout.this;
                this_$iv.enter();
                try {
                    try {
                        long result$iv = $captured_local_variable$1.read(sink, byteCount);
                        boolean timedOut$iv = this_$iv.exit();
                        if (!timedOut$iv) {
                            return result$iv;
                        }
                        throw this_$iv.access$newTimeoutException(null);
                    } catch (IOException e$iv) {
                        if (this_$iv.exit()) {
                            throw this_$iv.access$newTimeoutException(e$iv);
                        }
                        throw e$iv;
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (!timedOut$iv2 || 0 == 0) {
                        throw th;
                    }
                    throw this_$iv.access$newTimeoutException(null);
                }
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout this_$iv = AsyncTimeout.this;
                this_$iv.enter();
                try {
                    try {
                        $captured_local_variable$1.close();
                        Unit unit = Unit.INSTANCE;
                        boolean timedOut$iv = this_$iv.exit();
                        if (!timedOut$iv) {
                        } else {
                            throw this_$iv.access$newTimeoutException(null);
                        }
                    } catch (IOException e$iv) {
                        if (!this_$iv.exit()) {
                            throw e$iv;
                        }
                        throw this_$iv.access$newTimeoutException(e$iv);
                    }
                } catch (Throwable th) {
                    boolean timedOut$iv2 = this_$iv.exit();
                    if (timedOut$iv2 && 0 != 0) {
                        throw this_$iv.access$newTimeoutException(null);
                    }
                    throw th;
                }
            }

            @Override // okio.Source
            /* renamed from: timeout, reason: from getter */
            public AsyncTimeout getThis$0() {
                return AsyncTimeout.this;
            }

            public String toString() {
                return "AsyncTimeout.source(" + $captured_local_variable$1 + ')';
            }
        };
    }

    public final <T> T withTimeout(Functions<? extends T> block) throws IOException {
        Intrinsics.checkNotNullParameter(block, "block");
        enter();
        try {
            try {
                T tInvoke = block.invoke();
                InlineMarker.finallyStart(1);
                boolean timedOut = exit();
                if (!timedOut) {
                    InlineMarker.finallyEnd(1);
                    return tInvoke;
                }
                throw access$newTimeoutException(null);
            } catch (IOException e) {
                if (exit()) {
                    throw access$newTimeoutException(e);
                }
                throw e;
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            boolean timedOut2 = exit();
            if (timedOut2 && 0 != 0) {
                throw access$newTimeoutException(null);
            }
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public final IOException access$newTimeoutException(IOException cause) {
        return newTimeoutException(cause);
    }

    protected IOException newTimeoutException(IOException cause) {
        InterruptedIOException e = new InterruptedIOException("timeout");
        if (cause != null) {
            e.initCause(cause);
        }
        return e;
    }

    /* compiled from: AsyncTimeout.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m17d2 = {"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"}, m18k = 1, m19mv = {1, 4, 0})
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout asyncTimeoutAwaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        asyncTimeoutAwaitTimeout$okio = AsyncTimeout.INSTANCE.awaitTimeout$okio();
                        if (asyncTimeoutAwaitTimeout$okio == AsyncTimeout.head) {
                            AsyncTimeout.head = (AsyncTimeout) null;
                            return;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    if (asyncTimeoutAwaitTimeout$okio != null) {
                        asyncTimeoutAwaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /* compiled from: AsyncTimeout.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m17d2 = {"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"}, m18k = 1, m19mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final void scheduleTimeout(AsyncTimeout node, long timeoutNanos, boolean hasDeadline) {
            synchronized (AsyncTimeout.class) {
                if (AsyncTimeout.head == null) {
                    AsyncTimeout.head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long now = System.nanoTime();
                if (timeoutNanos != 0 && hasDeadline) {
                    node.timeoutAt = Math.min(timeoutNanos, node.deadlineNanoTime() - now) + now;
                } else if (timeoutNanos != 0) {
                    node.timeoutAt = now + timeoutNanos;
                } else if (hasDeadline) {
                    node.timeoutAt = node.deadlineNanoTime();
                } else {
                    throw new AssertionError();
                }
                long remainingNanos = node.remainingNanos(now);
                AsyncTimeout prev = AsyncTimeout.head;
                Intrinsics.checkNotNull(prev);
                while (prev.next != null) {
                    AsyncTimeout asyncTimeout = prev.next;
                    Intrinsics.checkNotNull(asyncTimeout);
                    if (remainingNanos < asyncTimeout.remainingNanos(now)) {
                        break;
                    }
                    AsyncTimeout asyncTimeout2 = prev.next;
                    Intrinsics.checkNotNull(asyncTimeout2);
                    prev = asyncTimeout2;
                }
                node.next = prev.next;
                prev.next = node;
                if (prev == AsyncTimeout.head) {
                    AsyncTimeout.class.notify();
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        public final boolean cancelScheduledTimeout(AsyncTimeout node) {
            synchronized (AsyncTimeout.class) {
                for (AsyncTimeout prev = AsyncTimeout.head; prev != null; prev = prev.next) {
                    if (prev.next == node) {
                        prev.next = node.next;
                        node.next = (AsyncTimeout) null;
                        return false;
                    }
                }
                return true;
            }
        }

        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            Intrinsics.checkNotNull(asyncTimeout);
            AsyncTimeout node = asyncTimeout.next;
            if (node == null) {
                long startNanos = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
                AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
                Intrinsics.checkNotNull(asyncTimeout2);
                if (asyncTimeout2.next == null && System.nanoTime() - startNanos >= AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return AsyncTimeout.head;
                }
                return null;
            }
            long startNanos2 = System.nanoTime();
            long waitNanos = node.remainingNanos(startNanos2);
            if (waitNanos <= 0) {
                AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                Intrinsics.checkNotNull(asyncTimeout3);
                asyncTimeout3.next = node.next;
                node.next = (AsyncTimeout) null;
                return node;
            }
            long waitMillis = waitNanos / 1000000;
            AsyncTimeout.class.wait(waitMillis, (int) (waitNanos - (1000000 * waitMillis)));
            return null;
        }
    }
}
