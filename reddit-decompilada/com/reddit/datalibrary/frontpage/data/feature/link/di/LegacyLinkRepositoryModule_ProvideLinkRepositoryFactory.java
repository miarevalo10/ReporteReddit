package com.reddit.datalibrary.frontpage.data.feature.link.di;

import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LocalLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteLinkDataSourceLegacy;
import com.reddit.datalibrary.frontpage.data.feature.link.repo.LegacyLinkRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class LegacyLinkRepositoryModule_ProvideLinkRepositoryFactory implements Factory<LegacyLinkRepository> {
    private final LegacyLinkRepositoryModule f18697a;
    private final Provider<RemoteLinkDataSourceLegacy> f18698b;
    private final Provider<LocalLinkDataSourceLegacy> f18699c;

    private LegacyLinkRepositoryModule_ProvideLinkRepositoryFactory(LegacyLinkRepositoryModule legacyLinkRepositoryModule, Provider<RemoteLinkDataSourceLegacy> provider, Provider<LocalLinkDataSourceLegacy> provider2) {
        this.f18697a = legacyLinkRepositoryModule;
        this.f18698b = provider;
        this.f18699c = provider2;
    }

    public static LegacyLinkRepositoryModule_ProvideLinkRepositoryFactory m19676a(LegacyLinkRepositoryModule legacyLinkRepositoryModule, Provider<RemoteLinkDataSourceLegacy> provider, Provider<LocalLinkDataSourceLegacy> provider2) {
        return new LegacyLinkRepositoryModule_ProvideLinkRepositoryFactory(legacyLinkRepositoryModule, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (LegacyLinkRepository) Preconditions.a(LegacyLinkRepositoryModule.m8976a((RemoteLinkDataSourceLegacy) this.f18698b.get(), (LocalLinkDataSourceLegacy) this.f18699c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
