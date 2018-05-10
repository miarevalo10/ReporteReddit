package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class UserSubmittedListingViewModule_LinkActionsFactory implements Factory<UserLinkActions> {
    private final UserSubmittedListingViewModule f33704a;
    private final Provider<ListingNavigator> f33705b;
    private final Provider<SessionManager> f33706c;
    private final Provider<AdsNavigator> f33707d;

    private UserSubmittedListingViewModule_LinkActionsFactory(UserSubmittedListingViewModule userSubmittedListingViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        this.f33704a = userSubmittedListingViewModule;
        this.f33705b = provider;
        this.f33706c = provider2;
        this.f33707d = provider3;
    }

    public static UserSubmittedListingViewModule_LinkActionsFactory m34549a(UserSubmittedListingViewModule userSubmittedListingViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        return new UserSubmittedListingViewModule_LinkActionsFactory(userSubmittedListingViewModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (UserLinkActions) Preconditions.m26013a(UserSubmittedListingViewModule.m22385a((ListingNavigator) this.f33705b.get(), (SessionManager) this.f33706c.get(), (AdsNavigator) this.f33707d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
