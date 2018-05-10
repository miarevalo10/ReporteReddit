package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.region.remote.RemoteRegionDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class RegionDataModule_RemoteAccountDataSourceFactory implements Factory<RemoteRegionDataSource> {
    private final RegionDataModule f33648a;
    private final Provider<Retrofit> f33649b;

    private RegionDataModule_RemoteAccountDataSourceFactory(RegionDataModule regionDataModule, Provider<Retrofit> provider) {
        this.f33648a = regionDataModule;
        this.f33649b = provider;
    }

    public static RegionDataModule_RemoteAccountDataSourceFactory m34525a(RegionDataModule regionDataModule, Provider<Retrofit> provider) {
        return new RegionDataModule_RemoteAccountDataSourceFactory(regionDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteRegionDataSource) Preconditions.m26013a(RegionDataModule.m22363a((Retrofit) this.f33649b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
