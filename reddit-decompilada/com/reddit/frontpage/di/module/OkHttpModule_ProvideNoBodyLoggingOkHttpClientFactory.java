package com.reddit.frontpage.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public final class OkHttpModule_ProvideNoBodyLoggingOkHttpClientFactory implements Factory<OkHttpClient> {
    private final OkHttpModule f33623a;

    private OkHttpModule_ProvideNoBodyLoggingOkHttpClientFactory(OkHttpModule okHttpModule) {
        this.f33623a = okHttpModule;
    }

    public static OkHttpModule_ProvideNoBodyLoggingOkHttpClientFactory m34513a(OkHttpModule okHttpModule) {
        return new OkHttpModule_ProvideNoBodyLoggingOkHttpClientFactory(okHttpModule);
    }

    public final /* synthetic */ Object get() {
        OkHttpModule okHttpModule = this.f33623a;
        Level level = Level.HEADERS;
        return (OkHttpClient) Preconditions.m26013a(okHttpModule.m22359a().build(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
