package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.requests.api.v1.OkHttpStack;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class OkHttpModule_ProvideNoRedirectsOkHttpStackFactory implements Factory<OkHttpStack> {
    private final OkHttpModule f33627a;
    private final Provider<OkHttpClient> f33628b;

    private OkHttpModule_ProvideNoRedirectsOkHttpStackFactory(OkHttpModule okHttpModule, Provider<OkHttpClient> provider) {
        this.f33627a = okHttpModule;
        this.f33628b = provider;
    }

    public static OkHttpModule_ProvideNoRedirectsOkHttpStackFactory m34516a(OkHttpModule okHttpModule, Provider<OkHttpClient> provider) {
        return new OkHttpModule_ProvideNoRedirectsOkHttpStackFactory(okHttpModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (OkHttpStack) Preconditions.m26013a(OkHttpModule.m22355a((OkHttpClient) this.f33628b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
