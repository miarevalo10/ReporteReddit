package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsLoaderFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AdsModule_ProvideAdsLoaderFactoryFactory implements Factory<AdsLoaderFactory> {
    private final AdsModule f33506a;

    private AdsModule_ProvideAdsLoaderFactoryFactory(AdsModule adsModule) {
        this.f33506a = adsModule;
    }

    public static AdsModule_ProvideAdsLoaderFactoryFactory m34452a(AdsModule adsModule) {
        return new AdsModule_ProvideAdsLoaderFactoryFactory(adsModule);
    }

    public final /* synthetic */ Object get() {
        return (AdsLoaderFactory) Preconditions.m26013a(AdsModule.m22316a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
