package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.search.LocalSearchDataSource;
import com.reddit.datalibrary.frontpage.data.feature.search.RemoteSearchDataSource;
import com.reddit.frontpage.domain.repository.SearchRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class UserSearchDataModule_SearchRepositoryFactory implements Factory<SearchRepository> {
    private final UserSearchDataModule f33700a;
    private final Provider<BackgroundThread> f33701b;
    private final Provider<RemoteSearchDataSource> f33702c;
    private final Provider<LocalSearchDataSource> f33703d;

    private UserSearchDataModule_SearchRepositoryFactory(UserSearchDataModule userSearchDataModule, Provider<BackgroundThread> provider, Provider<RemoteSearchDataSource> provider2, Provider<LocalSearchDataSource> provider3) {
        this.f33700a = userSearchDataModule;
        this.f33701b = provider;
        this.f33702c = provider2;
        this.f33703d = provider3;
    }

    public static UserSearchDataModule_SearchRepositoryFactory m34548a(UserSearchDataModule userSearchDataModule, Provider<BackgroundThread> provider, Provider<RemoteSearchDataSource> provider2, Provider<LocalSearchDataSource> provider3) {
        return new UserSearchDataModule_SearchRepositoryFactory(userSearchDataModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (SearchRepository) Preconditions.m26013a(UserSearchDataModule.m22384a((BackgroundThread) this.f33701b.get(), (RemoteSearchDataSource) this.f33702c.get(), (LocalSearchDataSource) this.f33703d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
