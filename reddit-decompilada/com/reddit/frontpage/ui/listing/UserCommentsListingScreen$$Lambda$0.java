package com.reddit.frontpage.ui.listing;

import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import com.reddit.frontpage.commons.analytics.performance.ListingPerformanceTracker;

final /* synthetic */ class UserCommentsListingScreen$$Lambda$0 implements OnRefreshListener {
    private final UserCommentsListingScreen f29069a;

    UserCommentsListingScreen$$Lambda$0(UserCommentsListingScreen userCommentsListingScreen) {
        this.f29069a = userCommentsListingScreen;
    }

    public final void m30121a() {
        UserCommentsListingScreen userCommentsListingScreen = this.f29069a;
        userCommentsListingScreen.f39234x.a(true, ListingPerformanceTracker.m21961a(userCommentsListingScreen.getAnalyticsScreenName()));
    }
}
