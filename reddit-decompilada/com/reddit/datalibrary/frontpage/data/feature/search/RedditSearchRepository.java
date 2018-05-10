package com.reddit.datalibrary.frontpage.data.feature.search;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.common.rx.Thread;
import com.reddit.frontpage.domain.model.SearchResult;
import com.reddit.frontpage.domain.model.SearchType;
import com.reddit.frontpage.domain.repository.SearchRepository;
import com.reddit.frontpage.util.kotlin.CompletablesKt;
import com.reddit.frontpage.util.kotlin.ObservablesKt;
import com.reddit.frontpage.util.kotlin.SinglesKt;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00110\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J.\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00102\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/search/RedditSearchRepository;", "Lcom/reddit/frontpage/domain/repository/SearchRepository;", "remote", "Lcom/reddit/datalibrary/frontpage/data/feature/search/RemoteSearchDataSource;", "local", "Lcom/reddit/datalibrary/frontpage/data/feature/search/LocalSearchDataSource;", "backgroundThread", "Lcom/reddit/common/rx/BackgroundThread;", "(Lcom/reddit/datalibrary/frontpage/data/feature/search/RemoteSearchDataSource;Lcom/reddit/datalibrary/frontpage/data/feature/search/LocalSearchDataSource;Lcom/reddit/common/rx/BackgroundThread;)V", "deleteQuery", "Lio/reactivex/Completable;", "query", "", "type", "Lcom/reddit/frontpage/domain/model/SearchType;", "getQueries", "Lio/reactivex/Single;", "", "getSearchSuggestions", "Lio/reactivex/Observable;", "Lcom/reddit/frontpage/domain/model/SearchResult;", "allowNsfw", "", "includeUsers", "getTypesValues", "types", "", "saveQuery", "search", "after", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditSearchRepository.kt */
public final class RedditSearchRepository implements SearchRepository {
    private final RemoteSearchDataSource f16138a;
    private final LocalSearchDataSource f16139b;
    private final BackgroundThread f16140c;

    public RedditSearchRepository(RemoteSearchDataSource remoteSearchDataSource, LocalSearchDataSource localSearchDataSource, BackgroundThread backgroundThread) {
        Intrinsics.b(remoteSearchDataSource, "remote");
        Intrinsics.b(localSearchDataSource, "local");
        Intrinsics.b(backgroundThread, "backgroundThread");
        this.f16138a = remoteSearchDataSource;
        this.f16139b = localSearchDataSource;
        this.f16140c = backgroundThread;
    }

    public final Single<SearchResult> m16130a(String str, String str2, Set<? extends SearchType> set) {
        Intrinsics.b(str, "query");
        Intrinsics.b(set, "types");
        RemoteSearchDataSource remoteSearchDataSource = this.f16138a;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (SearchType typeName : set) {
            int i2 = i + 1;
            stringBuilder.append(typeName.getTypeName());
            if (i != set.size() - 1) {
                stringBuilder.append(",");
            }
            i = i2;
        }
        set = stringBuilder.toString();
        Intrinsics.a(set, "StringBuilder().apply(builderAction).toString()");
        str = remoteSearchDataSource.search(str, set, str2).map(new RedditSearchRepository$search$1(str, str2));
        Intrinsics.a(str, "remote.search(query, get…t.items, after = after) }");
        return SinglesKt.a(str, (Thread) this.f16140c);
    }

    public final Observable<SearchResult> m16128a(Observable<String> observable) {
        Intrinsics.b(observable, "query");
        observable = observable.switchMap(new RedditSearchRepository$getSearchSuggestions$1(this));
        Intrinsics.a(observable, "query.switchMap { curren…    .toObservable()\n    }");
        return ObservablesKt.a(observable, this.f16140c);
    }

    public final Completable m16127a(String str, SearchType searchType) {
        Intrinsics.b(str, "query");
        Intrinsics.b(searchType, "type");
        return CompletablesKt.a(this.f16139b.mo2978a(str, searchType), (Thread) this.f16140c);
    }

    public final Single<List<String>> m16129a(SearchType searchType) {
        Intrinsics.b(searchType, "type");
        return SinglesKt.a(this.f16139b.mo2979a(searchType), this.f16140c);
    }

    public final Completable m16131b(String str, SearchType searchType) {
        Intrinsics.b(str, "query");
        Intrinsics.b(searchType, "type");
        return CompletablesKt.a(this.f16139b.mo2980b(str, searchType), (Thread) this.f16140c);
    }
}
