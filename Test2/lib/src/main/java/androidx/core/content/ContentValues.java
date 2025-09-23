package androidx.core.content;

import kotlin.Metadata;
import kotlin.Tuples;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* compiled from: ContentValues.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m17d2 = {"contentValuesOf", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.content.ContentValuesKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ContentValues {
    public static final android.content.ContentValues contentValuesOf(Tuples<String, ? extends Object>... pairs) {
        Intrinsics.checkParameterIsNotNull(pairs, "pairs");
        android.content.ContentValues $this$apply = new android.content.ContentValues(pairs.length);
        for (Tuples<String, ? extends Object> tuples : pairs) {
            String key = tuples.component1();
            Object value = tuples.component2();
            if (value == null) {
                $this$apply.putNull(key);
            } else if (value instanceof String) {
                $this$apply.put(key, (String) value);
            } else if (value instanceof Integer) {
                $this$apply.put(key, (Integer) value);
            } else if (value instanceof Long) {
                $this$apply.put(key, (Long) value);
            } else if (value instanceof Boolean) {
                $this$apply.put(key, (Boolean) value);
            } else if (value instanceof Float) {
                $this$apply.put(key, (Float) value);
            } else if (value instanceof Double) {
                $this$apply.put(key, (Double) value);
            } else if (value instanceof byte[]) {
                $this$apply.put(key, (byte[]) value);
            } else if (value instanceof Byte) {
                $this$apply.put(key, (Byte) value);
            } else {
                if (!(value instanceof Short)) {
                    String valueType = value.getClass().getCanonicalName();
                    throw new IllegalArgumentException("Illegal value type " + valueType + " for key \"" + key + Typography.quote);
                }
                $this$apply.put(key, (Short) value);
            }
        }
        return $this$apply;
    }
}
