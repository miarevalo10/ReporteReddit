package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.redditauth.redditclient.WebSocketClient;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class OkHttpModule_ProvideWebSocketClientFactory implements Factory<WebSocketClient> {
    private final OkHttpModule f33630a;
    private final Provider<OkHttpClient> f33631b;

    private OkHttpModule_ProvideWebSocketClientFactory(OkHttpModule okHttpModule, Provider<OkHttpClient> provider) {
        this.f33630a = okHttpModule;
        this.f33631b = provider;
    }

    public static OkHttpModule_ProvideWebSocketClientFactory m34518a(OkHttpModule okHttpModule, Provider<OkHttpClient> provider) {
        return new OkHttpModule_ProvideWebSocketClientFactory(okHttpModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (WebSocketClient) Preconditions.m26013a(OkHttpModule.m22358c((OkHttpClient) this.f33631b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
