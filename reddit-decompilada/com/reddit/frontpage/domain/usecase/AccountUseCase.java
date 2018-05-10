package com.reddit.frontpage.domain.usecase;

import com.reddit.frontpage.domain.repository.AccountRepository;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/reddit/frontpage/domain/usecase/AccountUseCase;", "", "accountRepository", "Lcom/reddit/frontpage/domain/repository/AccountRepository;", "(Lcom/reddit/frontpage/domain/repository/AccountRepository;)V", "getAccountRepository", "()Lcom/reddit/frontpage/domain/repository/AccountRepository;", "getAccount", "Lio/reactivex/Observable;", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "username", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountUseCase.kt */
public final class AccountUseCase {
    public final AccountRepository f20266a;

    @Inject
    public AccountUseCase(AccountRepository accountRepository) {
        Intrinsics.m26847b(accountRepository, "accountRepository");
        this.f20266a = accountRepository;
    }
}
