package com.reddit.datalibrary.frontpage.redditauth.account;

import java.util.concurrent.Callable;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "call"}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountUtilKt.kt */
final class AccountUtilKt$fixImproperlyCapitalizedAccounts$2<V> implements Callable<T> {
    public static final AccountUtilKt$fixImproperlyCapitalizedAccounts$2 f10832a = new AccountUtilKt$fixImproperlyCapitalizedAccounts$2();

    AccountUtilKt$fixImproperlyCapitalizedAccounts$2() {
    }

    public final /* synthetic */ Object call() {
        AccountUtilKt$fixImproperlyCapitalizedAccounts$1 accountUtilKt$fixImproperlyCapitalizedAccounts$1 = AccountUtilKt$fixImproperlyCapitalizedAccounts$1.f19462a;
        return Boolean.valueOf(AccountUtilKt$fixImproperlyCapitalizedAccounts$1.m20722a().getBoolean("pref_did_cap_fix", false));
    }
}
