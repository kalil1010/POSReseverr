package androidx.core.content;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedPreferences.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0087\b¨\u0006\t"}, m17d2 = {"edit", "", "Landroid/content/SharedPreferences;", "commit", "", "action", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "Lkotlin/ExtensionFunctionType;", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.content.SharedPreferencesKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SharedPreferences {
    public static /* synthetic */ void edit$default(android.content.SharedPreferences edit, boolean commit, Functions2 action, int i, Object obj) {
        if ((i & 1) != 0) {
            commit = false;
        }
        Intrinsics.checkParameterIsNotNull(edit, "$this$edit");
        Intrinsics.checkParameterIsNotNull(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
        action.invoke(editor);
        if (commit) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static final void edit(android.content.SharedPreferences edit, boolean commit, Functions2<? super SharedPreferences.Editor, Unit> action) {
        Intrinsics.checkParameterIsNotNull(edit, "$this$edit");
        Intrinsics.checkParameterIsNotNull(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor, "editor");
        action.invoke(editor);
        if (commit) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
