package com.reddit.frontpage.presentation.accounts;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/accounts/AccountManagerFuture;", "", "kotlin.jvm.PlatformType", "run"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountPickerPresenter.kt */
final class AccountPickerPresenter$removeAccount$1<V> implements AccountManagerCallback<Object> {
    final /* synthetic */ AccountPickerPresenter f20315a;

    AccountPickerPresenter$removeAccount$1(AccountPickerPresenter accountPickerPresenter) {
        this.f20315a = accountPickerPresenter;
    }

    public final void run(AccountManagerFuture<Object> accountManagerFuture) {
        if (this.f20315a.f28044a.mo4767a().isEmpty() != null) {
            this.f20315a.f28045b.m22639b();
        } else {
            this.f20315a.m29369a();
        }
    }
}
