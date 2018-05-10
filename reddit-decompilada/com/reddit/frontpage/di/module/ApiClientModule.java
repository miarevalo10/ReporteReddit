package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteGatewayDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteWebSocketDataSource;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Retrofit;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/reddit/frontpage/di/module/ApiClientModule;", "", "()V", "provideRemoteGatewayDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteGatewayDataSource;", "client", "Lretrofit2/Retrofit;", "provideRemoteRedditApiDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteRedditApiDataSource;", "provideRemoteWebsocketDataSource", "Lcom/reddit/datalibrary/frontpage/data/feature/legacy/remote/RemoteWebSocketDataSource;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ApiClientModule.kt */
public final class ApiClientModule {
    @Singleton
    public static RemoteGatewayDataSource m22320a(Retrofit retrofit) {
        Intrinsics.m26847b(retrofit, "client");
        Object a = retrofit.a(RemoteGatewayDataSource.class);
        Intrinsics.m26843a(a, "client.create(RemoteGatewayDataSource::class.java)");
        return (RemoteGatewayDataSource) a;
    }

    @Singleton
    public static RemoteRedditApiDataSource m22321a() {
        return new RemoteRedditApiDataSource();
    }

    @Singleton
    public static RemoteWebSocketDataSource m22322b() {
        return new RemoteWebSocketDataSource();
    }
}
