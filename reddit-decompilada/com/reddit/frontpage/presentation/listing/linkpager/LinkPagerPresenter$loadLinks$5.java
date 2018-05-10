package com.reddit.frontpage.presentation.listing.linkpager;

import com.reddit.datalibrary.frontpage.data.feature.common.SortTimeFrame;
import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams;
import com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams.LoadMore;
import com.reddit.frontpage.presentation.listing.common.ListingType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000122\u0010\u0002\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006 \u0007*\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: LinkPagerPresenter.kt */
final class LinkPagerPresenter$loadLinks$5 extends Lambda implements Function1<Pair<? extends Listing<? extends Link>, ? extends Integer>, Unit> {
    final /* synthetic */ LinkPagerPresenter f36694a;
    final /* synthetic */ Function1 f36695b;

    LinkPagerPresenter$loadLinks$5(LinkPagerPresenter linkPagerPresenter, Function1 function1) {
        this.f36694a = linkPagerPresenter;
        this.f36695b = function1;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        LinkPagerLoadDataParams loadMore;
        Pair pair = (Pair) obj;
        Listing listing = (Listing) pair.f25267a;
        obj = ((Number) pair.f25268b).intValue();
        this.f36694a.f33934c.addAll(listing.getChildren());
        LinkPagerPresenter linkPagerPresenter = this.f36694a;
        LinkPagerLoadDataParams e = this.f36694a.f33933b;
        if (e instanceof StandardParams) {
            e = this.f36694a.f33933b;
            if (e == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.StandardParams");
            }
            StandardParams standardParams = (StandardParams) e;
            String after = listing.getAfter();
            ListingType listingType = standardParams.f28013a;
            SortTimeFrame sortTimeFrame = standardParams.f33747d;
            loadMore = new LoadMore(after, listing.getAdDistance(), listingType, standardParams.f33746c, sortTimeFrame);
        } else if (e instanceof HistoryParams) {
            e = this.f36694a.f33933b;
            if (e == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.reddit.frontpage.domain.usecase.LinkPagerLoadDataParams.HistoryParams");
            }
            HistoryParams historyParams = (HistoryParams) e;
            loadMore = new HistoryParams.LoadMore(listing.getAfter(), historyParams.f33743c, historyParams.f33744d);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        linkPagerPresenter.f33933b = loadMore;
        this.f36694a.f33937f.mo7361a(CollectionsKt___CollectionsKt.m41449n((Iterable) this.f36694a.f33934c));
        this.f36694a.f33937f.mo7363c();
        this.f36695b.mo6492a(Integer.valueOf(obj));
        return Unit.f25273a;
    }
}
