package com.reddit.datalibrary.frontpage.data.feature.search;

import com.reddit.frontpage.domain.model.SearchType;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: SharedPrefsSearchDataSource.kt */
final class SharedPrefsSearchDataSource$deleteQuery$2<T, R> implements Function<T, R> {
    final /* synthetic */ SharedPrefsSearchDataSource f16142a;
    final /* synthetic */ SearchType f16143b;

    SharedPrefsSearchDataSource$deleteQuery$2(SharedPrefsSearchDataSource sharedPrefsSearchDataSource, SearchType searchType) {
        this.f16142a = sharedPrefsSearchDataSource;
        this.f16143b = searchType;
    }

    public final /* synthetic */ Object apply(Object obj) {
        List list = (List) obj;
        Intrinsics.b(list, "it");
        this.f16142a.f16148b.edit().putStringSet(SharedPrefsSearchDataSource.m16135b(this.f16143b), SharedPrefsSearchDataSource.m16134a(list)).apply();
        return Unit.a;
    }
}
