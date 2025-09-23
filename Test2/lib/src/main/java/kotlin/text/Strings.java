package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMarkers;
import kotlin.ranges.Ranges6;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/* compiled from: Strings.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012:\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0096\u0002RB\u0010\b\u001a6\u0012\u0004\u0012\u00020\u0004\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r0\t¢\u0006\u0002\b\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m17d2 = {"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "currentIndex", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.text.DelimitedRangesSequence, reason: use source file name */
/* loaded from: classes.dex */
final class Strings implements Sequence<Ranges6> {
    private final Functions13<CharSequence, Integer, Tuples<Integer, Integer>> getNextMatch;
    private final CharSequence input;
    private final int limit;
    private final int startIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public Strings(CharSequence input, int startIndex, int limit, Functions13<? super CharSequence, ? super Integer, Tuples<Integer, Integer>> getNextMatch) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(getNextMatch, "getNextMatch");
        this.input = input;
        this.startIndex = startIndex;
        this.limit = limit;
        this.getNextMatch = getNextMatch;
    }

    /* compiled from: Strings.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, m17d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
    /* renamed from: kotlin.text.DelimitedRangesSequence$iterator$1 */
    public static final class C05171 implements Iterator<Ranges6>, KMarkers {
        private int counter;
        private int currentStartIndex;
        private Ranges6 nextItem;
        private int nextSearchIndex;
        private int nextState = -1;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C05171() {
            int iCoerceIn = RangesKt.coerceIn(Strings.this.startIndex, 0, Strings.this.input.length());
            this.currentStartIndex = iCoerceIn;
            this.nextSearchIndex = iCoerceIn;
        }

        public final int getNextState() {
            return this.nextState;
        }

        public final void setNextState(int i) {
            this.nextState = i;
        }

        public final int getCurrentStartIndex() {
            return this.currentStartIndex;
        }

        public final void setCurrentStartIndex(int i) {
            this.currentStartIndex = i;
        }

        public final int getNextSearchIndex() {
            return this.nextSearchIndex;
        }

        public final void setNextSearchIndex(int i) {
            this.nextSearchIndex = i;
        }

        public final Ranges6 getNextItem() {
            return this.nextItem;
        }

        public final void setNextItem(Ranges6 ranges6) {
            this.nextItem = ranges6;
        }

        public final int getCounter() {
            return this.counter;
        }

        public final void setCounter(int i) {
            this.counter = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void calcNext() {
            /*
                r6 = this;
                int r0 = r6.nextSearchIndex
                r1 = 0
                if (r0 >= 0) goto Le
                r6.nextState = r1
                r0 = 0
                kotlin.ranges.IntRange r0 = (kotlin.ranges.Ranges6) r0
                r6.nextItem = r0
                goto La3
            Le:
                kotlin.text.DelimitedRangesSequence r0 = kotlin.text.Strings.this
                int r0 = kotlin.text.Strings.access$getLimit$p(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L25
                int r0 = r6.counter
                int r0 = r0 + r3
                r6.counter = r0
                kotlin.text.DelimitedRangesSequence r4 = kotlin.text.Strings.this
                int r4 = kotlin.text.Strings.access$getLimit$p(r4)
                if (r0 >= r4) goto L33
            L25:
                int r0 = r6.nextSearchIndex
                kotlin.text.DelimitedRangesSequence r4 = kotlin.text.Strings.this
                java.lang.CharSequence r4 = kotlin.text.Strings.access$getInput$p(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L49
            L33:
                int r0 = r6.currentStartIndex
                kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
                kotlin.text.DelimitedRangesSequence r4 = kotlin.text.Strings.this
                java.lang.CharSequence r4 = kotlin.text.Strings.access$getInput$p(r4)
                int r4 = kotlin.text.StringsKt.getLastIndex(r4)
                r1.<init>(r0, r4)
                r6.nextItem = r1
                r6.nextSearchIndex = r2
                goto L9f
            L49:
                kotlin.text.DelimitedRangesSequence r0 = kotlin.text.Strings.this
                kotlin.jvm.functions.Function2 r0 = kotlin.text.Strings.access$getGetNextMatch$p(r0)
                kotlin.text.DelimitedRangesSequence r4 = kotlin.text.Strings.this
                java.lang.CharSequence r4 = kotlin.text.Strings.access$getInput$p(r4)
                int r5 = r6.nextSearchIndex
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                kotlin.Pair r0 = (kotlin.Tuples) r0
                if (r0 != 0) goto L79
                int r1 = r6.currentStartIndex
                kotlin.ranges.IntRange r4 = new kotlin.ranges.IntRange
                kotlin.text.DelimitedRangesSequence r5 = kotlin.text.Strings.this
                java.lang.CharSequence r5 = kotlin.text.Strings.access$getInput$p(r5)
                int r5 = kotlin.text.StringsKt.getLastIndex(r5)
                r4.<init>(r1, r5)
                r6.nextItem = r4
                r6.nextSearchIndex = r2
                goto L9f
            L79:
                java.lang.Object r2 = r0.component1()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r4 = r0.component2()
                java.lang.Number r4 = (java.lang.Number) r4
                int r4 = r4.intValue()
                int r5 = r6.currentStartIndex
                kotlin.ranges.IntRange r5 = kotlin.ranges.RangesKt.until(r5, r2)
                r6.nextItem = r5
                int r5 = r2 + r4
                r6.currentStartIndex = r5
                if (r4 != 0) goto L9c
                r1 = 1
            L9c:
                int r5 = r5 + r1
                r6.nextSearchIndex = r5
            L9f:
                r6.nextState = r3
            La3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Strings.C05171.calcNext():void");
        }

        @Override // java.util.Iterator
        public Ranges6 next() {
            if (this.nextState == -1) {
                calcNext();
            }
            if (this.nextState == 0) {
                throw new NoSuchElementException();
            }
            Ranges6 result = this.nextItem;
            if (result == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            this.nextItem = (Ranges6) null;
            this.nextState = -1;
            return result;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextState == -1) {
                calcNext();
            }
            return this.nextState == 1;
        }
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Ranges6> iterator() {
        return new C05171();
    }
}
