package androidx.core.database.sqlite;

import kotlin.Metadata;
import kotlin.jvm.functions.Functions2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SQLiteDatabase.kt */
@Metadata(m15bv = {1, 0, 3}, m16d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\u0086\b¢\u0006\u0002\u0010\b¨\u0006\t"}, m17d2 = {"transaction", "T", "Landroid/database/sqlite/SQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, m18k = 2, m19mv = {1, 1, 16})
/* renamed from: androidx.core.database.sqlite.SQLiteDatabaseKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SQLiteDatabase {
    public static /* synthetic */ Object transaction$default(android.database.sqlite.SQLiteDatabase transaction, boolean exclusive, Functions2 body, int i, Object obj) {
        if ((i & 1) != 0) {
            exclusive = true;
        }
        Intrinsics.checkParameterIsNotNull(transaction, "$this$transaction");
        Intrinsics.checkParameterIsNotNull(body, "body");
        if (exclusive) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            Object result = body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return result;
        } finally {
            InlineMarker.finallyStart(1);
            transaction.endTransaction();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T transaction(android.database.sqlite.SQLiteDatabase transaction, boolean exclusive, Functions2<? super android.database.sqlite.SQLiteDatabase, ? extends T> body) {
        Intrinsics.checkParameterIsNotNull(transaction, "$this$transaction");
        Intrinsics.checkParameterIsNotNull(body, "body");
        if (exclusive) {
            transaction.beginTransaction();
        } else {
            transaction.beginTransactionNonExclusive();
        }
        try {
            T tInvoke = body.invoke(transaction);
            transaction.setTransactionSuccessful();
            return tInvoke;
        } finally {
            InlineMarker.finallyStart(1);
            transaction.endTransaction();
            InlineMarker.finallyEnd(1);
        }
    }
}
