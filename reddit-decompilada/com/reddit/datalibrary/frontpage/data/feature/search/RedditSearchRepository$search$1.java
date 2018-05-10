package com.reddit.datalibrary.frontpage.data.feature.search;

import com.reddit.datalibrary.frontpage.data.model.RemoteSearchResult;
import com.reddit.frontpage.domain.model.SearchResult;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/domain/model/SearchResult;", "it", "Lcom/reddit/datalibrary/frontpage/data/model/RemoteSearchResult;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditSearchRepository.kt */
final class RedditSearchRepository$search$1<T, R> implements Function<T, R> {
    final /* synthetic */ String f16136a;
    final /* synthetic */ String f16137b;

    RedditSearchRepository$search$1(String str, String str2) {
        this.f16136a = str;
        this.f16137b = str2;
    }

    public final /* synthetic */ Object apply(Object obj) {
        RemoteSearchResult remoteSearchResult = (RemoteSearchResult) obj;
        Intrinsics.b(remoteSearchResult, "it");
        return new SearchResult(this.f16136a, remoteSearchResult.getItems(), this.f16137b);
    }
}
