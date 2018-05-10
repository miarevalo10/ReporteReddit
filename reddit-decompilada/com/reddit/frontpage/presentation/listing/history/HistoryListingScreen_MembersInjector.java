package com.reddit.frontpage.presentation.listing.history;

import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import dagger.MembersInjector;

public final class HistoryListingScreen_MembersInjector implements MembersInjector<HistoryListingScreen> {
    public static void m29666a(HistoryListingScreen historyListingScreen, HistoryListingPresenter historyListingPresenter) {
        historyListingScreen.f40580w = historyListingPresenter;
    }

    public static void m29665a(HistoryListingScreen historyListingScreen, ListingViewActions listingViewActions) {
        historyListingScreen.f40581x = listingViewActions;
    }
}
