package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.presentation.listing.common.AdsActions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class FrontpageViewModule_AdsActionsFactory implements Factory<AdsActions> {
    private final FrontpageViewModule f33555a;
    private final Provider<FrontpageSettings> f33556b;

    private FrontpageViewModule_AdsActionsFactory(FrontpageViewModule frontpageViewModule, Provider<FrontpageSettings> provider) {
        this.f33555a = frontpageViewModule;
        this.f33556b = provider;
    }

    public static FrontpageViewModule_AdsActionsFactory m34479a(FrontpageViewModule frontpageViewModule, Provider<FrontpageSettings> provider) {
        return new FrontpageViewModule_AdsActionsFactory(frontpageViewModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (AdsActions) Preconditions.m26013a(FrontpageViewModule.m22336a((FrontpageSettings) this.f33556b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
