package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.LiveThread;
import com.reddit.frontpage.ui.listing.newcard.LiveThreadViewHolder;

final /* synthetic */ class BaseLinkListingScreen$FrontpageLinkAdapter$$Lambda$0 implements OnClickListener {
    private final LiveThreadViewHolder f21265a;
    private final LiveThread f21266b;

    BaseLinkListingScreen$FrontpageLinkAdapter$$Lambda$0(LiveThreadViewHolder liveThreadViewHolder, LiveThread liveThread) {
        this.f21265a = liveThreadViewHolder;
        this.f21266b = liveThread;
    }

    public final void onClick(View view) {
        FrontpageLinkAdapter.m35020b(this.f21265a, this.f21266b);
    }
}
