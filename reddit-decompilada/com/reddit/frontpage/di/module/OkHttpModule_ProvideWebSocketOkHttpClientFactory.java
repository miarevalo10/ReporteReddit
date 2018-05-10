package com.reddit.frontpage.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public final class OkHttpModule_ProvideWebSocketOkHttpClientFactory implements Factory<OkHttpClient> {
    private final OkHttpModule f33632a;

    private OkHttpModule_ProvideWebSocketOkHttpClientFactory(OkHttpModule okHttpModule) {
        this.f33632a = okHttpModule;
    }

    public static OkHttpModule_ProvideWebSocketOkHttpClientFactory m34519a(OkHttpModule okHttpModule) {
        return new OkHttpModule_ProvideWebSocketOkHttpClientFactory(okHttpModule);
    }

    public final /* synthetic */ Object get() {
        OkHttpModule okHttpModule = this.f33632a;
        Level level = Level.NONE;
        Builder a = okHttpModule.m22359a();
        a.readTimeout(0, TimeUnit.SECONDS);
        a.writeTimeout(0, TimeUnit.SECONDS);
        return (OkHttpClient) Preconditions.m26013a(a.build(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
