package com.reddit.datalibrary.frontpage.data.feature.search;

import com.reddit.frontpage.domain.model.SearchType;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: SharedPrefsSearchDataSource.kt */
final class SharedPrefsSearchDataSource$getQueries$1<V> implements Callable<T> {
    final /* synthetic */ SharedPrefsSearchDataSource f10753a;
    final /* synthetic */ SearchType f10754b;

    SharedPrefsSearchDataSource$getQueries$1(SharedPrefsSearchDataSource sharedPrefsSearchDataSource, SearchType searchType) {
        this.f10753a = sharedPrefsSearchDataSource;
        this.f10754b = searchType;
    }

    public final /* synthetic */ Object call() {
        Set stringSet = this.f10753a.f16148b.getStringSet(SharedPrefsSearchDataSource.m16135b(this.f10754b), SetsKt.a());
        Intrinsics.a(stringSet, "preferences.getStringSet(createKey(type), setOf())");
        Iterable<String> n = CollectionsKt.n(CollectionsKt.a(stringSet, new C0933x6ebb1722()));
        Collection arrayList = new ArrayList(CollectionsKt.b(n));
        for (String a : n) {
            arrayList.add(StringsKt.d(a, EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR));
        }
        return (List) arrayList;
    }
}
