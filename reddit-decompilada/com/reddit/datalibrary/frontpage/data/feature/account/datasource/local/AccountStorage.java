package com.reddit.datalibrary.frontpage.data.feature.account.datasource.local;

import android.content.Context;
import com.reddit.datalibrary.frontpage.data.common.BasePersistentKVStorage;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.requests.models.v1.Account;
import com.reddit.frontpage.FrontpageApplication;
import java.lang.reflect.Type;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import timber.log.Timber;

public class AccountStorage extends BasePersistentKVStorage<Account> {
    public static final AccountStorage f15744b = new AccountStorage(FrontpageApplication.a);
    private static final Object f15745c = new Object();
    @Inject
    RemoteRedditApiDataSource f15746a;

    public final String mo2911a() {
        return "com.reddit.storage.account";
    }

    private AccountStorage(Context context) {
        super(context);
        FrontpageApplication.m().a(this);
    }

    public final Type mo2912b() {
        return Account.class;
    }

    public final Account m15829a(Session session) throws ExecutionException, InterruptedException {
        Account account = (Account) m8751a(session.getUsername());
        if (account == null) {
            synchronized (f15745c) {
                account = (Account) m8751a(session.getUsername());
                if (account == null) {
                    try {
                        Account account2 = (Account) RemoteRedditApiDataSource.m8912c().blockingGet();
                        if (account2.is_employee) {
                            account2.gold_creddits = 50;
                        }
                        m8753a(session.getUsername(), account2);
                        account = account2;
                    } catch (Session session2) {
                        Timber.c(session2, "AccountStorage.forceGet", new Object[0]);
                        return account;
                    }
                }
            }
        }
        return account;
    }
}
