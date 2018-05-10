package com.reddit.frontpage.presentation.communities;

import com.reddit.frontpage.presentation.carousel.model.CarouselCollectionPresentationModel;
import com.reddit.frontpage.presentation.communities.CommunitiesPresenter.DiscoveryUnitLoadResult.Result;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/communities/CommunitiesPresenter$DiscoveryUnitLoadResult;", "it", "Lcom/reddit/frontpage/presentation/carousel/model/CarouselCollectionPresentationModel;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: CommunitiesPresenter.kt */
final class CommunitiesPresenter$fetchDiscoveryUnits$1<T, R> implements Function<T, R> {
    public static final CommunitiesPresenter$fetchDiscoveryUnits$1 f28108a = new CommunitiesPresenter$fetchDiscoveryUnits$1();

    CommunitiesPresenter$fetchDiscoveryUnits$1() {
    }

    public final /* synthetic */ Object apply(Object obj) {
        CarouselCollectionPresentationModel carouselCollectionPresentationModel = (CarouselCollectionPresentationModel) obj;
        Intrinsics.m26847b(carouselCollectionPresentationModel, "it");
        return new Result(carouselCollectionPresentationModel);
    }
}
