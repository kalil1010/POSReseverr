package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt;
import kotlin.internal.PlatformImplementations2;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.Ranges6;
import kotlin.sequences.SequencesKt;

/* compiled from: Regex.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0096\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000fH\u0096\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m17d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", "", "getSize", "()I", "get", "index", "name", "", "isEmpty", "", "iterator", "", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.text.MatcherMatchResult$groups$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Regex6 extends AbstractCollection<MatchGroup> implements MatchResult3 {
    final /* synthetic */ Regex4 this$0;

    Regex6(Regex4 this$0) {
        this.this$0 = this$0;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj != null ? obj instanceof MatchGroup : true) {
            return contains((MatchGroup) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(MatchGroup matchGroup) {
        return super.contains((Object) matchGroup);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.this$0.getMatchResult().groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<MatchGroup> iterator() {
        return SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), new Functions2<Integer, MatchGroup>() { // from class: kotlin.text.MatcherMatchResult$groups$1$iterator$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Functions2
            public /* bridge */ /* synthetic */ MatchGroup invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MatchGroup invoke(int it) {
                return this.this$0.get(it);
            }
        }).iterator();
    }

    @Override // kotlin.text.MatchResult2
    public MatchGroup get(int index) {
        Ranges6 range = Regex9.range(this.this$0.getMatchResult(), index);
        if (range.getStart().intValue() >= 0) {
            String strGroup = this.this$0.getMatchResult().group(index);
            Intrinsics.checkNotNullExpressionValue(strGroup, "matchResult.group(index)");
            return new MatchGroup(strGroup, range);
        }
        return null;
    }

    @Override // kotlin.text.MatchResult3
    public MatchGroup get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return PlatformImplementations2.IMPLEMENTATIONS.getMatchResultNamedGroup(this.this$0.getMatchResult(), name);
    }
}
