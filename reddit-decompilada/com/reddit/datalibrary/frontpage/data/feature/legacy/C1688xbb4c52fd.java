package com.reddit.datalibrary.frontpage.data.feature.legacy;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyRemoteSubredditDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class C1688xbb4c52fd implements Factory<LegacyRemoteSubredditDataSource> {
    private final LegacySubredditDataSourceModule f18692a;

    private C1688xbb4c52fd(LegacySubredditDataSourceModule legacySubredditDataSourceModule) {
        this.f18692a = legacySubredditDataSourceModule;
    }

    public static C1688xbb4c52fd m19672a(LegacySubredditDataSourceModule legacySubredditDataSourceModule) {
        return new C1688xbb4c52fd(legacySubredditDataSourceModule);
    }

    public final /* synthetic */ Object get() {
        return (LegacyRemoteSubredditDataSource) Preconditions.a(LegacySubredditDataSourceModule.m8845a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
