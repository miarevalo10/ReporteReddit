package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.local.LocalLinkDataSource;
import com.reddit.datalibrary.frontpage.data.feature.link.datasource.remote.RemoteLinkDatasource;
import com.reddit.frontpage.domain.repository.LinkRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class LinkDataModule_ProvideLinkRepositoryFactory implements Factory<LinkRepository> {
    private final LinkDataModule f33584a;
    private final Provider<BackgroundThread> f33585b;
    private final Provider<RemoteLinkDatasource> f33586c;
    private final Provider<LocalLinkDataSource> f33587d;
    private final Provider<LocalLinkDataSource> f33588e;

    private LinkDataModule_ProvideLinkRepositoryFactory(LinkDataModule linkDataModule, Provider<BackgroundThread> provider, Provider<RemoteLinkDatasource> provider2, Provider<LocalLinkDataSource> provider3, Provider<LocalLinkDataSource> provider4) {
        this.f33584a = linkDataModule;
        this.f33585b = provider;
        this.f33586c = provider2;
        this.f33587d = provider3;
        this.f33588e = provider4;
    }

    public static LinkDataModule_ProvideLinkRepositoryFactory m34493a(LinkDataModule linkDataModule, Provider<BackgroundThread> provider, Provider<RemoteLinkDatasource> provider2, Provider<LocalLinkDataSource> provider3, Provider<LocalLinkDataSource> provider4) {
        return new LinkDataModule_ProvideLinkRepositoryFactory(linkDataModule, provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return (LinkRepository) Preconditions.m26013a(LinkDataModule.m22344a((BackgroundThread) this.f33585b.get(), (RemoteLinkDatasource) this.f33586c.get(), (LocalLinkDataSource) this.f33587d.get(), (LocalLinkDataSource) this.f33588e.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
