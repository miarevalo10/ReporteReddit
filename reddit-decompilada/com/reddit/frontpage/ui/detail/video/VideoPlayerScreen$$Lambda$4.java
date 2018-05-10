package com.reddit.frontpage.ui.detail.video;

import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEventBuilder;
import com.reddit.frontpage.commons.analytics.events.v2.TheaterModeEvents;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView.SizeToggleListener;

final /* synthetic */ class VideoPlayerScreen$$Lambda$4 implements SizeToggleListener {
    private final VideoPlayerScreen f28977a;

    VideoPlayerScreen$$Lambda$4(VideoPlayerScreen videoPlayerScreen) {
        this.f28977a = videoPlayerScreen;
    }

    public final void mo4970a() {
        VideoPlayerScreen videoPlayerScreen = this.f28977a;
        TheaterModeEventBuilder.m21947a("click", TheaterModeEvents.NOUN_MINIMIZE_PLAYER);
        videoPlayerScreen.mo7435X();
    }
}
