package com.reddit.frontpage.presentation.onboarding;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.Lazy;

public final class RedditOnboardingNavigator_Factory implements Factory<RedditOnboardingNavigator> {
    private final Provider<Lazy<? extends Context>> f34113a;

    private RedditOnboardingNavigator_Factory(Provider<Lazy<? extends Context>> provider) {
        this.f34113a = provider;
    }

    public static RedditOnboardingNavigator_Factory m34826a(Provider<Lazy<? extends Context>> provider) {
        return new RedditOnboardingNavigator_Factory(provider);
    }

    public final /* synthetic */ Object get() {
        return new RedditOnboardingNavigator((Lazy) this.f34113a.get());
    }
}
