package com.reddit.frontpage.presentation.listing.common;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.domain.repository.PreferenceRepository;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import dagger.MembersInjector;

public final class LinkListingScreen_MembersInjector implements MembersInjector<LinkListingScreen> {
    public static void m29557a(LinkListingScreen linkListingScreen, FrontpageSettings frontpageSettings) {
        linkListingScreen.f40033B = frontpageSettings;
    }

    public static void m29558a(LinkListingScreen linkListingScreen, PreferenceRepository preferenceRepository) {
        linkListingScreen.f40034C = preferenceRepository;
    }

    public static void m29559a(LinkListingScreen linkListingScreen, ListingScreenActions listingScreenActions) {
        linkListingScreen.f40035D = listingScreenActions;
    }

    public static void m29560a(LinkListingScreen linkListingScreen, AdVisibilityTracker adVisibilityTracker) {
        linkListingScreen.f40036E = adVisibilityTracker;
    }
}
