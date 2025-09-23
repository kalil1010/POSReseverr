package androidx.core.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.Iterators8;
import kotlin.collections.Iterators9;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SparseLongArray.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001aE\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0087\b\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0087\b\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\u0002\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006!"}, m17d2 = {"size", "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", "other", "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.util.SparseLongArrayKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SparseLongArray {
    public static final int getSize(android.util.SparseLongArray size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$size");
        return size.size();
    }

    public static final boolean contains(android.util.SparseLongArray contains, int key) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.indexOfKey(key) >= 0;
    }

    public static final void set(android.util.SparseLongArray set, int key, long value) {
        Intrinsics.checkParameterIsNotNull(set, "$this$set");
        set.put(key, value);
    }

    public static final android.util.SparseLongArray plus(android.util.SparseLongArray plus, android.util.SparseLongArray other) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(other, "other");
        android.util.SparseLongArray sparseLongArray = new android.util.SparseLongArray(plus.size() + other.size());
        putAll(sparseLongArray, plus);
        putAll(sparseLongArray, other);
        return sparseLongArray;
    }

    public static final boolean containsKey(android.util.SparseLongArray containsKey, int key) {
        Intrinsics.checkParameterIsNotNull(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(key) >= 0;
    }

    public static final boolean containsValue(android.util.SparseLongArray containsValue, long value) {
        Intrinsics.checkParameterIsNotNull(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(value) >= 0;
    }

    public static final long getOrDefault(android.util.SparseLongArray getOrDefault, int key, long defaultValue) {
        Intrinsics.checkParameterIsNotNull(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(key, defaultValue);
    }

    public static final long getOrElse(android.util.SparseLongArray getOrElse, int key, Functions<Long> defaultValue) {
        Intrinsics.checkParameterIsNotNull(getOrElse, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        int it = getOrElse.indexOfKey(key);
        return it >= 0 ? getOrElse.valueAt(it) : defaultValue.invoke().longValue();
    }

    public static final boolean isEmpty(android.util.SparseLongArray isEmpty) {
        Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(android.util.SparseLongArray isNotEmpty) {
        Intrinsics.checkParameterIsNotNull(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    public static final boolean remove(android.util.SparseLongArray remove, int key, long value) {
        Intrinsics.checkParameterIsNotNull(remove, "$this$remove");
        int index = remove.indexOfKey(key);
        if (index >= 0 && value == remove.valueAt(index)) {
            remove.removeAt(index);
            return true;
        }
        return false;
    }

    public static final void putAll(android.util.SparseLongArray putAll, android.util.SparseLongArray other) {
        Intrinsics.checkParameterIsNotNull(putAll, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int size = other.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            int p1 = other.keyAt(index$iv);
            long p2 = other.valueAt(index$iv);
            putAll.put(p1, p2);
        }
    }

    public static final void forEach(android.util.SparseLongArray forEach, Functions13<? super Integer, ? super Long, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int size = forEach.size();
        for (int index = 0; index < size; index++) {
            action.invoke(Integer.valueOf(forEach.keyAt(index)), Long.valueOf(forEach.valueAt(index)));
        }
    }

    public static final Iterators8 keyIterator(final android.util.SparseLongArray keyIterator) {
        Intrinsics.checkParameterIsNotNull(keyIterator, "$this$keyIterator");
        return new Iterators8() { // from class: androidx.core.util.SparseLongArrayKt.keyIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            public final void setIndex(int i) {
                this.index = i;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < keyIterator.size();
            }

            @Override // kotlin.collections.Iterators8
            public int nextInt() {
                android.util.SparseLongArray sparseLongArray = keyIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray.keyAt(i);
            }
        };
    }

    public static final Iterators9 valueIterator(final android.util.SparseLongArray valueIterator) {
        Intrinsics.checkParameterIsNotNull(valueIterator, "$this$valueIterator");
        return new Iterators9() { // from class: androidx.core.util.SparseLongArrayKt.valueIterator.1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            public final void setIndex(int i) {
                this.index = i;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < valueIterator.size();
            }

            @Override // kotlin.collections.Iterators9
            public long nextLong() {
                android.util.SparseLongArray sparseLongArray = valueIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray.valueAt(i);
            }
        };
    }
}
