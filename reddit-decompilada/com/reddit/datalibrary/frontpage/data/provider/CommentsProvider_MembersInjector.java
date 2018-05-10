package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteWebSocketDataSource;
import dagger.MembersInjector;

public final class CommentsProvider_MembersInjector implements MembersInjector<CommentsProvider> {
    public static void m16240a(CommentsProvider commentsProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        commentsProvider.f16229b = remoteRedditApiDataSource;
    }

    public static void m16241a(CommentsProvider commentsProvider, RemoteWebSocketDataSource remoteWebSocketDataSource) {
        commentsProvider.f16230c = remoteWebSocketDataSource;
    }
}
