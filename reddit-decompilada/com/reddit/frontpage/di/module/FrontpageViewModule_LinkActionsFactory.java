package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class FrontpageViewModule_LinkActionsFactory implements Factory<UserLinkActions> {
    private final FrontpageViewModule f33563a;
    private final Provider<ListingNavigator> f33564b;
    private final Provider<SessionManager> f33565c;
    private final Provider<AdsNavigator> f33566d;

    private FrontpageViewModule_LinkActionsFactory(FrontpageViewModule frontpageViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        this.f33563a = frontpageViewModule;
        this.f33564b = provider;
        this.f33565c = provider2;
        this.f33566d = provider3;
    }

    public static FrontpageViewModule_LinkActionsFactory m34481a(FrontpageViewModule frontpageViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        return new FrontpageViewModule_LinkActionsFactory(frontpageViewModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (UserLinkActions) Preconditions.m26013a(FrontpageViewModule.m22337a((ListingNavigator) this.f33564b.get(), (SessionManager) this.f33565c.get(), (AdsNavigator) this.f33566d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
