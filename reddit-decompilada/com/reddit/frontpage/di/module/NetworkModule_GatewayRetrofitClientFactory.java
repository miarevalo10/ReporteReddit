package com.reddit.frontpage.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class NetworkModule_GatewayRetrofitClientFactory implements Factory<Retrofit> {
    private final NetworkModule f33613a;
    private final Provider<OkHttpClient> f33614b;

    private NetworkModule_GatewayRetrofitClientFactory(NetworkModule networkModule, Provider<OkHttpClient> provider) {
        this.f33613a = networkModule;
        this.f33614b = provider;
    }

    public static NetworkModule_GatewayRetrofitClientFactory m34507a(NetworkModule networkModule, Provider<OkHttpClient> provider) {
        return new NetworkModule_GatewayRetrofitClientFactory(networkModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (Retrofit) Preconditions.m26013a(NetworkModule.m22350a((OkHttpClient) this.f33614b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
