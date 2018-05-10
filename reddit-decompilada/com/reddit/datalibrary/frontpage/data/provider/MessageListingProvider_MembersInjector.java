package com.reddit.datalibrary.frontpage.data.provider;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class MessageListingProvider_MembersInjector implements MembersInjector<MessageListingProvider> {
    public static void m16275a(MessageListingProvider messageListingProvider, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        messageListingProvider.f18761g = remoteRedditApiDataSource;
    }
}
