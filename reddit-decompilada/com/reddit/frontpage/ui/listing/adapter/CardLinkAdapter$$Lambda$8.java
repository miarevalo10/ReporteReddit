package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.frontpage.presentation.listing.model.LinkPresentationModel;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker.VisiblityListener;

final /* synthetic */ class CardLinkAdapter$$Lambda$8 implements VisiblityListener {
    private final CardLinkAdapter f29100a;
    private final LinkPresentationModel f29101b;

    CardLinkAdapter$$Lambda$8(CardLinkAdapter cardLinkAdapter, LinkPresentationModel linkPresentationModel) {
        this.f29100a = cardLinkAdapter;
        this.f29101b = linkPresentationModel;
    }

    public final void mo4955a(float f) {
        CardLinkAdapter cardLinkAdapter = this.f29100a;
        cardLinkAdapter.f29113j.m23442a(this.f29101b, f);
    }
}
