package com.reddit.frontpage.ui.listing;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository;
import dagger.MembersInjector;

public final class AdsListingScreen_MembersInjector implements MembersInjector<AdsListingScreen> {
    public static void m30078a(AdsListingScreen adsListingScreen, AdsRepository adsRepository) {
        adsListingScreen.f40160v = adsRepository;
    }
}
