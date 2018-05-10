package com.reddit.frontpage.ui.listing;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Banner;
import com.reddit.frontpage.ui.listing.newcard.BannerViewHolder;

final /* synthetic */ class BaseLinkListingScreen$FrontpageLinkAdapter$$Lambda$1 implements OnClickListener {
    private final Banner f21267a;
    private final BannerViewHolder f21268b;

    BaseLinkListingScreen$FrontpageLinkAdapter$$Lambda$1(Banner banner, BannerViewHolder bannerViewHolder) {
        this.f21267a = banner;
        this.f21268b = bannerViewHolder;
    }

    public final void onClick(View view) {
        FrontpageLinkAdapter.m35019a(this.f21267a, this.f21268b);
    }
}
