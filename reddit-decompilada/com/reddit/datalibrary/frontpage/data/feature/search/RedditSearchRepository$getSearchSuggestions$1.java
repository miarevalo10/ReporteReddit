package com.reddit.datalibrary.frontpage.data.feature.search;

import com.reddit.datalibrary.frontpage.data.model.RemoteSearchResult;
import com.reddit.frontpage.domain.model.SearchResult;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lio/reactivex/Observable;", "Lcom/reddit/frontpage/domain/model/SearchResult;", "kotlin.jvm.PlatformType", "currentQuery", "", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSearchRepository.kt */
final class RedditSearchRepository$getSearchSuggestions$1<T, R> implements Function<T, ObservableSource<? extends R>> {
    final /* synthetic */ RedditSearchRepository f16133a;
    final /* synthetic */ boolean f16134b = true;
    final /* synthetic */ boolean f16135c = true;

    RedditSearchRepository$getSearchSuggestions$1(RedditSearchRepository redditSearchRepository) {
        this.f16133a = redditSearchRepository;
    }

    public final /* synthetic */ Object apply(Object obj) {
        final String str = (String) obj;
        Intrinsics.b(str, "currentQuery");
        return this.f16133a.f16138a.getSearchSuggestions(str, this.f16134b, this.f16135c).onErrorResumeNext(Single.never()).map(new Function<T, R>() {
            public final /* synthetic */ Object apply(Object obj) {
                RemoteSearchResult remoteSearchResult = (RemoteSearchResult) obj;
                Intrinsics.b(remoteSearchResult, "it");
                String str = str;
                Intrinsics.a(str, "currentQuery");
                return new SearchResult(str, remoteSearchResult.getItems(), null, 4, null);
            }
        }).toObservable();
    }
}
