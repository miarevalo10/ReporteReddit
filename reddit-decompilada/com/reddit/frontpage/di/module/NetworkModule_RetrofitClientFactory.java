package com.reddit.frontpage.di.module;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class NetworkModule_RetrofitClientFactory implements Factory<Retrofit> {
    private final NetworkModule f33620a;
    private final Provider<OkHttpClient> f33621b;
    private final Provider<Moshi> f33622c;

    private NetworkModule_RetrofitClientFactory(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        this.f33620a = networkModule;
        this.f33621b = provider;
        this.f33622c = provider2;
    }

    public static NetworkModule_RetrofitClientFactory m34512a(NetworkModule networkModule, Provider<OkHttpClient> provider, Provider<Moshi> provider2) {
        return new NetworkModule_RetrofitClientFactory(networkModule, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (Retrofit) Preconditions.m26013a(NetworkModule.m22351a((OkHttpClient) this.f33621b.get(), (Moshi) this.f33622c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
