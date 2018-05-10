package com.reddit.frontpage.ui.detail.video;

import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoDetailScreen$$Lambda$11 implements Consumer {
    private final VideoDetailScreen f28966a;

    VideoDetailScreen$$Lambda$11(VideoDetailScreen videoDetailScreen) {
        this.f28966a = videoDetailScreen;
    }

    public final void accept(Object obj) {
        this.f28966a.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_ACTIVATED);
    }
}
