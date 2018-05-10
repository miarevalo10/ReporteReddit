package com.reddit.frontpage.domain.model;

import com.reddit.datalibrary.frontpage.data.model.Account;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/domain/model/AccountSearchResultItem;", "Lcom/reddit/frontpage/domain/model/SearchResultItem;", "account", "Lcom/reddit/datalibrary/frontpage/data/model/Account;", "(Lcom/reddit/datalibrary/frontpage/data/model/Account;)V", "getAccount", "()Lcom/reddit/datalibrary/frontpage/data/model/Account;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: SearchResults.kt */
public final class AccountSearchResultItem extends SearchResultItem {
    private final Account account;

    public static /* synthetic */ AccountSearchResultItem copy$default(AccountSearchResultItem accountSearchResultItem, Account account, int i, Object obj) {
        if ((i & 1) != 0) {
            account = accountSearchResultItem.account;
        }
        return accountSearchResultItem.copy(account);
    }

    public final Account component1() {
        return this.account;
    }

    public final AccountSearchResultItem copy(Account account) {
        Intrinsics.m26847b(account, "account");
        return new AccountSearchResultItem(account);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AccountSearchResultItem) {
                if (Intrinsics.m26845a(this.account, ((AccountSearchResultItem) obj).account)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Account account = this.account;
        return account != null ? account.hashCode() : 0;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AccountSearchResultItem(account=");
        stringBuilder.append(this.account);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public AccountSearchResultItem(Account account) {
        Intrinsics.m26847b(account, "account");
        super();
        this.account = account;
    }

    public final Account getAccount() {
        return this.account;
    }
}
