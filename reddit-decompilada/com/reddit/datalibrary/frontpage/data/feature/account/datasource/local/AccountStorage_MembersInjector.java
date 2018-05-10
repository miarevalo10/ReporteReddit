package com.reddit.datalibrary.frontpage.data.feature.account.datasource.local;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class AccountStorage_MembersInjector implements MembersInjector<AccountStorage> {
    public static void m15832a(AccountStorage accountStorage, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        accountStorage.f15746a = remoteRedditApiDataSource;
    }
}
