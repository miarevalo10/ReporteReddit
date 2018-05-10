package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.presentation.listing.common.ListingNavigator;
import com.reddit.frontpage.presentation.listing.common.UserLinkActions;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class HistoryViewModule_LinkActionsFactory implements Factory<UserLinkActions> {
    private final HistoryViewModule f33578a;
    private final Provider<ListingNavigator> f33579b;
    private final Provider<SessionManager> f33580c;
    private final Provider<AdsNavigator> f33581d;

    private HistoryViewModule_LinkActionsFactory(HistoryViewModule historyViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        this.f33578a = historyViewModule;
        this.f33579b = provider;
        this.f33580c = provider2;
        this.f33581d = provider3;
    }

    public static HistoryViewModule_LinkActionsFactory m34491a(HistoryViewModule historyViewModule, Provider<ListingNavigator> provider, Provider<SessionManager> provider2, Provider<AdsNavigator> provider3) {
        return new HistoryViewModule_LinkActionsFactory(historyViewModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (UserLinkActions) Preconditions.m26013a(HistoryViewModule.m22341a((ListingNavigator) this.f33579b.get(), (SessionManager) this.f33580c.get(), (AdsNavigator) this.f33581d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
