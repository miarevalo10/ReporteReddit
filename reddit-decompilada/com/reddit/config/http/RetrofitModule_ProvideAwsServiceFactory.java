package com.reddit.config.http;

import com.reddit.datalibrary.frontpage.service.api.AwsService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class RetrofitModule_ProvideAwsServiceFactory implements Factory<AwsService> {
    private final Provider<OkHttpClient> f18676a;

    private RetrofitModule_ProvideAwsServiceFactory(Provider<OkHttpClient> provider) {
        this.f18676a = provider;
    }

    public static RetrofitModule_ProvideAwsServiceFactory m19654a(Provider<OkHttpClient> provider) {
        return new RetrofitModule_ProvideAwsServiceFactory(provider);
    }

    public final /* synthetic */ Object get() {
        return (AwsService) Preconditions.a(RetrofitModule.m8729a((OkHttpClient) this.f18676a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
