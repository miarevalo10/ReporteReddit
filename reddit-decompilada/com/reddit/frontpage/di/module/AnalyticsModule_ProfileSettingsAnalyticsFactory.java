package com.reddit.frontpage.di.module;

import com.reddit.frontpage.ui.profile.profilesettings.analytics.ProfileSettingsAnalyticsContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AnalyticsModule_ProfileSettingsAnalyticsFactory implements Factory<ProfileSettingsAnalyticsContract> {
    private final AnalyticsModule f33514a;

    private AnalyticsModule_ProfileSettingsAnalyticsFactory(AnalyticsModule analyticsModule) {
        this.f33514a = analyticsModule;
    }

    public static AnalyticsModule_ProfileSettingsAnalyticsFactory m34456a(AnalyticsModule analyticsModule) {
        return new AnalyticsModule_ProfileSettingsAnalyticsFactory(analyticsModule);
    }

    public final /* synthetic */ Object get() {
        return (ProfileSettingsAnalyticsContract) Preconditions.m26013a(AnalyticsModule.m22319b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
