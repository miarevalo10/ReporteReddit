package com.reddit.frontpage.ui.profile;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;

final /* synthetic */ class SavedListingScreen$$Lambda$0 implements OnRefreshListener {
    private final SavedListingScreen f29238a;

    SavedListingScreen$$Lambda$0(SavedListingScreen savedListingScreen) {
        this.f29238a = savedListingScreen;
    }

    public final void m30345a() {
        SavedListingScreen savedListingScreen = this.f29238a;
        savedListingScreen.f39262w.a(true, ListingPerformanceTracker.m21961a(savedListingScreen.getAnalyticsScreenName()));
    }
}
