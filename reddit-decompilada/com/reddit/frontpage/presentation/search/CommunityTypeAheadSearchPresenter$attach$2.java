package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.domain.model.SearchResult;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/search/CommunityTypeAheadSearchPresenter$Result;", "<name for destructuring parameter 0>", "Lcom/reddit/frontpage/domain/model/SearchResult;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunityTypeAheadSearchPresenter.kt */
final class CommunityTypeAheadSearchPresenter$attach$2<T, R> implements Function<T, R> {
    final /* synthetic */ CommunityTypeAheadSearchPresenter f28776a;

    CommunityTypeAheadSearchPresenter$attach$2(CommunityTypeAheadSearchPresenter communityTypeAheadSearchPresenter) {
        this.f28776a = communityTypeAheadSearchPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        SearchResult searchResult = (SearchResult) obj;
        Intrinsics.m26847b(searchResult, "<name for destructuring parameter 0>");
        return CommunityTypeAheadSearchPresenter.m37448a(this.f28776a, searchResult.component1(), searchResult.component2());
    }
}
