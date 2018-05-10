package com.reddit.datalibrary.frontpage.redditauth.account;

import com.reddit.datalibrary.frontpage.data.model.Account;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty1;

@Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
/* compiled from: AccountUtilKt.kt */
final class AccountUtilKt$fixImproperlyCapitalizedAccounts$3$2$1 extends PropertyReference1 {
    public static final KProperty1 f19773a = new AccountUtilKt$fixImproperlyCapitalizedAccounts$3$2$1();

    AccountUtilKt$fixImproperlyCapitalizedAccounts$3$2$1() {
    }

    public final KDeclarationContainer m21383a() {
        return Reflection.a(Account.class);
    }

    public final String m21385b() {
        return "username";
    }

    public final String m21386c() {
        return "getUsername()Ljava/lang/String;";
    }

    public final Object m21384b(Object obj) {
        return ((Account) obj).getUsername();
    }
}
