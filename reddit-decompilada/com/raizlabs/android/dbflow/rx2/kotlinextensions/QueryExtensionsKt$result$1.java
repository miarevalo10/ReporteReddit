package com.raizlabs.android.dbflow.rx2.kotlinextensions;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "", "result", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt$result$1<T> implements Consumer<T> {
    final /* synthetic */ Function1 $func;

    public QueryExtensionsKt$result$1(Function1 function1) {
        this.$func = function1;
    }

    public final void accept(T t) {
        this.$func.a(t);
    }
}
