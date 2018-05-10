package com.reddit.frontpage.ui.listing.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;

final /* synthetic */ class CardLinkAdapter$$Lambda$6 implements OnClickListener {
    private final CardLinkAdapter f21326a;
    private final Link f21327b;
    private final LinkViewHolder f21328c;

    CardLinkAdapter$$Lambda$6(CardLinkAdapter cardLinkAdapter, Link link, LinkViewHolder linkViewHolder) {
        this.f21326a = cardLinkAdapter;
        this.f21327b = link;
        this.f21328c = linkViewHolder;
    }

    public final void onClick(View view) {
        this.f21326a.m30194a(this.f21327b, this.f21328c);
    }
}
