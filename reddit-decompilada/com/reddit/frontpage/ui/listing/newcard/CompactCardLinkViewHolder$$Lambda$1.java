package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.ui.listener.Consumer;

final /* synthetic */ class CompactCardLinkViewHolder$$Lambda$1 implements OnClickListener {
    private final CompactCardLinkViewHolder f21351a;
    private final Consumer f21352b;

    CompactCardLinkViewHolder$$Lambda$1(CompactCardLinkViewHolder compactCardLinkViewHolder, Consumer consumer) {
        this.f21351a = compactCardLinkViewHolder;
        this.f21352b = consumer;
    }

    public final void onClick(View view) {
        this.f21351a.m37619a(this.f21352b);
    }
}
