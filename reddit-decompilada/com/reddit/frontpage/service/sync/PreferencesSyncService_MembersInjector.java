package com.reddit.frontpage.service.sync;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class PreferencesSyncService_MembersInjector implements MembersInjector<PreferencesSyncService> {
    public static void m29917a(PreferencesSyncService preferencesSyncService, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        preferencesSyncService.f21040a = remoteRedditApiDataSource;
    }
}
