package com.reddit.datalibrary.frontpage.data.feature.search;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "it", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: SharedPrefsSearchDataSource.kt */
final class SharedPrefsSearchDataSource$deleteQuery$1<T, R> implements Function<T, R> {
    final /* synthetic */ String f16141a;

    SharedPrefsSearchDataSource$deleteQuery$1(String str) {
        this.f16141a = str;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "it");
        obj = CollectionsKt.c(list);
        obj.remove(this.f16141a);
        return obj;
    }
}
