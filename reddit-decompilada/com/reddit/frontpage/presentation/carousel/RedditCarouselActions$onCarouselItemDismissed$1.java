package com.reddit.frontpage.presentation.carousel;

import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/listing/carousel/CarouselCollectionState;", "old", "invoke"}, k = 3, mv = {1, 1, 9})
/* compiled from: RedditCarouselActions.kt */
final class RedditCarouselActions$onCarouselItemDismissed$1 extends Lambda implements Function1<CarouselCollectionState, CarouselCollectionState> {
    final /* synthetic */ ICarouselItemPresentationModel f36352a;

    RedditCarouselActions$onCarouselItemDismissed$1(ICarouselItemPresentationModel iCarouselItemPresentationModel) {
        this.f36352a = iCarouselItemPresentationModel;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        CarouselCollectionState carouselCollectionState = (CarouselCollectionState) obj;
        Intrinsics.m26847b(carouselCollectionState, "old");
        carouselCollectionState.getDismissedItems().add(this.f36352a.mo6433a());
        return carouselCollectionState;
    }
}
