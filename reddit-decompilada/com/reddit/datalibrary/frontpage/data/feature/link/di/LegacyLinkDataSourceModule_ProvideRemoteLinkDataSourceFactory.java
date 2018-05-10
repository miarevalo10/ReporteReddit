package com.reddit.datalibrary.frontpage.data.feature.link.di;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteLinkDataSourceLegacy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class LegacyLinkDataSourceModule_ProvideRemoteLinkDataSourceFactory implements Factory<RemoteLinkDataSourceLegacy> {
    private final LegacyLinkDataSourceModule f18696a;

    private LegacyLinkDataSourceModule_ProvideRemoteLinkDataSourceFactory(LegacyLinkDataSourceModule legacyLinkDataSourceModule) {
        this.f18696a = legacyLinkDataSourceModule;
    }

    public static LegacyLinkDataSourceModule_ProvideRemoteLinkDataSourceFactory m19675a(LegacyLinkDataSourceModule legacyLinkDataSourceModule) {
        return new LegacyLinkDataSourceModule_ProvideRemoteLinkDataSourceFactory(legacyLinkDataSourceModule);
    }

    public final /* synthetic */ Object get() {
        return (RemoteLinkDataSourceLegacy) Preconditions.a(LegacyLinkDataSourceModule.m8974a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
