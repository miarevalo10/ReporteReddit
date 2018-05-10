package com.reddit.frontpage.di.module;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.LocalAccountDataSource;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.remote.RemoteAccountDataSource;
import com.reddit.frontpage.domain.repository.AccountRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AccountDataModule_AccountRepositoryFactory implements Factory<AccountRepository> {
    private final AccountDataModule f33491a;
    private final Provider<BackgroundThread> f33492b;
    private final Provider<RemoteAccountDataSource> f33493c;
    private final Provider<LocalAccountDataSource> f33494d;

    private AccountDataModule_AccountRepositoryFactory(AccountDataModule accountDataModule, Provider<BackgroundThread> provider, Provider<RemoteAccountDataSource> provider2, Provider<LocalAccountDataSource> provider3) {
        this.f33491a = accountDataModule;
        this.f33492b = provider;
        this.f33493c = provider2;
        this.f33494d = provider3;
    }

    public static AccountDataModule_AccountRepositoryFactory m34443a(AccountDataModule accountDataModule, Provider<BackgroundThread> provider, Provider<RemoteAccountDataSource> provider2, Provider<LocalAccountDataSource> provider3) {
        return new AccountDataModule_AccountRepositoryFactory(accountDataModule, provider, provider2, provider3);
    }

    public final /* synthetic */ Object get() {
        return (AccountRepository) Preconditions.m26013a(AccountDataModule.m22312a((BackgroundThread) this.f33492b.get(), (RemoteAccountDataSource) this.f33493c.get(), (LocalAccountDataSource) this.f33494d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
