package com.reddit.frontpage.di.module;

import android.app.Activity;
import com.reddit.frontpage.ui.listing.adapter.ads.AdVisibilityTracker;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.Lazy;

public final class AdsAnalyticsModule_AdsVisibilityTrackerFactory implements Factory<AdVisibilityTracker> {
    private final AdsAnalyticsModule f33504a;
    private final Provider<Lazy<? extends Activity>> f33505b;

    private AdsAnalyticsModule_AdsVisibilityTrackerFactory(AdsAnalyticsModule adsAnalyticsModule, Provider<Lazy<? extends Activity>> provider) {
        this.f33504a = adsAnalyticsModule;
        this.f33505b = provider;
    }

    public static AdsAnalyticsModule_AdsVisibilityTrackerFactory m34451a(AdsAnalyticsModule adsAnalyticsModule, Provider<Lazy<? extends Activity>> provider) {
        return new AdsAnalyticsModule_AdsVisibilityTrackerFactory(adsAnalyticsModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (AdVisibilityTracker) Preconditions.m26013a(AdsAnalyticsModule.m22315a((Lazy) this.f33505b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
