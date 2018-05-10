package com.reddit.datalibrary.frontpage.data.feature.search;

import com.reddit.frontpage.domain.model.SearchType;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/reddit/datalibrary/frontpage/data/feature/search/LocalSearchDataSource;", "", "deleteQuery", "Lio/reactivex/Completable;", "query", "", "type", "Lcom/reddit/frontpage/domain/model/SearchType;", "getQueries", "Lio/reactivex/Single;", "", "saveQuery", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LocalSearchDataSource.kt */
public interface LocalSearchDataSource {
    Completable mo2978a(String str, SearchType searchType);

    Single<List<String>> mo2979a(SearchType searchType);

    Completable mo2980b(String str, SearchType searchType);
}
