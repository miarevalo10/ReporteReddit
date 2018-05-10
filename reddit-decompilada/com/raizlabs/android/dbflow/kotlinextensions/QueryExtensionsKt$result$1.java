package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction.QueryResultSingleCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032&\u0010\u0004\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00030\u0003 \u0006*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0005¨\u0006\u00010\u0005¨\u0006\u00012\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0002H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "T", "", "queryTransaction", "Lcom/raizlabs/android/dbflow/structure/database/transaction/QueryTransaction;", "kotlin.jvm.PlatformType", "model", "onSingleQueryResult", "(Lcom/raizlabs/android/dbflow/structure/database/transaction/QueryTransaction;Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt$result$1<TResult> implements QueryResultSingleCallback<T> {
    final /* synthetic */ Function2 $callback;

    public QueryExtensionsKt$result$1(Function2 function2) {
        this.$callback = function2;
    }

    public final void onSingleQueryResult(QueryTransaction<Object> queryTransaction, T t) {
        Function2 function2 = this.$callback;
        Intrinsics.a(queryTransaction, "queryTransaction");
        function2.a(queryTransaction, t);
    }
}
