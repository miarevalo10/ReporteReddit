package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.presentation.listing.common.AdsActions;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class PopularViewModule_AdsActionsFactory implements Factory<AdsActions> {
    private final PopularViewModule f33638a;
    private final Provider<FrontpageSettings> f33639b;

    private PopularViewModule_AdsActionsFactory(PopularViewModule popularViewModule, Provider<FrontpageSettings> provider) {
        this.f33638a = popularViewModule;
        this.f33639b = provider;
    }

    public static PopularViewModule_AdsActionsFactory m34522a(PopularViewModule popularViewModule, Provider<FrontpageSettings> provider) {
        return new PopularViewModule_AdsActionsFactory(popularViewModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (AdsActions) Preconditions.m26013a(PopularViewModule.m22361a((FrontpageSettings) this.f33639b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
