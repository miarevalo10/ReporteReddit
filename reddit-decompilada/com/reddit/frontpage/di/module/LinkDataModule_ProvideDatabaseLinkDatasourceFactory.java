package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class LinkDataModule_ProvideDatabaseLinkDatasourceFactory implements Factory<LocalLinkDataSource> {
    private final LinkDataModule f33582a;
    private final Provider<Moshi> f33583b;

    private LinkDataModule_ProvideDatabaseLinkDatasourceFactory(LinkDataModule linkDataModule, Provider<Moshi> provider) {
        this.f33582a = linkDataModule;
        this.f33583b = provider;
    }

    public static LinkDataModule_ProvideDatabaseLinkDatasourceFactory m34492a(LinkDataModule linkDataModule, Provider<Moshi> provider) {
        return new LinkDataModule_ProvideDatabaseLinkDatasourceFactory(linkDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (LocalLinkDataSource) Preconditions.m26013a(LinkDataModule.m22342a((Moshi) this.f33583b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
