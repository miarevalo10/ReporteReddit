package com.reddit.frontpage.ui.detail.video;

import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoDetailScreen$$Lambda$5 implements Consumer {
    private final VideoDetailScreen f28969a;

    VideoDetailScreen$$Lambda$5(VideoDetailScreen videoDetailScreen) {
        this.f28969a = videoDetailScreen;
    }

    public final void accept(Object obj) {
        this.f28969a.m42194a((VideoEventWrapper) obj);
    }
}
