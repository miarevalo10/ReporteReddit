package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;

final /* synthetic */ class LinkViewHolder$$Lambda$0 implements OnClickListener {
    private final LinkViewHolder f21364a;
    private final Link f21365b;

    LinkViewHolder$$Lambda$0(LinkViewHolder linkViewHolder, Link link) {
        this.f21364a = linkViewHolder;
        this.f21365b = link;
    }

    public final void onClick(View view) {
        this.f21364a.m35123b(this.f21365b);
    }
}
