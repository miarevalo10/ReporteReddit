package com.reddit.frontpage.presentation.listing.submitted;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import dagger.MembersInjector;

public final class UserSubmittedListingScreen_MembersInjector implements MembersInjector<UserSubmittedListingScreen> {
    public static void m29702a(UserSubmittedListingScreen userSubmittedListingScreen, UserSubmittedListingPresenter userSubmittedListingPresenter) {
        userSubmittedListingScreen.f40073w = userSubmittedListingPresenter;
    }

    public static void m29701a(UserSubmittedListingScreen userSubmittedListingScreen, FrontpageSettings frontpageSettings) {
        userSubmittedListingScreen.f40074x = frontpageSettings;
    }
}
