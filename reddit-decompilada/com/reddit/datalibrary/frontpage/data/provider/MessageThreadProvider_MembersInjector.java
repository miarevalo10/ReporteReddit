package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class MessageThreadProvider_MembersInjector implements MembersInjector<MessageThreadProvider> {
    public static void m16280a(MessageThreadProvider messageThreadProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        messageThreadProvider.f16268a = remoteRedditApiDataSource;
    }
}
