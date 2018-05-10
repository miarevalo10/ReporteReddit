package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.domain.model.SearchResult;
import com.reddit.frontpage.presentation.search.CommunitySearchResultsPresenter.Result.Success;
import io.reactivex.functions.Consumer;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "result", "Lcom/reddit/frontpage/presentation/search/CommunitySearchResultsPresenter$Result;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitySearchResultsPresenter.kt */
final class CommunitySearchResultsPresenter$onLoadMoreMore$1<T> implements Consumer<Result> {
    final /* synthetic */ CommunitySearchResultsPresenter f28756a;

    CommunitySearchResultsPresenter$onLoadMoreMore$1(CommunitySearchResultsPresenter communitySearchResultsPresenter) {
        this.f28756a = communitySearchResultsPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        obj = (Result) obj;
        this.f28756a.f37052d = false;
        CommunitySearchResultsPresenter communitySearchResultsPresenter = this.f28756a;
        Intrinsics.m26843a(obj, "result");
        CommunitySearchResultsPresenter.m37414a(communitySearchResultsPresenter, obj, new Function1<Success, Unit>() {
            public final /* synthetic */ Object mo6492a(Object obj) {
                Success success = (Success) obj;
                Intrinsics.m26847b(success, "it");
                SearchResult searchResult = success.f28752a;
                obj = success.f28753b;
                this.f28756a.f37050b = searchResult.getAfter();
                this.f28756a.f37051c.addAll(searchResult.getItems());
                this.f28756a.f37057i.addAll((Collection) obj);
                this.f28756a.f37059k.mo7428a(this.f28756a.f37057i);
                return Unit.f25273a;
            }
        });
    }
}
