package com.reddit.frontpage.di.module;

import android.content.SharedPreferences;
import com.reddit.datalibrary.frontpage.data.feature.search.LocalSearchDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class UserSearchDataModule_LocalSearchDataSourceFactory implements Factory<LocalSearchDataSource> {
    private final UserSearchDataModule f33698a;
    private final Provider<SharedPreferences> f33699b;

    private UserSearchDataModule_LocalSearchDataSourceFactory(UserSearchDataModule userSearchDataModule, Provider<SharedPreferences> provider) {
        this.f33698a = userSearchDataModule;
        this.f33699b = provider;
    }

    public static UserSearchDataModule_LocalSearchDataSourceFactory m34547a(UserSearchDataModule userSearchDataModule, Provider<SharedPreferences> provider) {
        return new UserSearchDataModule_LocalSearchDataSourceFactory(userSearchDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (LocalSearchDataSource) Preconditions.m26013a(UserSearchDataModule.m22383a((SharedPreferences) this.f33699b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
