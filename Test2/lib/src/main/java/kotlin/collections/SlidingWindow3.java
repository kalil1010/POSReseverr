package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl5;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceBuilder2;
import kotlin.sequences.SequencesKt;

/* compiled from: SlidingWindow.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, m17d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", "T", "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* renamed from: kotlin.collections.SlidingWindowKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SlidingWindow3 {
    public static final void checkWindowSizeStep(int size, int step) {
        String str;
        if (!(size > 0 && step > 0)) {
            if (size != step) {
                str = "Both size " + size + " and step " + step + " must be greater than zero.";
            } else {
                str = "size " + size + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> windowedSequence, final int i, final int i2, final boolean z, final boolean z2) {
        Intrinsics.checkNotNullParameter(windowedSequence, "$this$windowedSequence");
        checkWindowSizeStep(i, i2);
        return new Sequence<List<? extends T>>() { // from class: kotlin.collections.SlidingWindowKt$windowedSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<List<? extends T>> iterator() {
                return SlidingWindow3.windowedIterator(windowedSequence.iterator(), i, i2, z, z2);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m17d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m18k = 3, m19mv = {1, 4, 0})
    @DebugMetadata(m25c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", m26f = "SlidingWindow.kt", m27i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, m28l = {34, 40, 49, 55, 58}, m29m = "invokeSuspend", m30n = {"$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "skip", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "e", "$this$iterator", "bufferInitialCapacity", "gap", "buffer", "$this$iterator", "bufferInitialCapacity", "gap", "buffer"}, m31s = {"L$0", "I$0", "I$1", "L$1", "I$2", "L$2", "L$0", "I$0", "I$1", "L$1", "I$2", "L$0", "I$0", "I$1", "L$1", "L$2", "L$0", "I$0", "I$1", "L$1", "L$0", "I$0", "I$1", "L$1"})
    /* renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1 */
    static final class C04351<T> extends ContinuationImpl5 implements Functions13<SequenceBuilder2<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Iterator $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* renamed from: p$ */
        private SequenceBuilder2 f321p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04351(int i, int i2, Iterator it, boolean z, boolean z2, Continuation continuation) {
            super(2, continuation);
            this.$size = i;
            this.$step = i2;
            this.$iterator = it;
            this.$reuseBuffer = z;
            this.$partialWindows = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            C04351 c04351 = new C04351(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, completion);
            c04351.f321p$ = (SequenceBuilder2) obj;
            return c04351;
        }

        @Override // kotlin.jvm.functions.Functions13
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C04351) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x015f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0160  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0178  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01c3  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x01f5  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0217  */
        /* JADX WARN: Type inference failed for: r9v27 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v6 */
        /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object, kotlin.collections.RingBuffer] */
        /* JADX WARN: Type inference failed for: r9v8 */
        /* JADX WARN: Type inference failed for: r9v9, types: [kotlin.collections.RingBuffer] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0119 -> B:31:0x0121). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x01b6 -> B:63:0x01b9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x01ec -> B:77:0x01ef). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instructions count: 540
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindow3.C04351.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> iterator, int size, int step, boolean partialWindows, boolean reuseBuffer) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return !iterator.hasNext() ? Collections3.INSTANCE : SequencesKt.iterator(new C04351(size, step, iterator, reuseBuffer, partialWindows, null));
    }
}
