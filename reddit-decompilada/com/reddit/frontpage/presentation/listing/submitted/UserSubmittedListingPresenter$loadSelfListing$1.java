package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.listing.model.LinkMapper;
import com.reddit.frontpage.util.kotlin.MutableListsKt;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "results", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingPresenter.kt */
final class UserSubmittedListingPresenter$loadSelfListing$1<T> implements Consumer<Listing<? extends Link>> {
    final /* synthetic */ UserSubmittedListingPresenter f28462a;

    UserSubmittedListingPresenter$loadSelfListing$1(UserSubmittedListingPresenter userSubmittedListingPresenter) {
        this.f28462a = userSubmittedListingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Listing listing = (Listing) obj;
        MutableListsKt.m24089a(this.f28462a.f36737c, listing.getChildren());
        this.f28462a.f36738d = listing.getAfter();
        obj = this.f28462a.f36741h;
        LinkMapper linkMapper = LinkMapper.f20611a;
        MutableListsKt.m24089a(obj, LinkMapper.m22970a(this.f28462a.f36737c));
        this.f28462a.f36743j = false;
        this.f28462a.f36739e.mo7370c();
        this.f28462a.f36739e.O_();
        this.f28462a.f36739e.mo7330b(this.f28462a.f36741h);
        this.f28462a.f36739e.mo7335x();
        if (this.f28462a.f36741h.isEmpty() != null) {
            this.f28462a.f36739e.Q_();
        } else {
            this.f28462a.f36739e.P_();
        }
    }
}
