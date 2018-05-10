package com.reddit.frontpage.sync.routine;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteGatewayDataSource;
import dagger.MembersInjector;

public final class AppConfigSyncRoutine_MembersInjector implements MembersInjector<AppConfigSyncRoutine> {
    public static void m29923a(AppConfigSyncRoutine appConfigSyncRoutine, RemoteGatewayDataSource remoteGatewayDataSource) {
        appConfigSyncRoutine.f28856a = remoteGatewayDataSource;
    }
}
