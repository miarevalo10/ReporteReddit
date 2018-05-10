package com.reddit.frontpage.ui.detail.video;

import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoPlayerScreen$$Lambda$6 implements Consumer {
    private final VideoPlayerScreen f28979a;

    VideoPlayerScreen$$Lambda$6(VideoPlayerScreen videoPlayerScreen) {
        this.f28979a = videoPlayerScreen;
    }

    public final void accept(Object obj) {
        this.f28979a.m40957a((VideoEventWrapper) obj);
    }
}
