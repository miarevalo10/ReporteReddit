package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteRedditApiDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApiClientModule_ProvideRemoteRedditApiDataSourceFactory implements Factory<RemoteRedditApiDataSource> {
    private final ApiClientModule f33517a;

    private ApiClientModule_ProvideRemoteRedditApiDataSourceFactory(ApiClientModule apiClientModule) {
        this.f33517a = apiClientModule;
    }

    public static ApiClientModule_ProvideRemoteRedditApiDataSourceFactory m34458a(ApiClientModule apiClientModule) {
        return new ApiClientModule_ProvideRemoteRedditApiDataSourceFactory(apiClientModule);
    }

    public final /* synthetic */ Object get() {
        return (RemoteRedditApiDataSource) Preconditions.m26013a(ApiClientModule.m22321a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
