package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.domain.model.SearchResult;
import com.reddit.frontpage.domain.model.SearchResultItem;
import com.reddit.frontpage.presentation.search.CommunitySearchResultsPresenter.Result.Success;
import com.reddit.frontpage.presentation.search.SearchModelsMapper.SearchItemPresentationModel;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result;", "searchResult", "Lcom/reddit/frontpage/domain/model/SearchResult;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitySearchResultsPresenter.kt */
final class CommunitySearchResultsPresenter$mapToResult$1<T, R> implements Function<T, R> {
    final /* synthetic */ CommunitySearchResultsPresenter f28754a;

    CommunitySearchResultsPresenter$mapToResult$1(CommunitySearchResultsPresenter communitySearchResultsPresenter) {
        this.f28754a = communitySearchResultsPresenter;
    }

    public final /* synthetic */ Object apply(Object obj) {
        SearchResult searchResult = (SearchResult) obj;
        Intrinsics.m26847b(searchResult, "searchResult");
        Iterable<SearchResultItem> items = searchResult.getItems();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(items));
        for (SearchResultItem searchResultItem : items) {
            SearchModelsMapper searchModelsMapper = SearchModelsMapper.f20973a;
            SearchItemPresentationModel a = SearchModelsMapper.m23193a(searchResultItem, this.f28754a.f37060l, this.f28754a.f37061m, this.f28754a.f37062n);
            arrayList.add(new CommunitySearchResultItem(a.f20970a, a.f20971b, a.f20972c));
        }
        return new Success(searchResult, (List) arrayList);
    }
}
