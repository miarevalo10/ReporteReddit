package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.datalibrary.frontpage.data.model.Listing;
import com.reddit.frontpage.domain.model.Karma;
import com.reddit.frontpage.domain.model.Link;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel.Companion;
import com.reddit.frontpage.presentation.listing.model.LinkMapper;
import com.reddit.frontpage.ui.carousel.KarmaCarouselItemPresentationModel;
import com.reddit.frontpage.util.Util;
import com.reddit.frontpage.util.kotlin.MutableListsKt;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012B\u0010\u0002\u001a>\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006 \b*\u001e\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Pair;", "", "Lcom/reddit/frontpage/domain/model/Karma;", "Lcom/reddit/datalibrary/frontpage/data/model/Listing;", "Lcom/reddit/frontpage/domain/model/Link;", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 1, 9})
/* compiled from: UserSubmittedListingPresenter.kt */
final class UserSubmittedListingPresenter$loadOtherUserListing$2<T> implements Consumer<Pair<? extends List<? extends Karma>, ? extends Listing<? extends Link>>> {
    final /* synthetic */ UserSubmittedListingPresenter f28460a;

    UserSubmittedListingPresenter$loadOtherUserListing$2(UserSubmittedListingPresenter userSubmittedListingPresenter) {
        this.f28460a = userSubmittedListingPresenter;
    }

    public final /* synthetic */ void accept(Object obj) {
        Pair pair = (Pair) obj;
        List list = (List) pair.f25267a;
        Listing listing = (Listing) pair.f25268b;
        this.f28460a.f36741h.clear();
        if (list != null) {
            MutableListsKt.m24089a(this.f28460a.f36742i, CollectionsKt___CollectionsKt.m41415a((Iterable) list, 8));
            list = this.f28460a.f36741h;
            Companion companion = CarouselCollectionPresentationModel.f33781a;
            Iterable<Karma> e = this.f28460a.f36742i;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(e));
            for (Karma karma : e) {
                arrayList.add(new KarmaCarouselItemPresentationModel(karma, Util.m23953a(karma.getKeyColor())));
            }
            list.add(Companion.m22682a((List) arrayList));
        }
        MutableListsKt.m24089a(this.f28460a.f36737c, listing.getChildren());
        this.f28460a.f36738d = listing.getAfter();
        obj = this.f28460a.f36741h;
        LinkMapper linkMapper = LinkMapper.f20611a;
        obj.addAll(LinkMapper.m22970a(this.f28460a.f36737c));
        if (this.f28460a.f36741h.isEmpty() != null) {
            this.f28460a.f36739e.Q_();
        } else {
            this.f28460a.f36739e.P_();
        }
        this.f28460a.f36739e.mo7330b(this.f28460a.f36741h);
        this.f28460a.f36739e.mo7335x();
        this.f28460a.f36743j = false;
        this.f28460a.f36739e.mo7370c();
        this.f28460a.f36739e.O_();
    }
}
