package com.reddit.frontpage.presentation.accounts;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase;
import com.reddit.frontpage.presentation.accounts.AccountPickerContract.View;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AccountPickerPresenter_Factory implements Factory<AccountPickerPresenter> {
    private final Provider<BackgroundThread> f33775a;
    private final Provider<AccountHelper> f33776b;
    private final Provider<AccountInfoUseCase> f33777c;
    private final Provider<View> f33778d;

    private AccountPickerPresenter_Factory(Provider<BackgroundThread> provider, Provider<AccountHelper> provider2, Provider<AccountInfoUseCase> provider3, Provider<View> provider4) {
        this.f33775a = provider;
        this.f33776b = provider2;
        this.f33777c = provider3;
        this.f33778d = provider4;
    }

    public static AccountPickerPresenter_Factory m34573a(Provider<BackgroundThread> provider, Provider<AccountHelper> provider2, Provider<AccountInfoUseCase> provider3, Provider<View> provider4) {
        return new AccountPickerPresenter_Factory(provider, provider2, provider3, provider4);
    }

    public final /* synthetic */ Object get() {
        return new AccountPickerPresenter((BackgroundThread) this.f33775a.get(), (AccountHelper) this.f33776b.get(), (AccountInfoUseCase) this.f33777c.get(), (View) this.f33778d.get());
    }
}
