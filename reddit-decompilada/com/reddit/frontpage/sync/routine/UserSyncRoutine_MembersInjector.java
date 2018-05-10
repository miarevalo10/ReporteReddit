package com.reddit.frontpage.sync.routine;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class UserSyncRoutine_MembersInjector implements MembersInjector<UserSyncRoutine> {
    public static void m29930a(UserSyncRoutine userSyncRoutine, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        userSyncRoutine.f28862a = remoteRedditApiDataSource;
    }
}
