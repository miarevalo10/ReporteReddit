package com.reddit.datalibrary.frontpage.data.feature.ads.di;

import com.reddit.datalibrary.frontpage.data.feature.ads.repo.AdsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class AdRepositoryModule_ProvideAdRepositoryFactory implements Factory<AdsRepository> {
    private final AdRepositoryModule f18687a;

    private AdRepositoryModule_ProvideAdRepositoryFactory(AdRepositoryModule adRepositoryModule) {
        this.f18687a = adRepositoryModule;
    }

    public static AdRepositoryModule_ProvideAdRepositoryFactory m19666a(AdRepositoryModule adRepositoryModule) {
        return new AdRepositoryModule_ProvideAdRepositoryFactory(adRepositoryModule);
    }

    public final /* synthetic */ Object get() {
        return (AdsRepository) Preconditions.a(AdRepositoryModule.m8785a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
