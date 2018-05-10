package com.reddit.frontpage.ui.listing.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.ui.listing.newcard.LinkViewHolder;

final /* synthetic */ class CardLinkAdapter$$Lambda$5 implements OnClickListener {
    private final CardLinkAdapter f21323a;
    private final LinkViewHolder f21324b;
    private final Link f21325c;

    CardLinkAdapter$$Lambda$5(CardLinkAdapter cardLinkAdapter, LinkViewHolder linkViewHolder, Link link) {
        this.f21323a = cardLinkAdapter;
        this.f21324b = linkViewHolder;
        this.f21325c = link;
    }

    public final void onClick(View view) {
        this.f21323a.mo6468a(this.f21324b, this.f21325c);
    }
}
