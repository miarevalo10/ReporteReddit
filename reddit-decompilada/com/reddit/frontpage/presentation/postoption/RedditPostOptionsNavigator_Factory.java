package com.reddit.frontpage.presentation.postoption;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Lazy;

public final class RedditPostOptionsNavigator_Factory implements Factory<RedditPostOptionsNavigator> {
    private final Provider<Lazy<? extends Context>> f34144a;

    private RedditPostOptionsNavigator_Factory(Provider<Lazy<? extends Context>> provider) {
        this.f34144a = provider;
    }

    public static RedditPostOptionsNavigator_Factory m34866a(Provider<Lazy<? extends Context>> provider) {
        return new RedditPostOptionsNavigator_Factory(provider);
    }

    public final /* synthetic */ Object get() {
        return new RedditPostOptionsNavigator((Lazy) this.f34144a.get());
    }
}
