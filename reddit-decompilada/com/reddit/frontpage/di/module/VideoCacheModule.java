package com.reddit.frontpage.di.module;

import com.danikula.videocache.Config;
import com.danikula.videocache.HttpProxyCacheServer;
import com.danikula.videocache.HttpProxyCacheServer.Builder;
import com.danikula.videocache.Preconditions;
import com.reddit.frontpage.FrontpageApplication;
import java.io.File;
import javax.inject.Singleton;

public class VideoCacheModule {
    @Singleton
    public static HttpProxyCacheServer m22386a() {
        Builder builder = new Builder(FrontpageApplication.f27402a);
        builder.a = (File) Preconditions.a(new File(FrontpageApplication.f27402a.getExternalCacheDir(), "video_cache"));
        return new HttpProxyCacheServer(new Config(builder.a, builder.b, builder.c, builder.d), (byte) 0);
    }
}
