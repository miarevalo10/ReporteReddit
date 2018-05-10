package com.reddit.frontpage.ui.listing.adapter;

import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;
import com.reddit.frontpage.widgets.LinkFooterView.OnViewCommentsListener;

final /* synthetic */ class CardLinkAdapter$$Lambda$4 implements OnViewCommentsListener {
    private final CardLinkAdapter f29095a;
    private final LinkViewHolder f29096b;
    private final Link f29097c;

    CardLinkAdapter$$Lambda$4(CardLinkAdapter cardLinkAdapter, LinkViewHolder linkViewHolder, Link link) {
        this.f29095a = cardLinkAdapter;
        this.f29096b = linkViewHolder;
        this.f29097c = link;
    }

    public final void mo4990a() {
        this.f29095a.mo6468a(this.f29096b, this.f29097c);
    }
}
