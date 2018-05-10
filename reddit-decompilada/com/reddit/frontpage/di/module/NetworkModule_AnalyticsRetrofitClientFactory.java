package com.reddit.frontpage.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class NetworkModule_AnalyticsRetrofitClientFactory implements Factory<Retrofit> {
    private final NetworkModule f33611a;
    private final Provider<OkHttpClient> f33612b;

    private NetworkModule_AnalyticsRetrofitClientFactory(NetworkModule networkModule, Provider<OkHttpClient> provider) {
        this.f33611a = networkModule;
        this.f33612b = provider;
    }

    public static NetworkModule_AnalyticsRetrofitClientFactory m34506a(NetworkModule networkModule, Provider<OkHttpClient> provider) {
        return new NetworkModule_AnalyticsRetrofitClientFactory(networkModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (Retrofit) Preconditions.m26013a(NetworkModule.m22353b((OkHttpClient) this.f33612b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
