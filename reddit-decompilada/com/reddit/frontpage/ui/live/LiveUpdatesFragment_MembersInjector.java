package com.reddit.frontpage.ui.live;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteWebSocketDataSource;
import dagger.MembersInjector;

public final class LiveUpdatesFragment_MembersInjector implements MembersInjector<LiveUpdatesFragment> {
    public static void m30284a(LiveUpdatesFragment liveUpdatesFragment, RemoteWebSocketDataSource remoteWebSocketDataSource) {
        liveUpdatesFragment.f39238a = remoteWebSocketDataSource;
    }
}
