package com.reddit.frontpage.ui.listing.newcard;

import android.view.View;
import android.view.View.OnLongClickListener;

final /* synthetic */ class CompactCardLinkViewHolder$$Lambda$0 implements OnLongClickListener {
    private final CompactCardLinkViewHolder f21350a;

    CompactCardLinkViewHolder$$Lambda$0(CompactCardLinkViewHolder compactCardLinkViewHolder) {
        this.f21350a = compactCardLinkViewHolder;
    }

    public final boolean onLongClick(View view) {
        this.f21350a.bodyView.linkHeaderView.m24134b();
        return true;
    }
}
