package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteWebSocketDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApiClientModule_ProvideRemoteWebsocketDataSourceFactory implements Factory<RemoteWebSocketDataSource> {
    private final ApiClientModule f33518a;

    private ApiClientModule_ProvideRemoteWebsocketDataSourceFactory(ApiClientModule apiClientModule) {
        this.f33518a = apiClientModule;
    }

    public static ApiClientModule_ProvideRemoteWebsocketDataSourceFactory m34459a(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvideRemoteWebsocketDataSourceFactory(apiClientModule);
    }

    public final /* synthetic */ Object get() {
        return (RemoteWebSocketDataSource) Preconditions.m26013a(ApiClientModule.m22322b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
