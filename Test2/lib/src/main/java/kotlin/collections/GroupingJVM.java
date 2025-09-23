package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: GroupingJVM.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001a0\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0007\u001aZ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001e\u0010\n\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000bH\u0081\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, m17d2 = {"eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/collections/GroupingKt")
/* renamed from: kotlin.collections.GroupingKt__GroupingJVMKt */
/* loaded from: classes.dex */
class GroupingJVM {
    public static final <T, K> Map<K, Integer> eachCount(Grouping<T, ? extends K> eachCount) {
        Intrinsics.checkNotNullParameter(eachCount, "$this$eachCount");
        Map destination$iv = new LinkedHashMap();
        Grouping $this$foldTo$iv = eachCount;
        Iterator<T> itSourceIterator = $this$foldTo$iv.sourceIterator();
        while (itSourceIterator.hasNext()) {
            K kKeyOf = $this$foldTo$iv.keyOf(itSourceIterator.next());
            Object accumulator$iv$iv = destination$iv.get(kKeyOf);
            boolean first$iv = accumulator$iv$iv == null && !destination$iv.containsKey(kKeyOf);
            Ref.IntRef acc = (Ref.IntRef) (first$iv ? new Ref.IntRef() : accumulator$iv$iv);
            acc.element++;
            destination$iv.put(kKeyOf, acc);
            $this$foldTo$iv = $this$foldTo$iv;
        }
        for (Map.Entry it : destination$iv.entrySet()) {
            if (it == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            TypeIntrinsics.asMutableMapEntry(it).setValue(Integer.valueOf(((Ref.IntRef) it.getValue()).element));
        }
        return TypeIntrinsics.asMutableMap(destination$iv);
    }

    private static final <K, V, R> Map<K, R> mapValuesInPlace(Map<K, V> map, Functions2<? super Map.Entry<? extends K, ? extends V>, ? extends R> functions2) {
        Iterable $this$forEach$iv = map.entrySet();
        for (Object element$iv : $this$forEach$iv) {
            Map.Entry it = (Map.Entry) element$iv;
            if (it == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            TypeIntrinsics.asMutableMapEntry(it).setValue(functions2.invoke(it));
        }
        if (map != null) {
            return TypeIntrinsics.asMutableMap(map);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
    }
}
