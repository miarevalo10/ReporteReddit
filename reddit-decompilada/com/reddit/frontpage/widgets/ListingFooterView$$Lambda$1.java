package com.reddit.frontpage.widgets;

import android.view.View;
import android.view.View.OnClickListener;

final /* synthetic */ class ListingFooterView$$Lambda$1 implements OnClickListener {
    private final ListingFooterView f21926a;

    ListingFooterView$$Lambda$1(ListingFooterView listingFooterView) {
        this.f21926a = listingFooterView;
    }

    public final void onClick(View view) {
        ListingFooterView listingFooterView = this.f21926a;
        if (listingFooterView.f21928b != null) {
            listingFooterView.f21928b.onClick(view);
        }
    }
}
