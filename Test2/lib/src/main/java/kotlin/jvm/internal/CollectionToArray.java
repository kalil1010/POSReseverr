package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.functions.Functions13;
import kotlin.jvm.functions.Functions2;

/* compiled from: CollectionToArray.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m17d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, m18k = 2, m19mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class CollectionToArray {
    private static final Object[] EMPTY = new Object[0];
    private static final int MAX_SIZE = 2147483645;

    public static final Object[] toArray(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        int size$iv = collection.size();
        if (size$iv == 0) {
            return EMPTY;
        }
        Iterator iter$iv = collection.iterator();
        if (!iter$iv.hasNext()) {
            return EMPTY;
        }
        Object[] result$iv = new Object[size$iv];
        int i$iv = 0;
        while (true) {
            int i$iv2 = i$iv + 1;
            result$iv[i$iv] = iter$iv.next();
            if (i$iv2 >= result$iv.length) {
                if (!iter$iv.hasNext()) {
                    return result$iv;
                }
                int newSize$iv = ((i$iv2 * 3) + 1) >>> 1;
                if (newSize$iv <= i$iv2) {
                    if (i$iv2 >= MAX_SIZE) {
                        throw new OutOfMemoryError();
                    }
                    newSize$iv = MAX_SIZE;
                }
                Object[] objArrCopyOf = Arrays.copyOf(result$iv, newSize$iv);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "Arrays.copyOf(result, newSize)");
                result$iv = objArrCopyOf;
            } else if (!iter$iv.hasNext()) {
                Object[] result = result$iv;
                Object[] objArrCopyOf2 = Arrays.copyOf(result, i$iv2);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "Arrays.copyOf(result, size)");
                return objArrCopyOf2;
            }
            i$iv = i$iv2;
        }
    }

    public static final Object[] toArray(Collection<?> collection, Object[] a) throws NegativeArraySizeException {
        Object[] objArr;
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (a == null) {
            throw new NullPointerException();
        }
        int size$iv = collection.size();
        if (size$iv != 0) {
            Iterator iter$iv = collection.iterator();
            if (iter$iv.hasNext()) {
                if (size$iv <= a.length) {
                    objArr = a;
                } else {
                    Object objNewInstance = Array.newInstance(a.getClass().getComponentType(), size$iv);
                    if (objNewInstance == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    }
                    objArr = (Object[]) objNewInstance;
                }
                Object[] result$iv = objArr;
                int i$iv = 0;
                while (true) {
                    int i$iv2 = i$iv + 1;
                    result$iv[i$iv] = iter$iv.next();
                    if (i$iv2 >= result$iv.length) {
                        if (!iter$iv.hasNext()) {
                            return result$iv;
                        }
                        int newSize$iv = ((i$iv2 * 3) + 1) >>> 1;
                        if (newSize$iv <= i$iv2) {
                            if (i$iv2 >= MAX_SIZE) {
                                throw new OutOfMemoryError();
                            }
                            newSize$iv = MAX_SIZE;
                        }
                        Object[] objArrCopyOf = Arrays.copyOf(result$iv, newSize$iv);
                        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "Arrays.copyOf(result, newSize)");
                        result$iv = objArrCopyOf;
                    } else if (!iter$iv.hasNext()) {
                        Object[] result = result$iv;
                        if (result != a) {
                            Object[] result$iv2 = Arrays.copyOf(result, i$iv2);
                            Intrinsics.checkNotNullExpressionValue(result$iv2, "Arrays.copyOf(result, size)");
                            return result$iv2;
                        }
                        a[i$iv2] = null;
                    }
                    i$iv = i$iv2;
                }
            } else if (a.length > 0) {
                a[0] = null;
            }
        } else if (a.length > 0) {
            a[0] = null;
        }
        return a;
    }

    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private static final Object[] toArrayImpl(Collection<?> collection, Functions<Object[]> functions, Functions2<? super Integer, Object[]> functions2, Functions13<? super Object[], ? super Integer, Object[]> functions13) {
        int size = collection.size();
        if (size == 0) {
            return functions.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return functions.invoke();
        }
        int i = 0;
        ?? Invoke = functions2.invoke(Integer.valueOf(size));
        while (true) {
            int i2 = i + 1;
            Invoke[i] = it.next();
            if (i2 >= Invoke.length) {
                if (!it.hasNext()) {
                    return Invoke;
                }
                int i3 = ((i2 * 3) + 1) >>> 1;
                if (i3 <= i2) {
                    if (i2 >= MAX_SIZE) {
                        throw new OutOfMemoryError();
                    }
                    i3 = MAX_SIZE;
                }
                Object[] objArrCopyOf = Arrays.copyOf((Object[]) Invoke, i3);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "Arrays.copyOf(result, newSize)");
                Invoke = objArrCopyOf;
            } else if (!it.hasNext()) {
                return functions13.invoke(Invoke, Integer.valueOf(i2));
            }
            i = i2;
            Invoke = Invoke;
        }
    }
}
