package com.reddit.frontpage.ui.profile;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;

final /* synthetic */ class SavedListingScreen$$Lambda$1 implements OnClickListener {
    private final SavedListingScreen f21528a;

    SavedListingScreen$$Lambda$1(SavedListingScreen savedListingScreen) {
        this.f21528a = savedListingScreen;
    }

    public final void onClick(View view) {
        view = this.f21528a;
        view.mo7461O();
        view.f39262w.a(true, ListingPerformanceTracker.m21961a(view.getAnalyticsScreenName()));
    }
}
