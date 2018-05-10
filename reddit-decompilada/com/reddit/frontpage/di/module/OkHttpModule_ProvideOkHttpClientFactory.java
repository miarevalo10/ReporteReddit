package com.reddit.frontpage.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public final class OkHttpModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
    private final OkHttpModule f33629a;

    private OkHttpModule_ProvideOkHttpClientFactory(OkHttpModule okHttpModule) {
        this.f33629a = okHttpModule;
    }

    public static OkHttpModule_ProvideOkHttpClientFactory m34517a(OkHttpModule okHttpModule) {
        return new OkHttpModule_ProvideOkHttpClientFactory(okHttpModule);
    }

    public final /* synthetic */ Object get() {
        OkHttpModule okHttpModule = this.f33629a;
        Level level = Level.BODY;
        return (OkHttpClient) Preconditions.m26013a(okHttpModule.m22359a().build(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
