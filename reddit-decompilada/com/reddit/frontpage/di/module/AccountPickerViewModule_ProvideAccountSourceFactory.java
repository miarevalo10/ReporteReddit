package com.reddit.frontpage.di.module;

import android.content.Context;
import com.reddit.frontpage.presentation.accounts.AccountHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class AccountPickerViewModule_ProvideAccountSourceFactory implements Factory<AccountHelper> {
    private final AccountPickerViewModule f33498a;
    private final Provider<Context> f33499b;

    private AccountPickerViewModule_ProvideAccountSourceFactory(AccountPickerViewModule accountPickerViewModule, Provider<Context> provider) {
        this.f33498a = accountPickerViewModule;
        this.f33499b = provider;
    }

    public static AccountPickerViewModule_ProvideAccountSourceFactory m34446a(AccountPickerViewModule accountPickerViewModule, Provider<Context> provider) {
        return new AccountPickerViewModule_ProvideAccountSourceFactory(accountPickerViewModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (AccountHelper) Preconditions.m26013a(AccountPickerViewModule.m22314a((Context) this.f33499b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
