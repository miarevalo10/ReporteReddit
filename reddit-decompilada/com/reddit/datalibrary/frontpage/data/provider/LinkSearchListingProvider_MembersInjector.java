package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class LinkSearchListingProvider_MembersInjector implements MembersInjector<LinkSearchListingProvider> {
    public static void m16263a(LinkSearchListingProvider linkSearchListingProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        linkSearchListingProvider.f18749g = remoteRedditApiDataSource;
    }
}
