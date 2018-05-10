package com.reddit.datalibrary.frontpage.redditauth.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/reddit/datalibrary/frontpage/redditauth/account/AccountUtilKt;", "", "()V", "PREF_DID_CAPITALIZATION_FIX", "", "fixImproperlyCapitalizedAccount", "", "properName", "fixImproperlyCapitalizedAccounts", "Lio/reactivex/Completable;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: AccountUtilKt.kt */
public final class AccountUtilKt {
    public static final AccountUtilKt f10833a = new AccountUtilKt();

    private AccountUtilKt() {
    }

    public static final Completable m9175a() {
        AccountUtilKt$fixImproperlyCapitalizedAccounts$1 accountUtilKt$fixImproperlyCapitalizedAccounts$1 = AccountUtilKt$fixImproperlyCapitalizedAccounts$1.f19462a;
        Completable flatMapCompletable = Single.fromCallable(AccountUtilKt$fixImproperlyCapitalizedAccounts$2.f10832a).flatMapCompletable(AccountUtilKt$fixImproperlyCapitalizedAccounts$3.f16286a);
        Intrinsics.a(flatMapCompletable, "Single.fromCallable {\n  …      }\n          }\n    }");
        return flatMapCompletable;
    }

    public static final void m9176a(String str) {
        boolean z;
        Intrinsics.b(str, "properName");
        AccountManager accountManager = AccountManager.get(FrontpageApplication.a);
        ArrayList b = AccountUtil.m9172b(FrontpageApplication.a);
        Intrinsics.a(b, "accounts");
        Iterable<Account> iterable = b;
        if (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty())) {
            for (Account account : iterable) {
                if (Intrinsics.a(account.name, str)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            Account account2 = (Account) next;
            boolean z2 = StringsKt.a(account2.name, str, true) && !StringsKt.a(account2.name, str, false);
            if (z2) {
                arrayList.add(next);
            }
        }
        for (Account account3 : (List) arrayList) {
            if (z) {
                StringBuilder stringBuilder = new StringBuilder("Removing improperly capitalized account ");
                stringBuilder.append(account3);
                stringBuilder.append(", should be ");
                stringBuilder.append(str);
                Timber.c(stringBuilder.toString(), new Object[0]);
                AccountUtil.m9169a(FrontpageApplication.a, account3, null);
            } else {
                StringBuilder stringBuilder2 = new StringBuilder("Renaming improperly capitalized account ");
                stringBuilder2.append(account3);
                stringBuilder2.append(" to ");
                stringBuilder2.append(str);
                Timber.c(stringBuilder2.toString(), new Object[0]);
                accountManager.renameAccount(account3, str, null, null);
                z = true;
            }
        }
    }
}
