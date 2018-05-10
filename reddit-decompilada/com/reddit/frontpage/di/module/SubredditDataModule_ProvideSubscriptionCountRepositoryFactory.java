package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.subreddit.repo.SubscriptionCountRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class SubredditDataModule_ProvideSubscriptionCountRepositoryFactory implements Factory<SubscriptionCountRepository> {
    private final SubredditDataModule f33659a;

    private SubredditDataModule_ProvideSubscriptionCountRepositoryFactory(SubredditDataModule subredditDataModule) {
        this.f33659a = subredditDataModule;
    }

    public static SubredditDataModule_ProvideSubscriptionCountRepositoryFactory m34530a(SubredditDataModule subredditDataModule) {
        return new SubredditDataModule_ProvideSubscriptionCountRepositoryFactory(subredditDataModule);
    }

    public final /* synthetic */ Object get() {
        return (SubscriptionCountRepository) Preconditions.m26013a(SubredditDataModule.m22370a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
