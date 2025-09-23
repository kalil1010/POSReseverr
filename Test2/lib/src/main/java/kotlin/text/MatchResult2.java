package kotlin.text;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMarkers;

/* compiled from: MatchResult.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0006"}, m17d2 = {"Lkotlin/text/MatchGroupCollection;", "", "Lkotlin/text/MatchGroup;", "get", "index", "", "kotlin-stdlib"}, m18k = 1, m19mv = {1, 4, 0})
/* renamed from: kotlin.text.MatchGroupCollection, reason: use source file name */
/* loaded from: classes.dex */
public interface MatchResult2 extends Collection<MatchGroup>, KMarkers {
    MatchGroup get(int index);
}
