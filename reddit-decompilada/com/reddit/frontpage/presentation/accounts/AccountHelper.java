package com.reddit.frontpage.presentation.accounts;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/reddit/frontpage/presentation/accounts/AccountHelper;", "", "accounts", "", "Landroid/accounts/Account;", "getAccounts", "()Ljava/util/List;", "activeAccount", "getActiveAccount", "()Landroid/accounts/Account;", "login", "", "username", "", "remove", "callback", "Landroid/accounts/AccountManagerCallback;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountHelper.kt */
public interface AccountHelper {
    List<Account> mo4767a();

    boolean mo4768a(String str);

    boolean mo4769a(String str, AccountManagerCallback<?> accountManagerCallback);

    Account mo4770b();
}
