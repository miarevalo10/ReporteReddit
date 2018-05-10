package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.repository.AccountRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AccountInfoUseCase_Factory implements Factory<AccountInfoUseCase> {
    private final Provider<AccountRepository> f33714a;

    private AccountInfoUseCase_Factory(Provider<AccountRepository> provider) {
        this.f33714a = provider;
    }

    public static AccountInfoUseCase_Factory m34554a(Provider<AccountRepository> provider) {
        return new AccountInfoUseCase_Factory(provider);
    }

    public final /* synthetic */ Object get() {
        return new AccountInfoUseCase((AccountRepository) this.f33714a.get());
    }
}
