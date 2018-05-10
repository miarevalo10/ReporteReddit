package com.reddit.datalibrary.frontpage.data.feature.search;

import android.content.SharedPreferences;
import com.reddit.frontpage.domain.model.SearchType;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\t0\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/search/SharedPrefsSearchDataSource;", "Lcom/reddit/datalibrary/frontpage/data/feature/search/LocalSearchDataSource;", "preferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "buildOrderedQuerySet", "", "", "queries", "", "buildOrderedQueryString", "index", "", "query", "createKey", "type", "Lcom/reddit/frontpage/domain/model/SearchType;", "deleteQuery", "Lio/reactivex/Completable;", "getQueries", "Lio/reactivex/Single;", "parseQueryFromOrderedQueryString", "orderedQuery", "saveQuery", "Companion", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SharedPrefsSearchDataSource.kt */
public final class SharedPrefsSearchDataSource implements LocalSearchDataSource {
    public static final Companion f16147a = new Companion();
    private final SharedPreferences f16148b;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/search/SharedPrefsSearchDataSource$Companion;", "", "()V", "KEY_PREFIX", "", "ORDER_DELIMETER", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: SharedPrefsSearchDataSource.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public SharedPrefsSearchDataSource(SharedPreferences sharedPreferences) {
        Intrinsics.b(sharedPreferences, "preferences");
        this.f16148b = sharedPreferences;
    }

    public final Completable mo2978a(String str, SearchType searchType) {
        Intrinsics.b(str, "query");
        Intrinsics.b(searchType, "type");
        str = mo2980b(str, searchType).andThen(mo2979a(searchType).map(new SharedPrefsSearchDataSource$saveQuery$save$1(str)).map(new SharedPrefsSearchDataSource$saveQuery$save$2(this, searchType))).toCompletable();
        Intrinsics.a(str, "delete.andThen(save).toCompletable()");
        return str;
    }

    public final Single<List<String>> mo2979a(SearchType searchType) {
        Intrinsics.b(searchType, "type");
        searchType = Single.fromCallable(new SharedPrefsSearchDataSource$getQueries$1(this, searchType));
        Intrinsics.a(searchType, "Single.fromCallable {\n  …     it\n          }\n    }");
        return searchType;
    }

    public final Completable mo2980b(String str, SearchType searchType) {
        Intrinsics.b(str, "query");
        Intrinsics.b(searchType, "type");
        str = mo2979a(searchType).map(new SharedPrefsSearchDataSource$deleteQuery$1(str)).map(new SharedPrefsSearchDataSource$deleteQuery$2(this, searchType)).toCompletable();
        Intrinsics.a(str, "getQueries(type)\n       …\n        .toCompletable()");
        return str;
    }

    public static final /* synthetic */ String m16135b(SearchType searchType) {
        StringBuilder stringBuilder = new StringBuilder("LOCAL_SEARCH_DATA_SOURCE");
        stringBuilder.append(searchType.name());
        return stringBuilder.toString();
    }

    public static final /* synthetic */ Set m16134a(List list) {
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.b(iterable));
        int i = 0;
        for (String str : iterable) {
            int i2 = i + 1;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append('_');
            stringBuilder.append(str);
            arrayList.add(stringBuilder.toString());
            i = i2;
        }
        return CollectionsKt.p((List) arrayList);
    }
}
