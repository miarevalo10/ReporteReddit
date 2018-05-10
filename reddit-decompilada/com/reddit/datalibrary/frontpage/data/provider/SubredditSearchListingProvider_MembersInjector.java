package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class SubredditSearchListingProvider_MembersInjector implements MembersInjector<SubredditSearchListingProvider> {
    public static void m16296a(SubredditSearchListingProvider subredditSearchListingProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        subredditSearchListingProvider.f18776d = remoteRedditApiDataSource;
    }
}
