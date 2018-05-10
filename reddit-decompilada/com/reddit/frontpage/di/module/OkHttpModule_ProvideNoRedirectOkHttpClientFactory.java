package com.reddit.frontpage.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public final class OkHttpModule_ProvideNoRedirectOkHttpClientFactory implements Factory<OkHttpClient> {
    private final OkHttpModule f33626a;

    private OkHttpModule_ProvideNoRedirectOkHttpClientFactory(OkHttpModule okHttpModule) {
        this.f33626a = okHttpModule;
    }

    public static OkHttpModule_ProvideNoRedirectOkHttpClientFactory m34515a(OkHttpModule okHttpModule) {
        return new OkHttpModule_ProvideNoRedirectOkHttpClientFactory(okHttpModule);
    }

    public final /* synthetic */ Object get() {
        OkHttpModule okHttpModule = this.f33626a;
        Level level = Level.BODY;
        Builder a = okHttpModule.m22359a();
        a.followRedirects(false);
        a.followSslRedirects(false);
        return (OkHttpClient) Preconditions.m26013a(a.build(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
