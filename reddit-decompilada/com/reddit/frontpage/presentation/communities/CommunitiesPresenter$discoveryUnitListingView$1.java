package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.communities.model.CommunityListItem;
import com.reddit.frontpage.presentation.communities.model.SubredditDiscoveryUnitItemPresentationModel;
import com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitListingView;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"com/reddit/frontpage/presentation/communities/CommunitiesPresenter$discoveryUnitListingView$1", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitListingView;", "(Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter;)V", "isViewAttached", "", "()Z", "numListItems", "", "getNumListItems", "()I", "surfaceName", "", "getSurfaceName", "()Ljava/lang/String;", "addItemToListing", "", "position", "item", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "getIndexOfLastDiscoveryUnit", "notifyDiscoveryUnitInsertedAtPosition", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
public final class CommunitiesPresenter$discoveryUnitListingView$1 implements DiscoveryUnitListingView {
    final /* synthetic */ CommunitiesPresenter f28107a;

    public final void mo4797a(int i) {
    }

    public final void mo4798a(int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel) {
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
    }

    public final String mo4800c() {
        return "communities";
    }

    public final Boolean mo4802e() {
        return null;
    }

    CommunitiesPresenter$discoveryUnitListingView$1(CommunitiesPresenter communitiesPresenter) {
        this.f28107a = communitiesPresenter;
    }

    public final int mo4796a() {
        return this.f28107a.f33808b.size();
    }

    public final boolean mo4799b() {
        return this.f28107a.f33816k;
    }

    public final int mo4801d() {
        List a = this.f28107a.f33808b;
        ListIterator listIterator = a.listIterator(a.size());
        while (listIterator.hasPrevious()) {
            if (((CommunityListItem) listIterator.previous()) instanceof SubredditDiscoveryUnitItemPresentationModel) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
