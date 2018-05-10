package com.reddit.frontpage.di.module;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class NetworkModule_ProvideMoshiFactory implements Factory<Moshi> {
    private final NetworkModule f33617a;

    private NetworkModule_ProvideMoshiFactory(NetworkModule networkModule) {
        this.f33617a = networkModule;
    }

    public static NetworkModule_ProvideMoshiFactory m34510a(NetworkModule networkModule) {
        return new NetworkModule_ProvideMoshiFactory(networkModule);
    }

    public final /* synthetic */ Object get() {
        return (Moshi) Preconditions.m26013a(NetworkModule.m22352b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
