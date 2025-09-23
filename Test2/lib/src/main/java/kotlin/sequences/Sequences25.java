package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result2;
import kotlin.Tuples;
import kotlin.Tuples3;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl5;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;

/* compiled from: Sequences.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0002¢\u0006\u0002\b\u001c\u001a)\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\b\u001e\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0'0&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0&0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, m17d2 = {"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "generateSequence", "", "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/sequences/SequencesKt")
/* renamed from: kotlin.sequences.SequencesKt__SequencesKt */
/* loaded from: classes.dex */
public class Sequences25 extends SequencesJVM2 {

    /* compiled from: Sequences.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¨\u0006\u0004"}, m17d2 = {"kotlin/sequences/SequencesKt__SequencesKt$Sequence$1", "Lkotlin/sequences/Sequence;", "iterator", "", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$Sequence$1 */
    public static final class C04771<T> implements Sequence<T> {
        public C04771() {
        }

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return (Iterator) $captured_local_variable$0.invoke();
        }
    }

    private static final <T> Sequence<T> Sequence(Functions<? extends Iterator<? extends T>> functions) {
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt.Sequence.1
            public C04771() {
            }

            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return (Iterator) $captured_local_variable$0.invoke();
            }
        };
    }

    public static final <T> Sequence<T> asSequence(final Iterator<? extends T> asSequence) {
        Intrinsics.checkNotNullParameter(asSequence, "$this$asSequence");
        return SequencesKt.constrainOnce(new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return asSequence;
            }
        });
    }

    public static final <T> Sequence<T> sequenceOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements.length == 0 ? SequencesKt.emptySequence() : ArraysKt.asSequence(elements);
    }

    public static final <T> Sequence<T> emptySequence() {
        return Sequences17.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Sequence<T> orEmpty(Sequence<? extends T> sequence) {
        return sequence != 0 ? sequence : SequencesKt.emptySequence();
    }

    /* compiled from: Sequences.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m17d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m18k = 3, m19mv = {1, 4, 0})
    @DebugMetadata(m25c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", m26f = "Sequences.kt", m27i = {0, 0, 1, 1}, m28l = {69, 71}, m29m = "invokeSuspend", m30n = {"$this$sequence", "iterator", "$this$sequence", "iterator"}, m31s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1 */
    static final class C04841<T> extends ContinuationImpl5 implements Functions13<SequenceBuilder2<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Functions $defaultValue;
        final /* synthetic */ Sequence $this_ifEmpty;
        Object L$0;
        Object L$1;
        int label;

        /* renamed from: p$ */
        private SequenceBuilder2 f332p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04841(Sequence sequence, Functions functions, Continuation continuation) {
            super(2, continuation);
            this.$this_ifEmpty = sequence;
            this.$defaultValue = functions;
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            C04841 c04841 = new C04841(this.$this_ifEmpty, this.$defaultValue, completion);
            c04841.f332p$ = (SequenceBuilder2) obj;
            return c04841;
        }

        @Override // kotlin.jvm.functions.Functions13
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C04841) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result2.throwOnFailure($result);
                SequenceBuilder2 $this$sequence = this.f332p$;
                Iterator iterator = this.$this_ifEmpty.iterator();
                if (iterator.hasNext()) {
                    this.L$0 = $this$sequence;
                    this.L$1 = iterator;
                    this.label = 1;
                    if ($this$sequence.yieldAll(iterator, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    Sequence<? extends T> sequence = (Sequence) this.$defaultValue.invoke();
                    this.L$0 = $this$sequence;
                    this.L$1 = iterator;
                    this.label = 2;
                    if ($this$sequence.yieldAll(sequence, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result2.throwOnFailure($result);
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T> Sequence<T> ifEmpty(Sequence<? extends T> ifEmpty, Functions<? extends Sequence<? extends T>> defaultValue) {
        Intrinsics.checkNotNullParameter(ifEmpty, "$this$ifEmpty");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return SequencesKt.sequence(new C04841(ifEmpty, defaultValue, null));
    }

    /* compiled from: Sequences.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m17d2 = {"<anonymous>", "", "T", "it", "Lkotlin/sequences/Sequence;", "invoke"}, m18k = 3, m19mv = {1, 4, 0})
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$flatten$1 */
    static final class C04791<T> extends Lambda implements Functions2<Sequence<? extends T>, Iterator<? extends T>> {
        public static final C04791 INSTANCE = ;

        C04791() {
        }

        @Override // kotlin.jvm.functions.Functions2
        public final Iterator<T> invoke(Sequence<? extends T> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.iterator();
        }
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> flatten) {
        Intrinsics.checkNotNullParameter(flatten, "$this$flatten");
        return flatten$SequencesKt__SequencesKt(flatten, C04791.INSTANCE);
    }

    /* compiled from: Sequences.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, m17d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, m18k = 3, m19mv = {1, 4, 0})
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$flatten$2 */
    static final class C04802<T> extends Lambda implements Functions2<Iterable<? extends T>, Iterator<? extends T>> {
        public static final C04802 INSTANCE = ;

        C04802() {
        }

        @Override // kotlin.jvm.functions.Functions2
        public final Iterator<T> invoke(Iterable<? extends T> it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.iterator();
        }
    }

    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> flatten) {
        Intrinsics.checkNotNullParameter(flatten, "$this$flatten");
        return flatten$SequencesKt__SequencesKt(flatten, C04802.INSTANCE);
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> sequence, Functions2<? super T, ? extends Iterator<? extends R>> functions2) {
        if (sequence instanceof Sequences31) {
            return ((Sequences31) sequence).flatten$kotlin_stdlib(functions2);
        }
        return new Sequences19(sequence, C04813.INSTANCE, functions2);
    }

    /* compiled from: Sequences.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0004\n\u0002\b\u0006\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m17d2 = {"<anonymous>", "T", "R", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, m18k = 3, m19mv = {1, 4, 0})
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$flatten$3 */
    static final class C04813<T> extends Lambda implements Functions2<T, T> {
        public static final C04813 INSTANCE = ;

        C04813() {
        }

        @Override // kotlin.jvm.functions.Functions2
        public final T invoke(T t) {
            return t;
        }
    }

    public static final <T, R> Tuples<List<T>, List<R>> unzip(Sequence<? extends Tuples<? extends T, ? extends R>> unzip) {
        Intrinsics.checkNotNullParameter(unzip, "$this$unzip");
        ArrayList listT = new ArrayList();
        ArrayList listR = new ArrayList();
        for (Tuples pair : unzip) {
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return Tuples3.m24to(listT, listR);
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> shuffled) {
        Intrinsics.checkNotNullParameter(shuffled, "$this$shuffled");
        return SequencesKt.shuffled(shuffled, Random.INSTANCE);
    }

    /* compiled from: Sequences.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m17d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m18k = 3, m19mv = {1, 4, 0})
    @DebugMetadata(m25c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", m26f = "Sequences.kt", m27i = {0, 0, 0, 0, 0}, m28l = {145}, m29m = "invokeSuspend", m30n = {"$this$sequence", "buffer", "j", "last", "value"}, m31s = {"L$0", "L$1", "I$0", "L$2", "L$3"})
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$shuffled$1 */
    static final class C04851<T> extends ContinuationImpl5 implements Functions13<SequenceBuilder2<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Random $random;
        final /* synthetic */ Sequence $this_shuffled;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* renamed from: p$ */
        private SequenceBuilder2 f333p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04851(Sequence sequence, Random random, Continuation continuation) {
            super(2, continuation);
            this.$this_shuffled = sequence;
            this.$random = random;
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            C04851 c04851 = new C04851(this.$this_shuffled, this.$random, completion);
            c04851.f333p$ = (SequenceBuilder2) obj;
            return c04851;
        }

        @Override // kotlin.jvm.functions.Functions13
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C04851) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0047  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x007b  */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, kotlin.sequences.SequenceScope] */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0074 -> B:41:0x0078). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 1
                if (r1 == 0) goto L2f
                if (r1 != r2) goto L27
                r1 = 0
                r3 = r1
                r4 = r1
                r5 = 0
                r6 = r1
                java.lang.Object r4 = r10.L$3
                java.lang.Object r1 = r10.L$2
                int r5 = r10.I$0
                java.lang.Object r7 = r10.L$1
                r6 = r7
                java.util.List r6 = (java.util.List) r6
                java.lang.Object r7 = r10.L$0
                r3 = r7
                kotlin.sequences.SequenceScope r3 = (kotlin.sequences.SequenceBuilder2) r3
                kotlin.Result2.throwOnFailure(r11)
                r7 = r4
                r4 = r3
                r3 = r10
                goto L78
            L27:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L2f:
                kotlin.Result2.throwOnFailure(r11)
                kotlin.sequences.SequenceScope r1 = r10.f333p$
                kotlin.sequences.Sequence r3 = r10.$this_shuffled
                java.util.List r3 = kotlin.sequences.SequencesKt.toMutableList(r3)
                r6 = r3
                r3 = r1
                r1 = r10
            L3d:
                r4 = r6
                java.util.Collection r4 = (java.util.Collection) r4
                boolean r4 = r4.isEmpty()
                r4 = r4 ^ r2
                if (r4 == 0) goto L7b
                kotlin.random.Random r4 = r1.$random
                int r5 = r6.size()
                int r5 = r4.nextInt(r5)
                java.lang.Object r4 = kotlin.collections.CollectionsKt.removeLast(r6)
                int r7 = r6.size()
                if (r5 >= r7) goto L60
                java.lang.Object r7 = r6.set(r5, r4)
                goto L61
            L60:
                r7 = r4
            L61:
                r1.L$0 = r3
                r1.L$1 = r6
                r1.I$0 = r5
                r1.L$2 = r4
                r1.L$3 = r7
                r1.label = r2
                java.lang.Object r8 = r3.yield(r7, r1)
                if (r8 != r0) goto L74
                return r0
            L74:
                r9 = r3
                r3 = r1
                r1 = r4
                r4 = r9
            L78:
                r1 = r3
                r3 = r4
                goto L3d
            L7b:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.Sequences25.C04851.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> shuffled, Random random) {
        Intrinsics.checkNotNullParameter(shuffled, "$this$shuffled");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt.sequence(new C04851(shuffled, random, null));
    }

    /* compiled from: Sequences.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, m17d2 = {"<anonymous>", "", "T", "C", "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m18k = 3, m19mv = {1, 4, 0})
    @DebugMetadata(m25c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", m26f = "Sequences.kt", m27i = {0, 0, 0, 0}, m28l = {332}, m29m = "invokeSuspend", m30n = {"$this$sequence", "index", "element", "result"}, m31s = {"L$0", "I$0", "L$1", "L$3"})
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1 */
    static final class C04781<R> extends ContinuationImpl5 implements Functions13<SequenceBuilder2<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Functions2 $iterator;
        final /* synthetic */ Sequence $source;
        final /* synthetic */ Functions13 $transform;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* renamed from: p$ */
        private SequenceBuilder2 f331p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04781(Sequence sequence, Functions13 functions13, Functions2 functions2, Continuation continuation) {
            super(2, continuation);
            this.$source = sequence;
            this.$transform = functions13;
            this.$iterator = functions2;
        }

        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkNotNullParameter(completion, "completion");
            C04781 c04781 = new C04781(this.$source, this.$transform, this.$iterator, completion);
            c04781.f331p$ = (SequenceBuilder2) obj;
            return c04781;
        }

        @Override // kotlin.jvm.functions.Functions13
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((C04781) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0070 -> B:39:0x0076). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.ContinuationImpl2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L2c
                if (r1 != r2) goto L24
                r1 = 0
                r3 = r1
                r4 = r1
                r5 = 0
                java.lang.Object r4 = r9.L$3
                java.lang.Object r6 = r9.L$2
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r1 = r9.L$1
                int r5 = r9.I$0
                java.lang.Object r7 = r9.L$0
                r3 = r7
                kotlin.sequences.SequenceScope r3 = (kotlin.sequences.SequenceBuilder2) r3
                kotlin.Result2.throwOnFailure(r10)
                r7 = r6
                r6 = r9
                goto L76
            L24:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L2c:
                kotlin.Result2.throwOnFailure(r10)
                kotlin.sequences.SequenceScope r1 = r9.f331p$
                r3 = 0
                kotlin.sequences.Sequence r4 = r9.$source
                java.util.Iterator r4 = r4.iterator()
                r6 = r4
                r4 = r9
            L3a:
                boolean r5 = r6.hasNext()
                if (r5 == 0) goto L7b
                java.lang.Object r5 = r6.next()
                kotlin.jvm.functions.Function2 r7 = r4.$transform
                int r8 = r3 + 1
                if (r3 >= 0) goto L4d
                kotlin.collections.CollectionsKt.throwIndexOverflow()
            L4d:
                java.lang.Integer r3 = kotlin.coroutines.jvm.internal.boxing.boxInt(r3)
                java.lang.Object r3 = r7.invoke(r3, r5)
                kotlin.jvm.functions.Function1 r7 = r4.$iterator
                java.lang.Object r7 = r7.invoke(r3)
                java.util.Iterator r7 = (java.util.Iterator) r7
                r4.L$0 = r1
                r4.I$0 = r8
                r4.L$1 = r5
                r4.L$2 = r6
                r4.L$3 = r3
                r4.label = r2
                java.lang.Object r7 = r1.yieldAll(r7, r4)
                if (r7 != r0) goto L70
                return r0
            L70:
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r5
                r5 = r8
            L76:
                r1 = r3
                r3 = r5
                r4 = r6
                r6 = r7
                goto L3a
            L7b:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.Sequences25.C04781.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T, C, R> Sequence<R> flatMapIndexed(Sequence<? extends T> source, Functions13<? super Integer, ? super T, ? extends C> transform, Functions2<? super C, ? extends Iterator<? extends R>> iterator) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return SequencesKt.sequence(new C04781(source, transform, iterator, null));
    }

    public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> constrainOnce) {
        Intrinsics.checkNotNullParameter(constrainOnce, "$this$constrainOnce");
        return constrainOnce instanceof SequencesJVM ? (SequencesJVM) constrainOnce : new SequencesJVM(constrainOnce);
    }

    /* compiled from: Sequences.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u0002H\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m17d2 = {"<anonymous>", "T", "", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"}, m18k = 3, m19mv = {1, 4, 0})
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1 */
    static final class C04821<T> extends Lambda implements Functions2<T, T> {
        C04821() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Functions2
        public final T invoke(T it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return (T) functions.invoke();
        }
    }

    public static final <T> Sequence<T> generateSequence(Functions<? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return SequencesKt.constrainOnce(new Sequences20(nextFunction, new Functions2<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt.generateSequence.1
            C04821() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Functions2
            public final T invoke(T it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (T) functions.invoke();
            }
        }));
    }

    public static final <T> Sequence<T> generateSequence(T t, Functions2<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        if (t == null) {
            return Sequences17.INSTANCE;
        }
        return new Sequences20(new Functions<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt.generateSequence.2
            final /* synthetic */ Object $seed;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C04832(Object t2) {
                super(0);
                obj = t2;
            }

            @Override // kotlin.jvm.functions.Functions
            public final T invoke() {
                return (T) obj;
            }
        }, nextFunction);
    }

    /* compiled from: Sequences.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m17d2 = {"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"}, m18k = 3, m19mv = {1, 4, 0})
    /* renamed from: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2 */
    static final class C04832<T> extends Lambda implements Functions<T> {
        final /* synthetic */ Object $seed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04832(Object t2) {
            super(0);
            obj = t2;
        }

        @Override // kotlin.jvm.functions.Functions
        public final T invoke() {
            return (T) obj;
        }
    }

    public static final <T> Sequence<T> generateSequence(Functions<? extends T> seedFunction, Functions2<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new Sequences20(seedFunction, nextFunction);
    }
}
