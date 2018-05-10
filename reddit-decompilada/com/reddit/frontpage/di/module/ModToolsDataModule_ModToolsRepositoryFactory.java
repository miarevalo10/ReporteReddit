package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.modtools.datasource.RemoteModToolsDataSource;
import com.reddit.frontpage.domain.repository.ModToolsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class ModToolsDataModule_ModToolsRepositoryFactory implements Factory<ModToolsRepository> {
    private final ModToolsDataModule f33604a;
    private final Provider<BackgroundThread> f33605b;
    private final Provider<RemoteModToolsDataSource> f33606c;

    private ModToolsDataModule_ModToolsRepositoryFactory(ModToolsDataModule modToolsDataModule, Provider<BackgroundThread> provider, Provider<RemoteModToolsDataSource> provider2) {
        this.f33604a = modToolsDataModule;
        this.f33605b = provider;
        this.f33606c = provider2;
    }

    public static ModToolsDataModule_ModToolsRepositoryFactory m34502a(ModToolsDataModule modToolsDataModule, Provider<BackgroundThread> provider, Provider<RemoteModToolsDataSource> provider2) {
        return new ModToolsDataModule_ModToolsRepositoryFactory(modToolsDataModule, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (ModToolsRepository) Preconditions.m26013a(ModToolsDataModule.m22348a((BackgroundThread) this.f33605b.get(), (RemoteModToolsDataSource) this.f33606c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
