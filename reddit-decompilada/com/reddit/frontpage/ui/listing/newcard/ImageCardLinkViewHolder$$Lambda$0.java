package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.ui.listener.Consumer;

final /* synthetic */ class ImageCardLinkViewHolder$$Lambda$0 implements OnClickListener {
    private final ImageCardLinkViewHolder f21354a;
    private final Consumer f21355b;

    ImageCardLinkViewHolder$$Lambda$0(ImageCardLinkViewHolder imageCardLinkViewHolder, Consumer consumer) {
        this.f21354a = imageCardLinkViewHolder;
        this.f21355b = consumer;
    }

    public final void onClick(View view) {
        this.f21354a.m37625a(this.f21355b);
    }
}
