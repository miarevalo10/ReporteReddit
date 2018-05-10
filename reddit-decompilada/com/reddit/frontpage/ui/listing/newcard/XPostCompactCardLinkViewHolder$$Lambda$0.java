package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.view.View.OnLongClickListener;

final /* synthetic */ class XPostCompactCardLinkViewHolder$$Lambda$0 implements OnLongClickListener {
    private final XPostCompactCardLinkViewHolder f21382a;

    XPostCompactCardLinkViewHolder$$Lambda$0(XPostCompactCardLinkViewHolder xPostCompactCardLinkViewHolder) {
        this.f21382a = xPostCompactCardLinkViewHolder;
    }

    public final boolean onLongClick(View view) {
        this.f21382a.cardBodyView.linkHeaderView.m24134b();
        return true;
    }
}
