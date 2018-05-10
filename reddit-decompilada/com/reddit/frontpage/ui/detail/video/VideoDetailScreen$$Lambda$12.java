package com.reddit.frontpage.ui.detail.video;

final /* synthetic */ class VideoDetailScreen$$Lambda$12 implements Runnable {
    private final VideoDetailScreen f21192a;

    VideoDetailScreen$$Lambda$12(VideoDetailScreen videoDetailScreen) {
        this.f21192a = videoDetailScreen;
    }

    public final void run() {
        VideoDetailScreen videoDetailScreen = this.f21192a;
        if (videoDetailScreen.toolbar != null) {
            videoDetailScreen.toolbar.setVisibility(8);
        }
    }
}
