package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.frontpage.presentation.carousel.model.LinkCarouselItemPresentationModel;
import com.reddit.frontpage.ui.carousel.LinkCarouselViewHolder;
import java.util.Set;
import kotlin.jvm.functions.Function3;

final /* synthetic */ class CardLinkAdapter$$Lambda$20 implements Function3 {
    private final CardLinkAdapter f34340a;
    private final LinkCarouselViewHolder f34341b;

    CardLinkAdapter$$Lambda$20(CardLinkAdapter cardLinkAdapter, LinkCarouselViewHolder linkCarouselViewHolder) {
        this.f34340a = cardLinkAdapter;
        this.f34341b = linkCarouselViewHolder;
    }

    public final Object mo6509a(Object obj, Object obj2, Object obj3) {
        return this.f34340a.m30188a(this.f34341b, (Integer) obj, (LinkCarouselItemPresentationModel) obj2, (Set) obj3);
    }
}
