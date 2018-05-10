package com.reddit.frontpage.presentation.accounts;

import android.accounts.Account;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.AccountInfo;
import com.reddit.frontpage.presentation.accounts.model.AccountPresentationModel;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/presentation/accounts/model/AccountPresentationModel;", "it", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$AccountInfo;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountPickerPresenter.kt */
final class AccountPickerPresenter$updateAccounts$$inlined$map$lambda$1<T, R> implements Function<T, R> {
    final /* synthetic */ Account f28040a;
    final /* synthetic */ AccountPickerPresenter f28041b;
    final /* synthetic */ Account f28042c;

    AccountPickerPresenter$updateAccounts$$inlined$map$lambda$1(Account account, AccountPickerPresenter accountPickerPresenter, Account account2) {
        this.f28040a = account;
        this.f28041b = accountPickerPresenter;
        this.f28042c = account2;
    }

    public final /* synthetic */ Object apply(Object obj) {
        AccountInfo accountInfo = (AccountInfo) obj;
        Intrinsics.m26847b(accountInfo, "it");
        return new AccountPresentationModel(accountInfo.f20264a.getUsername(), accountInfo.f20265b, Intrinsics.m26845a(this.f28040a, this.f28042c));
    }
}
