package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.region.local.LocalRegionDataSource;
import com.reddit.datalibrary.frontpage.data.feature.region.remote.RemoteRegionDataSource;
import com.reddit.frontpage.domain.repository.RegionRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class RegionDataModule_AccountRepositoryFactory implements Factory<RegionRepository> {
    private final RegionDataModule f33644a;
    private final Provider<BackgroundThread> f33645b;
    private final Provider<RemoteRegionDataSource> f33646c;
    private final Provider<LocalRegionDataSource> f33647d;

    private RegionDataModule_AccountRepositoryFactory(RegionDataModule regionDataModule, Provider<BackgroundThread> provider, Provider<RemoteRegionDataSource> provider2, Provider<LocalRegionDataSource> provider3) {
        this.f33644a = regionDataModule;
        this.f33645b = provider;
        this.f33646c = provider2;
        this.f33647d = provider3;
    }

    public static RegionDataModule_AccountRepositoryFactory m34524a(RegionDataModule regionDataModule, Provider<BackgroundThread> provider, Provider<RemoteRegionDataSource> provider2, Provider<LocalRegionDataSource> provider3) {
        return new RegionDataModule_AccountRepositoryFactory(regionDataModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (RegionRepository) Preconditions.m26013a(RegionDataModule.m22364a((BackgroundThread) this.f33645b.get(), (RemoteRegionDataSource) this.f33646c.get(), (LocalRegionDataSource) this.f33647d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
