package com.reddit.frontpage.presentation.listing;

import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import com.reddit.frontpage.presentation.listing.frontpage.FrontpageListingPresenter;
import dagger.MembersInjector;

public final class FrontpageListingScreen_MembersInjector implements MembersInjector<FrontpageListingScreen> {
    public static void m29549a(FrontpageListingScreen frontpageListingScreen, FrontpageListingPresenter frontpageListingPresenter) {
        frontpageListingScreen.f40561w = frontpageListingPresenter;
    }

    public static void m29548a(FrontpageListingScreen frontpageListingScreen, ListingViewActions listingViewActions) {
        frontpageListingScreen.f40562x = listingViewActions;
    }
}
