package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.ui.listener.Consumer;

final /* synthetic */ class SmallCardLinkViewHolder$$Lambda$0 implements OnClickListener {
    private final SmallCardLinkViewHolder f21371a;
    private final Consumer f21372b;

    SmallCardLinkViewHolder$$Lambda$0(SmallCardLinkViewHolder smallCardLinkViewHolder, Consumer consumer) {
        this.f21371a = smallCardLinkViewHolder;
        this.f21372b = consumer;
    }

    public final void onClick(View view) {
        this.f21371a.m37630a(this.f21372b);
    }
}
