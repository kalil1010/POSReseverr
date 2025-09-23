package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: _Sequences.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005¢\u0006\u0002\b\u0006"}, m17d2 = {"<anonymous>", "", "R", "T", "p1", "Lkotlin/sequences/Sequence;", "invoke"}, m18k = 3, m19mv = {1, 4, 0})
/* renamed from: kotlin.sequences.SequencesKt___SequencesKt$flatMapIndexed$2, reason: use source file name */
/* loaded from: classes.dex */
final /* synthetic */ class _Sequences3<R> extends FunctionReferenceImpl implements Functions2<Sequence<? extends R>, Iterator<? extends R>> {
    public static final _Sequences3 INSTANCE = new _Sequences3();

    _Sequences3() {
        super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // kotlin.jvm.functions.Functions2
    public final Iterator<R> invoke(Sequence<? extends R> p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        return p1.iterator();
    }
}
