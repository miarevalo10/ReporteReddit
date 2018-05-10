package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.remote.RemoteKarmaDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class TopKarmaDataModule_RemoteKarmaDataSourceFactory implements Factory<RemoteKarmaDataSource> {
    private final TopKarmaDataModule f33677a;
    private final Provider<Retrofit> f33678b;

    private TopKarmaDataModule_RemoteKarmaDataSourceFactory(TopKarmaDataModule topKarmaDataModule, Provider<Retrofit> provider) {
        this.f33677a = topKarmaDataModule;
        this.f33678b = provider;
    }

    public static TopKarmaDataModule_RemoteKarmaDataSourceFactory m34538a(TopKarmaDataModule topKarmaDataModule, Provider<Retrofit> provider) {
        return new TopKarmaDataModule_RemoteKarmaDataSourceFactory(topKarmaDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteKarmaDataSource) Preconditions.m26013a(TopKarmaDataModule.m22375a((Retrofit) this.f33678b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
