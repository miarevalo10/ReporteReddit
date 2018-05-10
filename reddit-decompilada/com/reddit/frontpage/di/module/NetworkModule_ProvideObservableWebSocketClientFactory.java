package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.data.common.websocket.ObservableWebSocketClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class NetworkModule_ProvideObservableWebSocketClientFactory implements Factory<ObservableWebSocketClient> {
    private final NetworkModule f33618a;
    private final Provider<OkHttpClient> f33619b;

    private NetworkModule_ProvideObservableWebSocketClientFactory(NetworkModule networkModule, Provider<OkHttpClient> provider) {
        this.f33618a = networkModule;
        this.f33619b = provider;
    }

    public static NetworkModule_ProvideObservableWebSocketClientFactory m34511a(NetworkModule networkModule, Provider<OkHttpClient> provider) {
        return new NetworkModule_ProvideObservableWebSocketClientFactory(networkModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (ObservableWebSocketClient) Preconditions.m26013a(NetworkModule.m22354c((OkHttpClient) this.f33619b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
