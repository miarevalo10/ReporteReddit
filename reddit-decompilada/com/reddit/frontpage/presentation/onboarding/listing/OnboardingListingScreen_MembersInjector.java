package com.reddit.frontpage.presentation.onboarding.listing;

import com.reddit.frontpage.presentation.listing.common.ListingViewActions;
import dagger.MembersInjector;

public final class OnboardingListingScreen_MembersInjector implements MembersInjector<OnboardingListingScreen> {
    public static void m29844a(OnboardingListingScreen onboardingListingScreen, OnboardingListingPresenter onboardingListingPresenter) {
        onboardingListingScreen.f40598w = onboardingListingPresenter;
    }

    public static void m29843a(OnboardingListingScreen onboardingListingScreen, ListingViewActions listingViewActions) {
        onboardingListingScreen.f40599x = listingViewActions;
    }
}
