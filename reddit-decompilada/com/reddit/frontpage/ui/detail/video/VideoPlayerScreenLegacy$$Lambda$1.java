package com.reddit.frontpage.ui.detail.video;

import com.reddit.frontpage.ui.listener.VideoPlayingListener;

final /* synthetic */ class VideoPlayerScreenLegacy$$Lambda$1 implements VideoPlayingListener {
    private final VideoPlayerScreenLegacy f28984a;

    VideoPlayerScreenLegacy$$Lambda$1(VideoPlayerScreenLegacy videoPlayerScreenLegacy) {
        this.f28984a = videoPlayerScreenLegacy;
    }

    public final void mo4973a() {
        VideoPlayerScreenLegacy videoPlayerScreenLegacy = this.f28984a;
        videoPlayerScreenLegacy.videoPlayerOld.getLayoutParams().width = -1;
        videoPlayerScreenLegacy.videoPlayerOld.getLayoutParams().height = -1;
        videoPlayerScreenLegacy.videoPlayerOld.requestLayout();
    }
}
