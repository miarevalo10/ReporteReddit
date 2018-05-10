package com.reddit.frontpage.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;

public final class NetworkModule_OkHttpClientFactory implements Factory<OkHttpClient> {
    private final NetworkModule f33616a;

    private NetworkModule_OkHttpClientFactory(NetworkModule networkModule) {
        this.f33616a = networkModule;
    }

    public static NetworkModule_OkHttpClientFactory m34509a(NetworkModule networkModule) {
        return new NetworkModule_OkHttpClientFactory(networkModule);
    }

    public final /* synthetic */ Object get() {
        return (OkHttpClient) Preconditions.m26013a(NetworkModule.m22349a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
