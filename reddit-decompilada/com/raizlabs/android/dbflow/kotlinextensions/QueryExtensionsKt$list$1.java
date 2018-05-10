package com.raizlabs.android.dbflow.kotlinextensions;

import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction.QueryResultListCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032&\u0010\u0004\u001a\"\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00030\u0003 \u0006*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0005¨\u0006\u00010\u0005¨\u0006\u00012(\u0010\u0007\u001a$\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u0002 \u0006*\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u00020\t0\bH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "T", "", "queryTransaction", "Lcom/raizlabs/android/dbflow/structure/database/transaction/QueryTransaction;", "kotlin.jvm.PlatformType", "mutableList", "", "", "onListQueryResult"}, k = 3, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt$list$1<TResult> implements QueryResultListCallback<T> {
    final /* synthetic */ Function2 $callback;

    public QueryExtensionsKt$list$1(Function2 function2) {
        this.$callback = function2;
    }

    public final void onListQueryResult(QueryTransaction<Object> queryTransaction, List<T> list) {
        Intrinsics.b(list, "mutableList");
        Function2 function2 = this.$callback;
        Intrinsics.a(queryTransaction, "queryTransaction");
        function2.a(queryTransaction, list);
    }
}
