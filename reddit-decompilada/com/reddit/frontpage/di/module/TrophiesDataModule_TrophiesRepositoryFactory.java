package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.trophies.remote.RemoteTrophiesDataSource;
import com.reddit.frontpage.domain.repository.TrophiesRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class TrophiesDataModule_TrophiesRepositoryFactory implements Factory<TrophiesRepository> {
    private final TrophiesDataModule f33681a;
    private final Provider<BackgroundThread> f33682b;
    private final Provider<RemoteTrophiesDataSource> f33683c;

    private TrophiesDataModule_TrophiesRepositoryFactory(TrophiesDataModule trophiesDataModule, Provider<BackgroundThread> provider, Provider<RemoteTrophiesDataSource> provider2) {
        this.f33681a = trophiesDataModule;
        this.f33682b = provider;
        this.f33683c = provider2;
    }

    public static TrophiesDataModule_TrophiesRepositoryFactory m34540a(TrophiesDataModule trophiesDataModule, Provider<BackgroundThread> provider, Provider<RemoteTrophiesDataSource> provider2) {
        return new TrophiesDataModule_TrophiesRepositoryFactory(trophiesDataModule, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (TrophiesRepository) Preconditions.m26013a(TrophiesDataModule.m22378a((BackgroundThread) this.f33682b.get(), (RemoteTrophiesDataSource) this.f33683c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
