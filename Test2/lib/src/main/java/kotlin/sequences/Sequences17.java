package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.Collections3;

/* compiled from: Sequences.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0096\u0002J\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m17d2 = {"Lkotlin/sequences/EmptySequence;", "Lkotlin/sequences/Sequence;", "", "Lkotlin/sequences/DropTakeSequence;", "()V", "drop", "n", "", "iterator", "", "take", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.sequences.EmptySequence, reason: use source file name */
/* loaded from: classes.dex */
final class Sequences17 implements Sequence, Sequences15 {
    public static final Sequences17 INSTANCE = new Sequences17();

    private Sequences17() {
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return Collections3.INSTANCE;
    }

    @Override // kotlin.sequences.Sequences15
    public Sequences17 drop(int n) {
        return INSTANCE;
    }

    @Override // kotlin.sequences.Sequences15
    public Sequences17 take(int n) {
        return INSTANCE;
    }
}
