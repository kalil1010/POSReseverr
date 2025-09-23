package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Annotations;
import kotlin.Annotations3;
import kotlin.Annotations8;
import kotlin.Metadata;
import kotlin.Standard;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MutableCollectionsJVM.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\u0019\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a!\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0087\b\u001a \u0010\t\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a6\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\r0\fH\u0087\bø\u0001\u0000\u001a5\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000fj\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0010H\u0087\b\u001a2\u0010\u0011\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001a\u0010\u000e\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u000fj\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, m17d2 = {"fill", "", "T", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "sort", "", "comparison", "Lkotlin/Function2;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.CollectionsKt__MutableCollectionsJVMKt, reason: use source file name */
/* loaded from: classes.dex */
public class MutableCollectionsJVM extends Iterators4 {
    @Annotations(level = Annotations3.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @Annotations8(expression = "this.sortWith(comparator)", imports = {}))
    private static final <T> void sort(List<T> list, Comparator<? super T> comparator) {
        throw new Standard(null, 1, null);
    }

    @Annotations(level = Annotations3.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @Annotations8(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    private static final <T> void sort(List<T> list, Functions13<? super T, ? super T, Integer> functions13) {
        throw new Standard(null, 1, null);
    }

    public static final <T extends Comparable<? super T>> void sort(List<T> sort) {
        Intrinsics.checkNotNullParameter(sort, "$this$sort");
        if (sort.size() > 1) {
            Collections.sort(sort);
        }
    }

    public static final <T> void sortWith(List<T> sortWith, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(sortWith, "$this$sortWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (sortWith.size() > 1) {
            Collections.sort(sortWith, comparator);
        }
    }

    private static final <T> void fill(List<T> list, T t) {
        Collections.fill(list, t);
    }

    private static final <T> void shuffle(List<T> list) {
        Collections.shuffle(list);
    }

    private static final <T> void shuffle(List<T> list, Random random) {
        Collections.shuffle(list, random);
    }
}
