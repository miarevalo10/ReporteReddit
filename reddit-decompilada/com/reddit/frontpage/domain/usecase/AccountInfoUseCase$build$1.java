package com.reddit.frontpage.domain.usecase;

import com.reddit.datalibrary.frontpage.data.model.Account;
import com.reddit.frontpage.domain.usecase.AccountInfoUseCase.AccountInfo;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/reddit/frontpage/domain/usecase/AccountInfoUseCase$AccountInfo;", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "apply"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountInfoUseCase.kt */
final class AccountInfoUseCase$build$1<T, R> implements Function<T, R> {
    final /* synthetic */ AccountInfoUseCase f27960a;

    AccountInfoUseCase$build$1(AccountInfoUseCase accountInfoUseCase) {
        this.f27960a = accountInfoUseCase;
    }

    public final /* synthetic */ Object apply(Object obj) {
        Account account = (Account) obj;
        Intrinsics.m26847b(account, "account");
        return new AccountInfo(account, AccountInfoUseCase.m29307a(account));
    }
}
