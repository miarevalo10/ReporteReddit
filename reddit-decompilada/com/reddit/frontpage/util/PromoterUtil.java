package com.reddit.frontpage.util;

import com.reddit.datalibrary.frontpage.data.feature.account.datasource.local.AccountStorage;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.datalibrary.frontpage.requests.models.v1.Subreddit;

public class PromoterUtil {
    public static Subreddit m23871a() {
        Account account = (Account) AccountStorage.b.a(SessionManager.b().c.getUsername());
        if (account == null) {
            return null;
        }
        return account.subreddit;
    }
}
