package com.reddit.frontpage.di.module;

import com.reddit.datalibrary.frontpage.requests.api.v1.OkHttpStack;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class OkHttpModule_ProvideNoBodyLoggingOkHttpStackFactory implements Factory<OkHttpStack> {
    private final OkHttpModule f33624a;
    private final Provider<OkHttpClient> f33625b;

    private OkHttpModule_ProvideNoBodyLoggingOkHttpStackFactory(OkHttpModule okHttpModule, Provider<OkHttpClient> provider) {
        this.f33624a = okHttpModule;
        this.f33625b = provider;
    }

    public static OkHttpModule_ProvideNoBodyLoggingOkHttpStackFactory m34514a(OkHttpModule okHttpModule, Provider<OkHttpClient> provider) {
        return new OkHttpModule_ProvideNoBodyLoggingOkHttpStackFactory(okHttpModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (OkHttpStack) Preconditions.m26013a(OkHttpModule.m22356b((OkHttpClient) this.f33625b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
