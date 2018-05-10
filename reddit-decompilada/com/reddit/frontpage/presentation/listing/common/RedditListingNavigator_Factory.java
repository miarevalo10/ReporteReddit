package com.reddit.frontpage.presentation.listing.common;

import android.content.Context;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.frontpage.ui.listing.adapter.ads.AdsNavigator;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Lazy;

public final class RedditListingNavigator_Factory implements Factory<RedditListingNavigator> {
    private final Provider<Lazy<? extends Context>> f33890a;
    private final Provider<String> f33891b;
    private final Provider<SessionManager> f33892c;
    private final Provider<AdsNavigator> f33893d;

    private RedditListingNavigator_Factory(Provider<Lazy<? extends Context>> provider, Provider<String> provider2, Provider<SessionManager> provider3, Provider<AdsNavigator> provider4) {
        this.f33890a = provider;
        this.f33891b = provider2;
        this.f33892c = provider3;
        this.f33893d = provider4;
    }

    public static RedditListingNavigator_Factory m34712a(Provider<Lazy<? extends Context>> provider, Provider<String> provider2, Provider<SessionManager> provider3, Provider<AdsNavigator> provider4) {
        return new RedditListingNavigator_Factory(provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return new RedditListingNavigator((Lazy) this.f33890a.get(), (String) this.f33891b.get(), (SessionManager) this.f33892c.get(), (AdsNavigator) this.f33893d.get());
    }
}
