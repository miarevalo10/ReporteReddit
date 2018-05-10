package com.reddit.frontpage.ui.detail.video;

import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoDetailScreen$$Lambda$9 implements Consumer {
    private final VideoDetailScreen f28973a;

    VideoDetailScreen$$Lambda$9(VideoDetailScreen videoDetailScreen) {
        this.f28973a = videoDetailScreen;
    }

    public final void accept(Object obj) {
        this.f28973a.ab.m24367c(VideoPlayerEvent.VIDEO_PLAYER_SCROLL_ACTIVATED);
    }
}
