package com.reddit.datalibrary.frontpage.data.feature.legacy;

import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LegacyLocalSubredditDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class C1687x8b8952c8 implements Factory<LegacyLocalSubredditDataSource> {
    private final LegacySubredditDataSourceModule f18691a;

    private C1687x8b8952c8(LegacySubredditDataSourceModule legacySubredditDataSourceModule) {
        this.f18691a = legacySubredditDataSourceModule;
    }

    public static C1687x8b8952c8 m19671a(LegacySubredditDataSourceModule legacySubredditDataSourceModule) {
        return new C1687x8b8952c8(legacySubredditDataSourceModule);
    }

    public final /* synthetic */ Object get() {
        return (LegacyLocalSubredditDataSource) Preconditions.a(LegacySubredditDataSourceModule.m8846b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
