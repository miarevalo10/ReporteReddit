package com.reddit.datalibrary.frontpage.data.feature.link.di;

import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LocalLinkDataSourceLegacy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class LegacyLinkDataSourceModule_ProvideLocalLinkDataSourceFactory implements Factory<LocalLinkDataSourceLegacy> {
    private final LegacyLinkDataSourceModule f18695a;

    private LegacyLinkDataSourceModule_ProvideLocalLinkDataSourceFactory(LegacyLinkDataSourceModule legacyLinkDataSourceModule) {
        this.f18695a = legacyLinkDataSourceModule;
    }

    public static LegacyLinkDataSourceModule_ProvideLocalLinkDataSourceFactory m19674a(LegacyLinkDataSourceModule legacyLinkDataSourceModule) {
        return new LegacyLinkDataSourceModule_ProvideLocalLinkDataSourceFactory(legacyLinkDataSourceModule);
    }

    public final /* synthetic */ Object get() {
        return (LocalLinkDataSourceLegacy) Preconditions.a(LegacyLinkDataSourceModule.m8975b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
