package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.local.LocalSubredditDataSource;
import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.remote.RemoteSubredditDataSource;
import com.reddit.frontpage.domain.repository.SubredditRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class SubredditDataModule_SubredditRepositoryFactory implements Factory<SubredditRepository> {
    private final SubredditDataModule f33662a;
    private final Provider<BackgroundThread> f33663b;
    private final Provider<RemoteSubredditDataSource> f33664c;
    private final Provider<LocalSubredditDataSource> f33665d;

    private SubredditDataModule_SubredditRepositoryFactory(SubredditDataModule subredditDataModule, Provider<BackgroundThread> provider, Provider<RemoteSubredditDataSource> provider2, Provider<LocalSubredditDataSource> provider3) {
        this.f33662a = subredditDataModule;
        this.f33663b = provider;
        this.f33664c = provider2;
        this.f33665d = provider3;
    }

    public static SubredditDataModule_SubredditRepositoryFactory m34532a(SubredditDataModule subredditDataModule, Provider<BackgroundThread> provider, Provider<RemoteSubredditDataSource> provider2, Provider<LocalSubredditDataSource> provider3) {
        return new SubredditDataModule_SubredditRepositoryFactory(subredditDataModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (SubredditRepository) Preconditions.m26013a(SubredditDataModule.m22371a((BackgroundThread) this.f33663b.get(), (RemoteSubredditDataSource) this.f33664c.get(), (LocalSubredditDataSource) this.f33665d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
