package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.trophies.remote.RemoteTrophiesDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class TrophiesDataModule_RemoteTrophiesDataSourceFactory implements Factory<RemoteTrophiesDataSource> {
    private final TrophiesDataModule f33679a;
    private final Provider<Retrofit> f33680b;

    private TrophiesDataModule_RemoteTrophiesDataSourceFactory(TrophiesDataModule trophiesDataModule, Provider<Retrofit> provider) {
        this.f33679a = trophiesDataModule;
        this.f33680b = provider;
    }

    public static TrophiesDataModule_RemoteTrophiesDataSourceFactory m34539a(TrophiesDataModule trophiesDataModule, Provider<Retrofit> provider) {
        return new TrophiesDataModule_RemoteTrophiesDataSourceFactory(trophiesDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteTrophiesDataSource) Preconditions.m26013a(TrophiesDataModule.m22377a((Retrofit) this.f33680b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
