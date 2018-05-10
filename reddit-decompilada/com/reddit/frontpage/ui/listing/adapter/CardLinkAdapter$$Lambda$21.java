package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import com.reddit.frontpage.ui.carousel.LinkCarouselViewHolder;
import kotlin.jvm.functions.Function3;

final /* synthetic */ class CardLinkAdapter$$Lambda$21 implements Function3 {
    private final CardLinkAdapter f34342a;
    private final LinkCarouselViewHolder f34343b;

    CardLinkAdapter$$Lambda$21(CardLinkAdapter cardLinkAdapter, LinkCarouselViewHolder linkCarouselViewHolder) {
        this.f34342a = cardLinkAdapter;
        this.f34343b = linkCarouselViewHolder;
    }

    public final Object mo6509a(Object obj, Object obj2, Object obj3) {
        return this.f34342a.m30187a(this.f34343b, (Integer) obj, (LinkCarouselItemPresentationModel) obj2);
    }
}
