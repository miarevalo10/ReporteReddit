package com.reddit.frontpage.di.module;

import com.reddit.data.events.datasource.remote.RemoteEventDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class ThriftModule_ProvideRemoteEventDataSourceFactory implements Factory<RemoteEventDataSource> {
    private final ThriftModule f33671a;
    private final Provider<Retrofit> f33672b;

    private ThriftModule_ProvideRemoteEventDataSourceFactory(ThriftModule thriftModule, Provider<Retrofit> provider) {
        this.f33671a = thriftModule;
        this.f33672b = provider;
    }

    public static ThriftModule_ProvideRemoteEventDataSourceFactory m34536a(ThriftModule thriftModule, Provider<Retrofit> provider) {
        return new ThriftModule_ProvideRemoteEventDataSourceFactory(thriftModule, provider);
    }

    public final /* synthetic */ Object get() {
        return (RemoteEventDataSource) Preconditions.m26013a(ThriftModule.m22374a((Retrofit) this.f33672b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
