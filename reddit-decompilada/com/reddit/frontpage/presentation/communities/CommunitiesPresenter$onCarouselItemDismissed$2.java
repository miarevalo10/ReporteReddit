package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.communities.model.SubredditDiscoveryUnitItemPresentationModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "position", "", "replacement", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$onCarouselItemDismissed$2 extends Lambda implements Function2<Integer, CarouselCollectionPresentationModel, Unit> {
    final /* synthetic */ CommunitiesPresenter f36410a;
    final /* synthetic */ SubredditDiscoveryUnitItemPresentationModel f36411b;

    CommunitiesPresenter$onCarouselItemDismissed$2(CommunitiesPresenter communitiesPresenter, SubredditDiscoveryUnitItemPresentationModel subredditDiscoveryUnitItemPresentationModel) {
        this.f36410a = communitiesPresenter;
        this.f36411b = subredditDiscoveryUnitItemPresentationModel;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        obj = ((Number) obj).intValue();
        CarouselCollectionPresentationModel carouselCollectionPresentationModel = (CarouselCollectionPresentationModel) obj2;
        Intrinsics.m26847b(carouselCollectionPresentationModel, "replacement");
        GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel = (GeneralCarouselCollectionPresentationModel) carouselCollectionPresentationModel;
        this.f36410a.f33808b.m40551a(generalCarouselCollectionPresentationModel);
        this.f36410a.f33808b.m40550a(obj, this.f36411b.mo7152a(generalCarouselCollectionPresentationModel));
        return Unit.f25273a;
    }
}
