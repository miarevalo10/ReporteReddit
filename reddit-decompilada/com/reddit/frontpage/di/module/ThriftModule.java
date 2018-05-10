package com.reddit.frontpage.di.module;

import android.content.Context;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.reddit.data.events.datasource.remote.RemoteEventDataSource;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000f"}, d2 = {"Lcom/reddit/frontpage/di/module/ThriftModule;", "", "()V", "provideGooglePlayDriver", "Lcom/firebase/jobdispatcher/GooglePlayDriver;", "context", "Landroid/content/Context;", "provideJobDispatcher", "Lcom/firebase/jobdispatcher/FirebaseJobDispatcher;", "driver", "provideRemoteEventDataSource", "Lcom/reddit/data/events/datasource/remote/RemoteEventDataSource;", "client", "Lretrofit2/Retrofit;", "Bindings", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ThriftModule.kt */
public final class ThriftModule {
    @Singleton
    public static RemoteEventDataSource m22374a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteEventDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteEventDataSource::class.java)");
        return (RemoteEventDataSource) a;
    }

    @Singleton
    public static GooglePlayDriver m22373a(Context context) {
        Intrinsics.m26847b(context, "context");
        return new GooglePlayDriver(context);
    }

    @Singleton
    public static FirebaseJobDispatcher m22372a(GooglePlayDriver googlePlayDriver) {
        Intrinsics.m26847b(googlePlayDriver, "driver");
        return new FirebaseJobDispatcher(googlePlayDriver);
    }
}
