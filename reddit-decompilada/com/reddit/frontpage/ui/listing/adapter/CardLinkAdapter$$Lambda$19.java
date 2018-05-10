package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.frontpage.presentation.carousel.model.LinkCarouselCollectionPresentationModel;
import com.reddit.frontpage.ui.carousel.LinkCarouselViewHolder;
import java.util.Set;
import kotlin.jvm.functions.Function1;

final /* synthetic */ class CardLinkAdapter$$Lambda$19 implements Function1 {
    private final CardLinkAdapter f34336a;
    private final LinkCarouselViewHolder f34337b;
    private final LinkCarouselCollectionPresentationModel f34338c;

    CardLinkAdapter$$Lambda$19(CardLinkAdapter cardLinkAdapter, LinkCarouselViewHolder linkCarouselViewHolder, LinkCarouselCollectionPresentationModel linkCarouselCollectionPresentationModel) {
        this.f34336a = cardLinkAdapter;
        this.f34337b = linkCarouselViewHolder;
        this.f34338c = linkCarouselCollectionPresentationModel;
    }

    public final Object mo6492a(Object obj) {
        return this.f34336a.m30186a(this.f34337b, this.f34338c, (Set) obj);
    }
}
