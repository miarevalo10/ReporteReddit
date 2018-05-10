package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.search.RemoteSearchDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class SearchDataModule_RemoteFactory implements Factory<RemoteSearchDataSource> {
    private final SearchDataModule f33657a;
    private final Provider<Retrofit> f33658b;

    private SearchDataModule_RemoteFactory(SearchDataModule searchDataModule, Provider<Retrofit> provider) {
        this.f33657a = searchDataModule;
        this.f33658b = provider;
    }

    public static SearchDataModule_RemoteFactory m34529a(SearchDataModule searchDataModule, Provider<Retrofit> provider) {
        return new SearchDataModule_RemoteFactory(searchDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteSearchDataSource) Preconditions.m26013a(SearchDataModule.m22368a((Retrofit) this.f33658b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
