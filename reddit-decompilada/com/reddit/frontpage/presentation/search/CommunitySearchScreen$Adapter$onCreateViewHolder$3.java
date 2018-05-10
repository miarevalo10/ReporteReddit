package com.reddit.frontpage.presentation.search;

import com.reddit.frontpage.domain.model.AccountSearchResultItem;
import com.reddit.frontpage.domain.model.SearchResultItem;
import com.reddit.frontpage.domain.model.SubredditSearchResultItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "position", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitySearchScreen.kt */
final class CommunitySearchScreen$Adapter$onCreateViewHolder$3 extends FunctionReference implements Function1<Integer, Unit> {
    CommunitySearchScreen$Adapter$onCreateViewHolder$3(CommunitySearchResultsPresenter communitySearchResultsPresenter) {
        super(1, communitySearchResultsPresenter);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(CommunitySearchResultsPresenter.class);
    }

    public final String mo5687b() {
        return "onItemClicked";
    }

    public final String mo6932c() {
        return "onItemClicked(I)V";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CommunitySearchResultsPresenter communitySearchResultsPresenter = (CommunitySearchResultsPresenter) this.b;
        SearchResultItem searchResultItem = (SearchResultItem) communitySearchResultsPresenter.f37051c.get(((Number) obj).intValue());
        if (searchResultItem instanceof SubredditSearchResultItem) {
            communitySearchResultsPresenter.f37054f.mo7426a(((SubredditSearchResultItem) searchResultItem).getSubreddit());
        } else if (searchResultItem instanceof AccountSearchResultItem) {
            communitySearchResultsPresenter.f37054f.mo7425a(((AccountSearchResultItem) searchResultItem).getAccount());
        } else {
            throw ((Throwable) new IllegalStateException("Unhandled search result item type"));
        }
        return Unit.f25273a;
    }
}
