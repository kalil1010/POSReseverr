package kotlin.collections;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.Tuples3;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Functions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Arrays.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, m17d2 = {"contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, m18k = 5, m19mv = {1, 4, 0}, m21xi = 1, m22xs = "kotlin/collections/ArraysKt")
/* renamed from: kotlin.collections.ArraysKt__ArraysKt, reason: use source file name */
/* loaded from: classes.dex */
class Arrays extends ArraysJVM {
    public static final <T> List<T> flatten(T[][] flatten) {
        Intrinsics.checkNotNullParameter(flatten, "$this$flatten");
        T[][] $this$sumBy$iv = flatten;
        int sum$iv = 0;
        for (Object[] element$iv : $this$sumBy$iv) {
            Object[] it = element$iv;
            sum$iv += it.length;
        }
        ArrayList result = new ArrayList(sum$iv);
        for (T[] tArr : flatten) {
            CollectionsKt.addAll(result, tArr);
        }
        return result;
    }

    public static final <T, R> Tuples<List<T>, List<R>> unzip(Tuples<? extends T, ? extends R>[] unzip) {
        Intrinsics.checkNotNullParameter(unzip, "$this$unzip");
        ArrayList listT = new ArrayList(unzip.length);
        ArrayList listR = new ArrayList(unzip.length);
        for (Tuples<? extends T, ? extends R> tuples : unzip) {
            listT.add(tuples.getFirst());
            listR.add(tuples.getSecond());
        }
        return Tuples3.m24to(listT, listR);
    }

    private static final boolean isNullOrEmpty(Object[] $this$isNullOrEmpty) {
        if ($this$isNullOrEmpty != null) {
            if (!($this$isNullOrEmpty.length == 0)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: <C:[Ljava/lang/Object;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Object[] $this$ifEmpty, Functions defaultValue) {
        return $this$ifEmpty.length == 0 ? defaultValue.invoke() : $this$ifEmpty;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean contentDeepEquals(T[] tArr, T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == 0 || tArr2 == 0 || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            Object[] objArr = tArr[i];
            Object[] objArr2 = tArr2[i];
            if (objArr != objArr2) {
                if (objArr == 0 || objArr2 == 0) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!ArraysKt.contentDeepEquals(objArr, objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!java.util.Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!java.util.Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!java.util.Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!java.util.Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!java.util.Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!java.util.Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!java.util.Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!java.util.Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof UByteArray) && (objArr2 instanceof UByteArray)) {
                    if (!UArraysKt.m586contentEqualskV0jMPg(((UByteArray) objArr).getStorage(), ((UByteArray) objArr2).getStorage())) {
                        return false;
                    }
                } else if ((objArr instanceof UShortArray) && (objArr2 instanceof UShortArray)) {
                    if (!UArraysKt.m583contentEqualsFGO6Aew(((UShortArray) objArr).getStorage(), ((UShortArray) objArr2).getStorage())) {
                        return false;
                    }
                } else if ((objArr instanceof UIntArray) && (objArr2 instanceof UIntArray)) {
                    if (!UArraysKt.m584contentEqualsKJPZfPQ(((UIntArray) objArr).getStorage(), ((UIntArray) objArr2).getStorage())) {
                        return false;
                    }
                } else if ((objArr instanceof ULongArray) && (objArr2 instanceof ULongArray)) {
                    if (!UArraysKt.m588contentEqualslec5QzE(((ULongArray) objArr).getStorage(), ((ULongArray) objArr2).getStorage())) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final <T> String contentDeepToString(T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        int length = (RangesKt.coerceAtMost(tArr.length, 429496729) * 5) + 2;
        StringBuilder $this$buildString = new StringBuilder(length);
        contentDeepToStringInternal$ArraysKt__ArraysKt(tArr, $this$buildString, new ArrayList());
        String string = $this$buildString.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            Object[] objArr = tArr[i];
            if (objArr == 0) {
                sb.append("null");
            } else if (objArr instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt(objArr, sb, list);
            } else if (objArr instanceof byte[]) {
                String string = java.util.Arrays.toString((byte[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string, "java.util.Arrays.toString(this)");
                sb.append(string);
            } else if (objArr instanceof short[]) {
                String string2 = java.util.Arrays.toString((short[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string2, "java.util.Arrays.toString(this)");
                sb.append(string2);
            } else if (objArr instanceof int[]) {
                String string3 = java.util.Arrays.toString((int[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string3, "java.util.Arrays.toString(this)");
                sb.append(string3);
            } else if (objArr instanceof long[]) {
                String string4 = java.util.Arrays.toString((long[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string4, "java.util.Arrays.toString(this)");
                sb.append(string4);
            } else if (objArr instanceof float[]) {
                String string5 = java.util.Arrays.toString((float[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string5, "java.util.Arrays.toString(this)");
                sb.append(string5);
            } else if (objArr instanceof double[]) {
                String string6 = java.util.Arrays.toString((double[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string6, "java.util.Arrays.toString(this)");
                sb.append(string6);
            } else if (objArr instanceof char[]) {
                String string7 = java.util.Arrays.toString((char[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string7, "java.util.Arrays.toString(this)");
                sb.append(string7);
            } else if (objArr instanceof boolean[]) {
                String string8 = java.util.Arrays.toString((boolean[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string8, "java.util.Arrays.toString(this)");
                sb.append(string8);
            } else if (objArr instanceof UByteArray) {
                UByteArray uByteArray = (UByteArray) objArr;
                sb.append(UArraysKt.m600contentToString2csIQuQ(uByteArray != null ? uByteArray.getStorage() : null));
            } else if (objArr instanceof UShortArray) {
                UShortArray uShortArray = (UShortArray) objArr;
                sb.append(UArraysKt.m604contentToStringd6D3K8(uShortArray != null ? uShortArray.getStorage() : null));
            } else if (objArr instanceof UIntArray) {
                UIntArray uIntArray = (UIntArray) objArr;
                sb.append(UArraysKt.m603contentToStringXUkPCBk(uIntArray != null ? uIntArray.getStorage() : null));
            } else if (objArr instanceof ULongArray) {
                ULongArray uLongArray = (ULongArray) objArr;
                sb.append(UArraysKt.m606contentToStringuLth9ew(uLongArray != null ? uLongArray.getStorage() : null));
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(']');
        list.remove(CollectionsKt.getLastIndex(list));
    }
}
