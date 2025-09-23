package androidx.core.util;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.functions.Functions18;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LruCache.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aø\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b¨\u0006\u0016"}, m17d2 = {"lruCache", "Landroid/util/LruCache;", "K", "V", "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.util.LruCacheKt, reason: use source file name */
/* loaded from: classes.dex */
public final class LruCache2 {
    public static /* synthetic */ LruCache lruCache$default(int maxSize, Functions13 sizeOf, Functions2 create, Functions18 onEntryRemoved, int i, Object obj) {
        if ((i & 2) != 0) {
            Functions13 sizeOf2 = new Functions13<K, V, Integer>() { // from class: androidx.core.util.LruCacheKt.lruCache.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Functions13
                public /* bridge */ /* synthetic */ Integer invoke(Object obj2, Object obj3) {
                    return Integer.valueOf(invoke2((C01681<K, V>) obj2, obj3));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final int invoke2(K k, V v) {
                    Intrinsics.checkParameterIsNotNull(k, "<anonymous parameter 0>");
                    Intrinsics.checkParameterIsNotNull(v, "<anonymous parameter 1>");
                    return 1;
                }
            };
            sizeOf = sizeOf2;
        }
        if ((i & 4) != 0) {
            Functions2 create2 = new Functions2<K, V>() { // from class: androidx.core.util.LruCacheKt.lruCache.2
                @Override // kotlin.jvm.functions.Functions2
                public final V invoke(K it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return null;
                }
            };
            create = create2;
        }
        if ((i & 8) != 0) {
            Functions18 onEntryRemoved2 = new Functions18<Boolean, K, V, V, Unit>() { // from class: androidx.core.util.LruCacheKt.lruCache.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Functions18
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    invoke(bool.booleanValue(), (boolean) obj2, obj3, obj4);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean $noName_0, K k, V v, V v2) {
                    Intrinsics.checkParameterIsNotNull(k, "<anonymous parameter 1>");
                    Intrinsics.checkParameterIsNotNull(v, "<anonymous parameter 2>");
                }
            };
            onEntryRemoved = onEntryRemoved2;
        }
        Intrinsics.checkParameterIsNotNull(sizeOf, "sizeOf");
        Intrinsics.checkParameterIsNotNull(create, "create");
        Intrinsics.checkParameterIsNotNull(onEntryRemoved, "onEntryRemoved");
        return new C01714(sizeOf, create, onEntryRemoved, maxSize, maxSize);
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: LruCache.kt */
    @Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m17d2 = {"androidx/core/util/LruCacheKt$lruCache$4", "Landroid/util/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "core-ktx_release"}, m18k = 1, m19mv = {1, 1, 16})
    /* renamed from: androidx.core.util.LruCacheKt$lruCache$4 */
    public static final class C01714<K, V> extends LruCache<K, V> {
        final /* synthetic */ Functions2 $create;
        final /* synthetic */ int $maxSize;
        final /* synthetic */ Functions18 $onEntryRemoved;
        final /* synthetic */ Functions13 $sizeOf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01714(Functions13 $captured_local_variable$0, Functions2 $captured_local_variable$1, Functions18 $captured_local_variable$2, int $captured_local_variable$3, int $super_call_param$4) {
            super($super_call_param$4);
            this.$sizeOf = $captured_local_variable$0;
            this.$create = $captured_local_variable$1;
            this.$onEntryRemoved = $captured_local_variable$2;
            this.$maxSize = $captured_local_variable$3;
        }

        @Override // android.util.LruCache
        protected int sizeOf(K key, V value) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            Intrinsics.checkParameterIsNotNull(value, "value");
            return ((Number) this.$sizeOf.invoke(key, value)).intValue();
        }

        @Override // android.util.LruCache
        protected V create(K key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return (V) this.$create.invoke(key);
        }

        @Override // android.util.LruCache
        protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            Intrinsics.checkParameterIsNotNull(oldValue, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(evicted), key, oldValue, newValue);
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int maxSize, Functions13<? super K, ? super V, Integer> sizeOf, Functions2<? super K, ? extends V> create, Functions18<? super Boolean, ? super K, ? super V, ? super V, Unit> onEntryRemoved) {
        Intrinsics.checkParameterIsNotNull(sizeOf, "sizeOf");
        Intrinsics.checkParameterIsNotNull(create, "create");
        Intrinsics.checkParameterIsNotNull(onEntryRemoved, "onEntryRemoved");
        return new C01714(sizeOf, create, onEntryRemoved, maxSize, maxSize);
    }
}
