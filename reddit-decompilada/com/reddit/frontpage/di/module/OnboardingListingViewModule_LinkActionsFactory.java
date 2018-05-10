package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class OnboardingListingViewModule_LinkActionsFactory implements Factory<UserLinkActions> {
    private final OnboardingListingViewModule f33633a;
    private final Provider<ListingNavigator> f33634b;
    private final Provider<SessionManager> f33635c;
    private final Provider<AdsNavigator> f33636d;

    private OnboardingListingViewModule_LinkActionsFactory(OnboardingListingViewModule onboardingListingViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        this.f33633a = onboardingListingViewModule;
        this.f33634b = provider;
        this.f33635c = provider2;
        this.f33636d = provider3;
    }

    public static OnboardingListingViewModule_LinkActionsFactory m34520a(OnboardingListingViewModule onboardingListingViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        return new OnboardingListingViewModule_LinkActionsFactory(onboardingListingViewModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (UserLinkActions) Preconditions.m26013a(OnboardingListingViewModule.m22360a((ListingNavigator) this.f33634b.get(), (SessionManager) this.f33635c.get(), (AdsNavigator) this.f33636d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
