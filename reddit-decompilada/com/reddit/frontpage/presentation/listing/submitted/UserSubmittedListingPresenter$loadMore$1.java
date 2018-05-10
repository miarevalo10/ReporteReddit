package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkMapper;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "results", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingPresenter.kt */
final class UserSubmittedListingPresenter$loadMore$1<T> implements Consumer<Listing<? extends Link>> {
    final /* synthetic */ UserSubmittedListingPresenter f28454a;

    UserSubmittedListingPresenter$loadMore$1(UserSubmittedListingPresenter userSubmittedListingPresenter) {
        this.f28454a = userSubmittedListingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Listing listing = (Listing) obj;
        int a = CollectionsKt__CollectionsKt.m26787a(this.f28454a.f36741h);
        this.f28454a.f36737c.addAll(listing.getChildren());
        List a2 = this.f28454a.f36741h;
        LinkMapper linkMapper = LinkMapper.f20611a;
        a2.addAll(LinkMapper.m22970a(listing.getChildren()));
        this.f28454a.f36738d = listing.getAfter();
        this.f28454a.f36739e.mo7330b(this.f28454a.f36741h);
        this.f28454a.f36739e.mo7323a(a, listing.getChildren().size());
        this.f28454a.f36743j = false;
    }
}
