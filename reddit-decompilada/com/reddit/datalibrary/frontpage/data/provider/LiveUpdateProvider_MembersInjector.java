package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class LiveUpdateProvider_MembersInjector implements MembersInjector<LiveUpdateProvider> {
    public static void m16264a(LiveUpdateProvider liveUpdateProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        liveUpdateProvider.f18754c = remoteRedditApiDataSource;
    }
}
