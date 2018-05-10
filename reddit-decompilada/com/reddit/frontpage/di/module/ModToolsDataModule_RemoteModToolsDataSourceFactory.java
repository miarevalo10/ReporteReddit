package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.modtools.datasource.RemoteModToolsDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class ModToolsDataModule_RemoteModToolsDataSourceFactory implements Factory<RemoteModToolsDataSource> {
    private final ModToolsDataModule f33607a;
    private final Provider<Retrofit> f33608b;

    private ModToolsDataModule_RemoteModToolsDataSourceFactory(ModToolsDataModule modToolsDataModule, Provider<Retrofit> provider) {
        this.f33607a = modToolsDataModule;
        this.f33608b = provider;
    }

    public static ModToolsDataModule_RemoteModToolsDataSourceFactory m34503a(ModToolsDataModule modToolsDataModule, Provider<Retrofit> provider) {
        return new ModToolsDataModule_RemoteModToolsDataSourceFactory(modToolsDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteModToolsDataSource) Preconditions.m26013a(ModToolsDataModule.m22347a((Retrofit) this.f33608b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
