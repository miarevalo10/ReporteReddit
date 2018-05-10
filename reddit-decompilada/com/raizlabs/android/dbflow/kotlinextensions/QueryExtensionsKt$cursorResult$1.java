package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.sql.language.CursorResult;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction.QueryResultCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u00020\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "T", "", "queryTransaction", "Lcom/raizlabs/android/dbflow/structure/database/transaction/QueryTransaction;", "kotlin.jvm.PlatformType", "cursorResult", "Lcom/raizlabs/android/dbflow/sql/language/CursorResult;", "onQueryResult"}, k = 3, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt$cursorResult$1<TResult> implements QueryResultCallback<T> {
    final /* synthetic */ Function2 $callback;

    public QueryExtensionsKt$cursorResult$1(Function2 function2) {
        this.$callback = function2;
    }

    public final void onQueryResult(QueryTransaction<T> queryTransaction, CursorResult<T> cursorResult) {
        Intrinsics.b(queryTransaction, "queryTransaction");
        Intrinsics.b(cursorResult, "cursorResult");
        this.$callback.a(queryTransaction, cursorResult);
    }
}
