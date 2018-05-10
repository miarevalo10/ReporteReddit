package com.reddit.frontpage.di.module;

import com.danikula.videocache.HttpProxyCacheServer;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class VideoCacheModule_ProvideVideoCacheFactory implements Factory<HttpProxyCacheServer> {
    private final VideoCacheModule f33708a;

    private VideoCacheModule_ProvideVideoCacheFactory(VideoCacheModule videoCacheModule) {
        this.f33708a = videoCacheModule;
    }

    public static VideoCacheModule_ProvideVideoCacheFactory m34550a(VideoCacheModule videoCacheModule) {
        return new VideoCacheModule_ProvideVideoCacheFactory(videoCacheModule);
    }

    public final /* synthetic */ Object get() {
        return (HttpProxyCacheServer) Preconditions.m26013a(VideoCacheModule.m22386a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
