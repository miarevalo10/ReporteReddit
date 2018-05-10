package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.RemoteLinkDatasource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class LinkDataModule_ProvideRemoteLinkDatasourceFactory implements Factory<RemoteLinkDatasource> {
    private final LinkDataModule f33589a;
    private final Provider<Retrofit> f33590b;

    private LinkDataModule_ProvideRemoteLinkDatasourceFactory(LinkDataModule linkDataModule, Provider<Retrofit> provider) {
        this.f33589a = linkDataModule;
        this.f33590b = provider;
    }

    public static LinkDataModule_ProvideRemoteLinkDatasourceFactory m34494a(LinkDataModule linkDataModule, Provider<Retrofit> provider) {
        return new LinkDataModule_ProvideRemoteLinkDatasourceFactory(linkDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteLinkDatasource) Preconditions.m26013a(LinkDataModule.m22343a((Retrofit) this.f33590b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
