package com.reddit.frontpage.di.module;

import com.android.volley.RequestQueue;
import com.reddit.datalibrary.frontpage.requests.api.v1.OkHttpStack;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class VolleyModule_ProvideNoBodyLoggingRequestQueueFactory implements Factory<RequestQueue> {
    private final VolleyModule f33710a;
    private final Provider<OkHttpStack> f33711b;

    private VolleyModule_ProvideNoBodyLoggingRequestQueueFactory(VolleyModule volleyModule, Provider<OkHttpStack> provider) {
        this.f33710a = volleyModule;
        this.f33711b = provider;
    }

    public static VolleyModule_ProvideNoBodyLoggingRequestQueueFactory m34552a(VolleyModule volleyModule, Provider<OkHttpStack> provider) {
        return new VolleyModule_ProvideNoBodyLoggingRequestQueueFactory(volleyModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RequestQueue) Preconditions.m26013a(VolleyModule.m22387a((OkHttpStack) this.f33711b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
