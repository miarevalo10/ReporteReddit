package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class FlairProvider_MembersInjector implements MembersInjector<FlairProvider> {
    public static void m16244a(FlairProvider flairProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        flairProvider.f16237a = remoteRedditApiDataSource;
    }
}
