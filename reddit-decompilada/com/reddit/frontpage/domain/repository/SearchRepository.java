package com.reddit.frontpage.domain.repository;

import com.reddit.frontpage.domain.model.SearchResult;
import com.reddit.frontpage.domain.model.SearchType;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH&J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\t2\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015H&¨\u0006\u0016"}, d2 = {"Lcom/reddit/frontpage/domain/repository/SearchRepository;", "", "deleteQuery", "Lio/reactivex/Completable;", "query", "", "type", "Lcom/reddit/frontpage/domain/model/SearchType;", "getQueries", "Lio/reactivex/Single;", "", "getSearchSuggestions", "Lio/reactivex/Observable;", "Lcom/reddit/frontpage/domain/model/SearchResult;", "allowNsfw", "", "includeUsers", "saveQuery", "search", "after", "types", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SearchRepository.kt */
public interface SearchRepository {

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    /* compiled from: SearchRepository.kt */
    public static final class DefaultImpls {
    }

    Completable m22486a(String str, SearchType searchType);

    Observable<SearchResult> m22487a(Observable<String> observable);

    Single<List<String>> m22488a(SearchType searchType);

    Single<SearchResult> m22489a(String str, String str2, Set<? extends SearchType> set);

    Completable m22490b(String str, SearchType searchType);
}
