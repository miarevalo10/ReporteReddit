package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.frontpage.presentation.carousel.model.ICarouselItemPresentationModel;
import com.reddit.frontpage.ui.carousel.CarouselViewHolder;
import java.util.Set;
import kotlin.jvm.functions.Function3;

final /* synthetic */ class CardLinkAdapter$$Lambda$28 implements Function3 {
    private final CardLinkAdapter f34355a;
    private final CarouselViewHolder f34356b;

    CardLinkAdapter$$Lambda$28(CardLinkAdapter cardLinkAdapter, CarouselViewHolder carouselViewHolder) {
        this.f34355a = cardLinkAdapter;
        this.f34356b = carouselViewHolder;
    }

    public final Object mo6509a(Object obj, Object obj2, Object obj3) {
        return this.f34355a.m30185a(this.f34356b, (Integer) obj, (ICarouselItemPresentationModel) obj2, (Set) obj3);
    }
}
