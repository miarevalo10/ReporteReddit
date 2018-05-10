package com.raizlabs.android.dbflow.rx2.kotlinextensions;

import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032*\u0010\u0004\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u0002 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00070\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "", "modelList", "", "kotlin.jvm.PlatformType", "", "accept"}, k = 3, mv = {1, 1, 7})
/* compiled from: QueryExtensions.kt */
public final class QueryExtensionsKt$list$1<T> implements Consumer<List<T>> {
    final /* synthetic */ Function1 $func;

    public QueryExtensionsKt$list$1(Function1 function1) {
        this.$func = function1;
    }

    public final void accept(List<T> list) {
        Function1 function1 = this.$func;
        Intrinsics.a(list, "modelList");
        function1.a(list);
    }
}
