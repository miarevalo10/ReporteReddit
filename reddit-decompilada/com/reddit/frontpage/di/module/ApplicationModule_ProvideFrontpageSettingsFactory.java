package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApplicationModule_ProvideFrontpageSettingsFactory implements Factory<FrontpageSettings> {
    private final ApplicationModule f33522a;

    private ApplicationModule_ProvideFrontpageSettingsFactory(ApplicationModule applicationModule) {
        this.f33522a = applicationModule;
    }

    public static ApplicationModule_ProvideFrontpageSettingsFactory m34463a(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideFrontpageSettingsFactory(applicationModule);
    }

    public final /* synthetic */ Object get() {
        return (FrontpageSettings) Preconditions.m26013a(ApplicationModule.m22326b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
