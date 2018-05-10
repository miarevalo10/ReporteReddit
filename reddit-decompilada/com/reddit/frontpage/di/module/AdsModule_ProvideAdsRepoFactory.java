package com.reddit.frontpage.di.module;

import android.content.Context;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsLoaderFactory;
import com.reddit.datalibrary.frontpage.data.feature.settings.FrontpageSettings;
import com.reddit.frontpage.domain.repository.AdsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AdsModule_ProvideAdsRepoFactory implements Factory<AdsRepository> {
    private final AdsModule f33507a;
    private final Provider<FrontpageSettings> f33508b;
    private final Provider<Context> f33509c;
    private final Provider<BackgroundThread> f33510d;
    private final Provider<AdsLoaderFactory> f33511e;

    private AdsModule_ProvideAdsRepoFactory(AdsModule adsModule, Provider<FrontpageSettings> provider, Provider<Context> provider2, Provider<BackgroundThread> provider3, Provider<AdsLoaderFactory> provider4) {
        this.f33507a = adsModule;
        this.f33508b = provider;
        this.f33509c = provider2;
        this.f33510d = provider3;
        this.f33511e = provider4;
    }

    public static AdsModule_ProvideAdsRepoFactory m34453a(AdsModule adsModule, Provider<FrontpageSettings> provider, Provider<Context> provider2, Provider<BackgroundThread> provider3, Provider<AdsLoaderFactory> provider4) {
        return new AdsModule_ProvideAdsRepoFactory(adsModule, provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return (AdsRepository) Preconditions.m26013a(AdsModule.m22317a((FrontpageSettings) this.f33508b.get(), (Context) this.f33509c.get(), (BackgroundThread) this.f33510d.get(), (AdsLoaderFactory) this.f33511e.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
