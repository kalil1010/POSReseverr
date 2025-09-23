package androidx.core.util;

import android.util.LongSparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.Iterators9;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMarkers;

/* compiled from: LongSparseArray.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000F\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010(\n\u0000\u001a!\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\n\u001a!\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\f\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\r\u001aQ\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000326\u0010\u0010\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\b\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0087\b\u001a.\u0010\u0014\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0087\b¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u001a\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0019\u0010\u001b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\b\u001a\u0018\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0002\u001a&\u0010 \u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a-\u0010!\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010$\u001a\u001e\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\"\"\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006'"}, m17d2 = {"size", "", "T", "Landroid/util/LongSparseArray;", "getSize", "(Landroid/util/LongSparseArray;)I", "contains", "", "key", "", "containsKey", "containsValue", "value", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/LongIterator;", "plus", "other", "putAll", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "valueIterator", "", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.util.LongSparseArrayKt, reason: use source file name */
/* loaded from: classes.dex */
public final class LongSparseArray2 {
    public static final <T> int getSize(LongSparseArray<T> size) {
        Intrinsics.checkParameterIsNotNull(size, "$this$size");
        return size.size();
    }

    public static final <T> boolean contains(LongSparseArray<T> contains, long key) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        return contains.indexOfKey(key) >= 0;
    }

    public static final <T> void set(LongSparseArray<T> set, long key, T t) {
        Intrinsics.checkParameterIsNotNull(set, "$this$set");
        set.put(key, t);
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> plus, LongSparseArray<T> other) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(other, "other");
        LongSparseArray longSparseArray = new LongSparseArray(plus.size() + other.size());
        putAll(longSparseArray, plus);
        putAll(longSparseArray, other);
        return longSparseArray;
    }

    public static final <T> boolean containsKey(LongSparseArray<T> containsKey, long key) {
        Intrinsics.checkParameterIsNotNull(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(key) >= 0;
    }

    public static final <T> boolean containsValue(LongSparseArray<T> containsValue, T t) {
        Intrinsics.checkParameterIsNotNull(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(t) >= 0;
    }

    public static final <T> T getOrDefault(LongSparseArray<T> getOrDefault, long key, T t) {
        Intrinsics.checkParameterIsNotNull(getOrDefault, "$this$getOrDefault");
        T t2 = getOrDefault.get(key);
        return t2 != null ? t2 : t;
    }

    public static final <T> T getOrElse(LongSparseArray<T> getOrElse, long key, Functions<? extends T> defaultValue) {
        Intrinsics.checkParameterIsNotNull(getOrElse, "$this$getOrElse");
        Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
        T t = getOrElse.get(key);
        return t != null ? t : defaultValue.invoke();
    }

    public static final <T> boolean isEmpty(LongSparseArray<T> isEmpty) {
        Intrinsics.checkParameterIsNotNull(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> isNotEmpty) {
        Intrinsics.checkParameterIsNotNull(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    public static final <T> boolean remove(LongSparseArray<T> remove, long key, T t) {
        Intrinsics.checkParameterIsNotNull(remove, "$this$remove");
        int index = remove.indexOfKey(key);
        if (index >= 0 && Intrinsics.areEqual(t, remove.valueAt(index))) {
            remove.removeAt(index);
            return true;
        }
        return false;
    }

    public static final <T> void putAll(LongSparseArray<T> putAll, LongSparseArray<T> other) {
        Intrinsics.checkParameterIsNotNull(putAll, "$this$putAll");
        Intrinsics.checkParameterIsNotNull(other, "other");
        int size = other.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            long p1 = other.keyAt(index$iv);
            putAll.put(p1, other.valueAt(index$iv));
        }
    }

    public static final <T> void forEach(LongSparseArray<T> forEach, Functions13<? super Long, ? super T, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(action, "action");
        int size = forEach.size();
        for (int index = 0; index < size; index++) {
            action.invoke(Long.valueOf(forEach.keyAt(index)), forEach.valueAt(index));
        }
    }

    public static final <T> Iterators9 keyIterator(final LongSparseArray<T> keyIterator) {
        Intrinsics.checkParameterIsNotNull(keyIterator, "$this$keyIterator");
        return new Iterators9() { // from class: androidx.core.util.LongSparseArrayKt.keyIterator.1
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

            @Override // kotlin.collections.Iterators9
            public long nextLong() {
                LongSparseArray longSparseArray = keyIterator;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray.keyAt(i);
            }
        };
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LongSparseArray.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m17d2 = {"androidx/core/util/LongSparseArrayKt$valueIterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "kotlin.jvm.PlatformType", "()Ljava/lang/Object;", "core-ktx_release"}, m18k = 1, m19mv = {1, 1, 16})
    /* renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1 */
    public static final class C01671<T> implements Iterator<T>, KMarkers {
        final /* synthetic */ LongSparseArray $this_valueIterator;
        private int index;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        C01671(LongSparseArray<T> longSparseArray) {
            this.$this_valueIterator = longSparseArray;
        }

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.$this_valueIterator.size();
        }

        @Override // java.util.Iterator
        public T next() {
            LongSparseArray longSparseArray = this.$this_valueIterator;
            int i = this.index;
            this.index = i + 1;
            return (T) longSparseArray.valueAt(i);
        }
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> valueIterator) {
        Intrinsics.checkParameterIsNotNull(valueIterator, "$this$valueIterator");
        return new C01671(valueIterator);
    }
}
