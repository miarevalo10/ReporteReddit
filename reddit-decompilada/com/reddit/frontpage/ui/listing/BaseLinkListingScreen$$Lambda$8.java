package com.reddit.frontpage.ui.listing;

import com.bluelinelabs.conductor.Controller;

final /* synthetic */ class BaseLinkListingScreen$$Lambda$8 implements Runnable {
    private final BaseLinkListingScreen f21262a;

    BaseLinkListingScreen$$Lambda$8(BaseLinkListingScreen baseLinkListingScreen) {
        this.f21262a = baseLinkListingScreen;
    }

    public final void run() {
        Controller controller = this.f21262a;
        if (controller.e) {
            controller.swipeRefreshLayout.setRefreshing(false);
        }
    }
}
