package com.reddit.frontpage.di.module;

import com.reddit.frontpage.domain.repository.AccountRepository;
import com.reddit.frontpage.domain.usecase.AccountUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AccountDataModule_AccountUseCaseFactory implements Factory<AccountUseCase> {
    private final Provider<AccountRepository> f33495a;

    public static AccountUseCase m34444a(AccountRepository accountRepository) {
        return (AccountUseCase) Preconditions.m26013a(AccountDataModule.m22313a(accountRepository), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return (AccountUseCase) Preconditions.m26013a(AccountDataModule.m22313a((AccountRepository) this.f33495a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
