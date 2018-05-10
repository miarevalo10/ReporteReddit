package com.reddit.datalibrary.frontpage.data.feature.legacy.remote;

import dagger.MembersInjector;

public final class LegacyApiSubredditDataSource_MembersInjector implements MembersInjector<LegacyApiSubredditDataSource> {
    public static void m15953a(LegacyApiSubredditDataSource legacyApiSubredditDataSource, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        legacyApiSubredditDataSource.f15875a = remoteRedditApiDataSource;
    }
}
