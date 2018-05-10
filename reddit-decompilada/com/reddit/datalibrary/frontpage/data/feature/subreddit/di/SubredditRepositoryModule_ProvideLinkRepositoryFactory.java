package com.reddit.datalibrary.frontpage.data.feature.subreddit.di;

import com.reddit.datalibrary.frontpage.data.feature.legacy.LegacySubredditRepository;
import com.reddit.datalibrary.frontpage.data.feature.legacy.local.LegacyLocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.LegacyRemoteSubredditDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SubredditRepositoryModule_ProvideLinkRepositoryFactory implements Factory<LegacySubredditRepository> {
    private final SubredditRepositoryModule f18713a;
    private final Provider<LegacyRemoteSubredditDataSource> f18714b;
    private final Provider<LegacyLocalSubredditDataSource> f18715c;

    private SubredditRepositoryModule_ProvideLinkRepositoryFactory(SubredditRepositoryModule subredditRepositoryModule, Provider<LegacyRemoteSubredditDataSource> provider, Provider<LegacyLocalSubredditDataSource> provider2) {
        this.f18713a = subredditRepositoryModule;
        this.f18714b = provider;
        this.f18715c = provider2;
    }

    public static SubredditRepositoryModule_ProvideLinkRepositoryFactory m19696a(SubredditRepositoryModule subredditRepositoryModule, Provider<LegacyRemoteSubredditDataSource> provider, Provider<LegacyLocalSubredditDataSource> provider2) {
        return new SubredditRepositoryModule_ProvideLinkRepositoryFactory(subredditRepositoryModule, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (LegacySubredditRepository) Preconditions.a(SubredditRepositoryModule.m9124a((LegacyRemoteSubredditDataSource) this.f18714b.get(), (LegacyLocalSubredditDataSource) this.f18715c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
