package com.raizlabs.android.dbflow.rx2.kotlinextensions;

import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032*\u0010\u0004\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u0002 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "", "queriable", "Lcom/raizlabs/android/dbflow/sql/queriable/ModelQueriable;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt$tableChanges$1<T> implements Consumer<ModelQueriable<T>> {
    final /* synthetic */ Function1 $func;

    public QueryExtensionsKt$tableChanges$1(Function1 function1) {
        this.$func = function1;
    }

    public final void accept(ModelQueriable<T> modelQueriable) {
        Function1 function1 = this.$func;
        Intrinsics.a(modelQueriable, "queriable");
        function1.a(modelQueriable);
    }
}
