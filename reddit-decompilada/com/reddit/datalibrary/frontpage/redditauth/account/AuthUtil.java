package com.reddit.datalibrary.frontpage.redditauth.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import com.reddit.datalibrary.frontpage.redditauth.models.Scope;
import com.reddit.frontpage.redditauth_private.account.Credentials;
import com.reddit.frontpage.util.URLEncoder;
import java.io.UnsupportedEncodingException;
import timber.log.Timber;

public class AuthUtil {
    public static String m9179a(String str, String str2) {
        str2 = String.format("%s:%s", new Object[]{str, str2});
        return String.format("Basic %s", new Object[]{Base64.encodeToString(str2.getBytes(), 2)});
    }

    public static String m9178a(String str) throws UnsupportedEncodingException {
        return String.format("reddit_session=%s", new Object[]{URLEncoder.a(str, "UTF-8")});
    }

    public static Account m9177a(Context context, String str, Scope scope, Credentials credentials) {
        context = AccountManager.get(context);
        Account account = new Account(str, "com.reddit.account");
        str = new Bundle();
        str.putString("com.reddit.cookie", credentials.a);
        str.putString("com.reddit.modhash", credentials.b);
        str.putString("com.reddit.refresh_token", credentials.d);
        if (context.addAccountExplicitly(account, null, str) == null) {
            context.setUserData(account, "com.reddit.cookie", credentials.a);
            context.setUserData(account, "com.reddit.modhash", credentials.b);
            context.setUserData(account, "com.reddit.refresh_token", credentials.d);
        }
        context.setAuthToken(account, scope.toString(), credentials.c);
        Timber.b("stored cookie=%s modhash=%s", new Object[]{credentials.a, credentials.b});
        return account;
    }
}
