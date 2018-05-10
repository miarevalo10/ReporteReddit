package com.reddit.frontpage.ui.inbox;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteGatewayDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.MembersInjector;

public final class InboxPagerScreen_MembersInjector implements MembersInjector<InboxPagerScreen> {
    public static void m30064a(InboxPagerScreen inboxPagerScreen, RemoteRedditApiDataSource remoteRedditApiDataSource) {
        inboxPagerScreen.f39188v = remoteRedditApiDataSource;
    }

    public static void m30063a(InboxPagerScreen inboxPagerScreen, RemoteGatewayDataSource remoteGatewayDataSource) {
        inboxPagerScreen.f39189w = remoteGatewayDataSource;
    }
}
