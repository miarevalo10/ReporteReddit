package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.feature.legacy.remote.RemoteGatewayDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class ApiClientModule_ProvideRemoteGatewayDataSourceFactory implements Factory<RemoteGatewayDataSource> {
    private final ApiClientModule f33515a;
    private final Provider<Retrofit> f33516b;

    private ApiClientModule_ProvideRemoteGatewayDataSourceFactory(ApiClientModule apiClientModule, Provider<Retrofit> provider) {
        this.f33515a = apiClientModule;
        this.f33516b = provider;
    }

    public static ApiClientModule_ProvideRemoteGatewayDataSourceFactory m34457a(ApiClientModule apiClientModule, Provider<Retrofit> provider) {
        return new ApiClientModule_ProvideRemoteGatewayDataSourceFactory(apiClientModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteGatewayDataSource) Preconditions.m26013a(ApiClientModule.m22320a((Retrofit) this.f33516b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
