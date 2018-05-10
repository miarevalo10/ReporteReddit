package com.reddit.datalibrary.frontpage.redditauth.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.frontpage.util.SessionUtil;
import java.util.ArrayList;

public class AccountUtil {
    private static final Account f10831a = new Account("Reddit for Android", "com.reddit.account");

    public static Account m9165a(Context context, String str) {
        for (Account account : AccountManager.get(context).getAccountsByType("com.reddit.account")) {
            if (account.name.equals(str)) {
                return account;
            }
        }
        return null;
    }

    public static Account m9171b(Context context, String str) {
        context = m9172b(context).iterator();
        while (context.hasNext()) {
            Account account = (Account) context.next();
            String a = m9167a(account.name);
            if (a != null && a.equals(str)) {
                return account;
            }
        }
        return null;
    }

    public static ArrayList<Account> m9172b(Context context) {
        context = AccountManager.get(context).getAccountsByType("com.reddit.account");
        ArrayList<Account> arrayList = new ArrayList();
        for (Account account : context) {
            if (!TextUtils.equals(account.name, "Reddit for Android")) {
                arrayList.add(account);
            }
        }
        return arrayList;
    }

    public static boolean m9169a(Context context, Account account, AccountManagerCallback accountManagerCallback) {
        if (f10831a.equals(account)) {
            return null;
        }
        context = AccountManager.get(context);
        if (VERSION.SDK_INT >= 22) {
            context.removeAccount(account, null, accountManagerCallback, null);
        } else {
            context.removeAccount(account, accountManagerCallback, null);
        }
        return true;
    }

    public static Account m9174d(Context context) {
        return m9165a(context, "Reddit for Android");
    }

    public static boolean m9168a(Account account) {
        return TextUtils.equals(account.name, "Reddit for Android");
    }

    public static Long m9166a(AccountManager accountManager, Account account) {
        accountManager = accountManager.getUserData(account, "expiration");
        return Long.valueOf(TextUtils.isEmpty(accountManager) == null ? Long.parseLong(accountManager) : -1);
    }

    public static boolean m9170a(SessionManager sessionManager) {
        return (sessionManager.m9205d() == null || sessionManager.m9205d().is_suspended == null) ? null : true;
    }

    public static String m9167a(String str) {
        com.reddit.datalibrary.frontpage.requests.models.v1.Account account = (com.reddit.datalibrary.frontpage.requests.models.v1.Account) AccountStorage.f15744b.m8751a(str);
        return (account == null || account.getId() == null) ? null : SessionUtil.a(account.getId());
    }

    public static Account m9164a(Context context) {
        String string = context.getSharedPreferences("com.reddit.auth", 0).getString("username", null);
        if (string == null) {
            return null;
        }
        return m9165a(context, string);
    }

    public static boolean m9173c(Context context) {
        if (m9165a(context, "Reddit for Android") != null) {
            return null;
        }
        return AccountManager.get(context).addAccountExplicitly(new Account("Reddit for Android", "com.reddit.account"), null, null);
    }
}
