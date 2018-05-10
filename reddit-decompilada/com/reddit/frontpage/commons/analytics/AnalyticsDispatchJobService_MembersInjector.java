package com.reddit.frontpage.commons.analytics;

import com.reddit.common.rx.BackgroundThread;
import com.reddit.data.events.datasource.local.LocalEventDataSource;
import com.reddit.data.events.datasource.remote.RemoteEventDataSource;
import dagger.MembersInjector;

public final class AnalyticsDispatchJobService_MembersInjector implements MembersInjector<AnalyticsDispatchJobService> {
    public static void m28906a(AnalyticsDispatchJobService analyticsDispatchJobService, BackgroundThread backgroundThread) {
        analyticsDispatchJobService.f27439b = backgroundThread;
    }

    public static void m28907a(AnalyticsDispatchJobService analyticsDispatchJobService, LocalEventDataSource localEventDataSource) {
        analyticsDispatchJobService.f27440c = localEventDataSource;
    }

    public static void m28908a(AnalyticsDispatchJobService analyticsDispatchJobService, RemoteEventDataSource remoteEventDataSource) {
        analyticsDispatchJobService.f27441d = remoteEventDataSource;
    }
}
