package com.reddit.frontpage.presentation.listing.frontpage;

import com.reddit.datalibrary.frontpage.requests.models.v2.Listable;
import com.reddit.datalibrary.frontpage.requests.models.v2.Listable.Companion;
import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.ui.listing.DiscoveryUnitManager.DiscoveryUnitListingView;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"com/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter$discoveryUnitListingView$1", "Lcom/reddit/frontpage/ui/listing/DiscoveryUnitManager$DiscoveryUnitListingView;", "(Lcom/reddit/frontpage/presentation/listing/frontpage/FrontpageListingPresenter;)V", "isViewAttached", "", "()Z", "numListItems", "", "getNumListItems", "()I", "surfaceName", "", "getSurfaceName", "()Ljava/lang/String;", "addItemToListing", "", "position", "item", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "getIndexOfLastDiscoveryUnit", "notifyDiscoveryUnitInsertedAtPosition", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: FrontpageListingPresenter.kt */
public final class FrontpageListingPresenter$discoveryUnitListingView$1 implements DiscoveryUnitListingView {
    final /* synthetic */ FrontpageListingPresenter f28382a;

    public final String mo4800c() {
        return "front_page";
    }

    public final Boolean mo4802e() {
        return null;
    }

    FrontpageListingPresenter$discoveryUnitListingView$1(FrontpageListingPresenter frontpageListingPresenter) {
        this.f28382a = frontpageListingPresenter;
    }

    public final int mo4796a() {
        return this.f28382a.f36633b.size();
    }

    public final void mo4797a(int i) {
        this.f28382a.f36634c.mo7330b(this.f28382a.f36633b);
        this.f28382a.f36634c.mo7323a(i, 1);
    }

    public final void mo4798a(int i, CarouselCollectionPresentationModel carouselCollectionPresentationModel) {
        Intrinsics.m26847b(carouselCollectionPresentationModel, "item");
        this.f28382a.f36633b.add(i, carouselCollectionPresentationModel);
    }

    public final boolean mo4799b() {
        return this.f28382a.f36647q;
    }

    public final int mo4801d() {
        List b = this.f28382a.f36633b;
        ListIterator listIterator = b.listIterator(b.size());
        while (listIterator.hasPrevious()) {
            Listable listable = (Listable) listIterator.previous();
            Companion companion = Listable.Companion;
            if (Companion.m21639a().contains(Integer.valueOf(listable.getListableType()))) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
