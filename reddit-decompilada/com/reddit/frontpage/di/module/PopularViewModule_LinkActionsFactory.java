package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PopularViewModule_LinkActionsFactory implements Factory<UserLinkActions> {
    private final PopularViewModule f33640a;
    private final Provider<ListingNavigator> f33641b;
    private final Provider<SessionManager> f33642c;
    private final Provider<AdsNavigator> f33643d;

    private PopularViewModule_LinkActionsFactory(PopularViewModule popularViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        this.f33640a = popularViewModule;
        this.f33641b = provider;
        this.f33642c = provider2;
        this.f33643d = provider3;
    }

    public static PopularViewModule_LinkActionsFactory m34523a(PopularViewModule popularViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        return new PopularViewModule_LinkActionsFactory(popularViewModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (UserLinkActions) Preconditions.m26013a(PopularViewModule.m22362a((ListingNavigator) this.f33641b.get(), (SessionManager) this.f33642c.get(), (AdsNavigator) this.f33643d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
