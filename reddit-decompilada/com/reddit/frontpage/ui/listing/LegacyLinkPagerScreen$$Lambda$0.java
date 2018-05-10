package com.reddit.frontpage.ui.listing;

final /* synthetic */ class LegacyLinkPagerScreen$$Lambda$0 implements Runnable {
    private final LegacyLinkPagerScreen f21294a;

    LegacyLinkPagerScreen$$Lambda$0(LegacyLinkPagerScreen legacyLinkPagerScreen) {
        this.f21294a = legacyLinkPagerScreen;
    }

    public final void run() {
        LegacyLinkPagerScreen legacyLinkPagerScreen = this.f21294a;
        if (legacyLinkPagerScreen.f39219v != null && legacyLinkPagerScreen.f39219v.f37264d > 0) {
            legacyLinkPagerScreen.m39284a(legacyLinkPagerScreen.pagerPosition, false);
        }
    }
}
