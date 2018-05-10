package com.reddit.frontpage.di.module;

import com.reddit.frontpage.presentation.analytics.CarouselAnalytics;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AnalyticsModule_CarouselAnalyticsFactory implements Factory<CarouselAnalytics> {
    private final AnalyticsModule f33513a;

    private AnalyticsModule_CarouselAnalyticsFactory(AnalyticsModule analyticsModule) {
        this.f33513a = analyticsModule;
    }

    public static AnalyticsModule_CarouselAnalyticsFactory m34455a(AnalyticsModule analyticsModule) {
        return new AnalyticsModule_CarouselAnalyticsFactory(analyticsModule);
    }

    public final /* synthetic */ Object get() {
        return (CarouselAnalytics) Preconditions.m26013a(AnalyticsModule.m22318a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
