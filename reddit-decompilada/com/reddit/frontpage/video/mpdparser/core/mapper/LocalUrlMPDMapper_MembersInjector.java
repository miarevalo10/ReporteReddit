package com.reddit.frontpage.video.mpdparser.core.mapper;

import com.danikula.videocache.HttpProxyCacheServer;
import dagger.MembersInjector;

public final class LocalUrlMPDMapper_MembersInjector implements MembersInjector<LocalUrlMPDMapper> {
    public static void m30466a(LocalUrlMPDMapper localUrlMPDMapper, HttpProxyCacheServer httpProxyCacheServer) {
        localUrlMPDMapper.f21840a = httpProxyCacheServer;
    }
}
