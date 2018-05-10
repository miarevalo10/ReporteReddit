package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.account.datasource.remote.RemoteAccountDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class AccountDataModule_RemoteAccountDataSourceFactory implements Factory<RemoteAccountDataSource> {
    private final AccountDataModule f33496a;
    private final Provider<Retrofit> f33497b;

    private AccountDataModule_RemoteAccountDataSourceFactory(AccountDataModule accountDataModule, Provider<Retrofit> provider) {
        this.f33496a = accountDataModule;
        this.f33497b = provider;
    }

    public static AccountDataModule_RemoteAccountDataSourceFactory m34445a(AccountDataModule accountDataModule, Provider<Retrofit> provider) {
        return new AccountDataModule_RemoteAccountDataSourceFactory(accountDataModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteAccountDataSource) Preconditions.m26013a(AccountDataModule.m22311a((Retrofit) this.f33497b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
