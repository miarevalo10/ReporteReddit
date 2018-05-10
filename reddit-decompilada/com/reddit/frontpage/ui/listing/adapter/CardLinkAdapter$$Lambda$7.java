package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker.VisiblityListener;

final /* synthetic */ class CardLinkAdapter$$Lambda$7 implements VisiblityListener {
    private final CardLinkAdapter f29098a;
    private final Link f29099b;

    CardLinkAdapter$$Lambda$7(CardLinkAdapter cardLinkAdapter, Link link) {
        this.f29098a = cardLinkAdapter;
        this.f29099b = link;
    }

    public final void mo4955a(float f) {
        CardLinkAdapter cardLinkAdapter = this.f29098a;
        cardLinkAdapter.f29112i.m23442a(this.f29099b, f);
    }
}
