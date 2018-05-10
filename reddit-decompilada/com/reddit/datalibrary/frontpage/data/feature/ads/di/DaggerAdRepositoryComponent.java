package com.reddit.datalibrary.frontpage.data.feature.ads.di;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository;
import com.reddit.frontpage.ui.listing.AdsListingScreen;
import com.reddit.frontpage.ui.listing.AdsListingScreen_MembersInjector;
import dagger.internal.DoubleCheck;
import javax.inject.Provider;

public final class DaggerAdRepositoryComponent implements AdRepositoryComponent {
    private Provider<AdsRepository> f15761a;

    public static final class Builder {
        public AdRepositoryModule f10321a;

        private Builder() {
        }
    }

    private DaggerAdRepositoryComponent(Builder builder) {
        this.f15761a = DoubleCheck.a(AdRepositoryModule_ProvideAdRepositoryFactory.m19666a(builder.f10321a));
    }

    public static Builder m15852a() {
        return new Builder();
    }

    public final void mo2916a(AdsListingScreen adsListingScreen) {
        AdsListingScreen_MembersInjector.a(adsListingScreen, (AdsRepository) this.f15761a.get());
    }
}
