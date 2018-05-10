package com.reddit.frontpage.di.module;

import com.android.volley.RequestQueue;
import com.reddit.datalibrary.frontpage.requests.api.v1.OkHttpStack;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VolleyModule_ProvideNoRedirectRequestQueueFactory implements Factory<RequestQueue> {
    private final VolleyModule f33712a;
    private final Provider<OkHttpStack> f33713b;

    private VolleyModule_ProvideNoRedirectRequestQueueFactory(VolleyModule volleyModule, Provider<OkHttpStack> provider) {
        this.f33712a = volleyModule;
        this.f33713b = provider;
    }

    public static VolleyModule_ProvideNoRedirectRequestQueueFactory m34553a(VolleyModule volleyModule, Provider<OkHttpStack> provider) {
        return new VolleyModule_ProvideNoRedirectRequestQueueFactory(volleyModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RequestQueue) Preconditions.m26013a(VolleyModule.m22388b((OkHttpStack) this.f33713b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
