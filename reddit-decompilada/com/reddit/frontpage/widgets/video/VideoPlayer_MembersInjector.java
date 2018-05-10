package com.reddit.frontpage.widgets.video;

import com.danikula.videocache.HttpProxyCacheServer;
import dagger.MembersInjector;

public final class VideoPlayer_MembersInjector implements MembersInjector<VideoPlayer> {
    public static void m30576a(VideoPlayer videoPlayer, HttpProxyCacheServer httpProxyCacheServer) {
        videoPlayer.f22225g = httpProxyCacheServer;
    }
}
