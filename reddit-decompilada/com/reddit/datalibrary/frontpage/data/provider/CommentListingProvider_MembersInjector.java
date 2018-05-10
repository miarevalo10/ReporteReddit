package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class CommentListingProvider_MembersInjector implements MembersInjector<CommentListingProvider> {
    public static void m16217a(CommentListingProvider commentListingProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        commentListingProvider.f18725c = remoteRedditApiDataSource;
    }
}
