package com.reddit.frontpage.presentation.listing.linkpager;

import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import dagger.MembersInjector;

public final class LinkPagerScreen_MembersInjector implements MembersInjector<LinkPagerScreen> {
    public static void m29673a(LinkPagerScreen linkPagerScreen, LinkPagerPresenter linkPagerPresenter) {
        linkPagerScreen.f40055w = linkPagerPresenter;
    }

    public static void m29674a(LinkPagerScreen linkPagerScreen, AdVisibilityTracker adVisibilityTracker) {
        linkPagerScreen.f40056x = adVisibilityTracker;
    }
}
