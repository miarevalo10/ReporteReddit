package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.local.LocalKarmaDataSource;
import com.reddit.datalibrary.frontpage.data.feature.karma.datasource.remote.RemoteKarmaDataSource;
import com.reddit.frontpage.domain.repository.KarmaRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class TopKarmaDataModule_KarmaRepositoryFactory implements Factory<KarmaRepository> {
    private final TopKarmaDataModule f33673a;
    private final Provider<BackgroundThread> f33674b;
    private final Provider<RemoteKarmaDataSource> f33675c;
    private final Provider<LocalKarmaDataSource> f33676d;

    private TopKarmaDataModule_KarmaRepositoryFactory(TopKarmaDataModule topKarmaDataModule, Provider<BackgroundThread> provider, Provider<RemoteKarmaDataSource> provider2, Provider<LocalKarmaDataSource> provider3) {
        this.f33673a = topKarmaDataModule;
        this.f33674b = provider;
        this.f33675c = provider2;
        this.f33676d = provider3;
    }

    public static TopKarmaDataModule_KarmaRepositoryFactory m34537a(TopKarmaDataModule topKarmaDataModule, Provider<BackgroundThread> provider, Provider<RemoteKarmaDataSource> provider2, Provider<LocalKarmaDataSource> provider3) {
        return new TopKarmaDataModule_KarmaRepositoryFactory(topKarmaDataModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (KarmaRepository) Preconditions.m26013a(TopKarmaDataModule.m22376a((BackgroundThread) this.f33674b.get(), (RemoteKarmaDataSource) this.f33675c.get(), (LocalKarmaDataSource) this.f33676d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
