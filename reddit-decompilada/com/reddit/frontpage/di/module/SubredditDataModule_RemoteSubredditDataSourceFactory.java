package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.subreddit.datasource.remote.RemoteSubredditDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class SubredditDataModule_RemoteSubredditDataSourceFactory implements Factory<RemoteSubredditDataSource> {
    private final SubredditDataModule f33660a;
    private final Provider<Retrofit> f33661b;

    private SubredditDataModule_RemoteSubredditDataSourceFactory(SubredditDataModule subredditDataModule, Provider<Retrofit> provider) {
        this.f33660a = subredditDataModule;
        this.f33661b = provider;
    }

    public static SubredditDataModule_RemoteSubredditDataSourceFactory m34531a(SubredditDataModule subredditDataModule, Provider<Retrofit> provider) {
        return new SubredditDataModule_RemoteSubredditDataSourceFactory(subredditDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteSubredditDataSource) Preconditions.m26013a(SubredditDataModule.m22369a((Retrofit) this.f33661b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
