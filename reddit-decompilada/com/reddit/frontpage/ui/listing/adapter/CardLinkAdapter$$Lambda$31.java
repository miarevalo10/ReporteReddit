package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.presentation.listing.carousel.CarouselCollectionState;
import kotlin.jvm.functions.Function1;

final /* synthetic */ class CardLinkAdapter$$Lambda$31 implements Function1 {
    private final ICarouselItemPresentationModel f34359a;

    CardLinkAdapter$$Lambda$31(ICarouselItemPresentationModel iCarouselItemPresentationModel) {
        this.f34359a = iCarouselItemPresentationModel;
    }

    public final Object mo6492a(Object obj) {
        return ((CarouselCollectionState) obj).getDismissedItems().add(this.f34359a.mo6433a());
    }
}
