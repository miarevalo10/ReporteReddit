package com.reddit.frontpage.presentation.listing;

import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import com.reddit.frontpage.presentation.listing.popular.PopularListingPresenter;
import dagger.MembersInjector;

public final class PopularListingScreen_MembersInjector implements MembersInjector<PopularListingScreen> {
    public static void m29552a(PopularListingScreen popularListingScreen, PopularListingPresenter popularListingPresenter) {
        popularListingScreen.f40570w = popularListingPresenter;
    }

    public static void m29551a(PopularListingScreen popularListingScreen, ListingViewActions listingViewActions) {
        popularListingScreen.f40571x = listingViewActions;
    }
}
