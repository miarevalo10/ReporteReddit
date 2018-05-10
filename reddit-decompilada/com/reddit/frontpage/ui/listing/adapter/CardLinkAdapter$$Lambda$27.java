package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.frontpage.presentation.carousel.model.GeneralCarouselCollectionPresentationModel;
import com.reddit.frontpage.ui.carousel.CarouselViewHolder;
import java.util.Set;
import kotlin.jvm.functions.Function1;

final /* synthetic */ class CardLinkAdapter$$Lambda$27 implements Function1 {
    private final CardLinkAdapter f34352a;
    private final CarouselViewHolder f34353b;
    private final GeneralCarouselCollectionPresentationModel f34354c;

    CardLinkAdapter$$Lambda$27(CardLinkAdapter cardLinkAdapter, CarouselViewHolder carouselViewHolder, GeneralCarouselCollectionPresentationModel generalCarouselCollectionPresentationModel) {
        this.f34352a = cardLinkAdapter;
        this.f34353b = carouselViewHolder;
        this.f34354c = generalCarouselCollectionPresentationModel;
    }

    public final Object mo6492a(Object obj) {
        return this.f34352a.m30184a(this.f34353b, this.f34354c, (Set) obj);
    }
}
