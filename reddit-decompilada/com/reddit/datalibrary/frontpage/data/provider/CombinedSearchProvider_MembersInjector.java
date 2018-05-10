package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class CombinedSearchProvider_MembersInjector implements MembersInjector<CombinedSearchProvider> {
    public static void m16216a(CombinedSearchProvider combinedSearchProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        combinedSearchProvider.f16224a = remoteRedditApiDataSource;
    }
}
