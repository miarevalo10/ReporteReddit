package com.reddit.frontpage.commons.analytics.output;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.reddit.common.rx.BackgroundThread;
import com.reddit.data.events.datasource.local.LocalEventDataSource;
import dagger.MembersInjector;

public final class ThriftOutput_MembersInjector implements MembersInjector<ThriftOutput> {
    public static void m28975a(ThriftOutput thriftOutput, FirebaseJobDispatcher firebaseJobDispatcher) {
        thriftOutput.f27472a = firebaseJobDispatcher;
    }

    public static void m28977a(ThriftOutput thriftOutput, LocalEventDataSource localEventDataSource) {
        thriftOutput.f27473b = localEventDataSource;
    }

    public static void m28976a(ThriftOutput thriftOutput, BackgroundThread backgroundThread) {
        thriftOutput.f27474c = backgroundThread;
    }
}
