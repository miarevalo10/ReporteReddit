package com.reddit.frontpage.widgets.video;

import android.view.View;

final /* synthetic */ class PlaybackProgressView$$Lambda$2 implements Runnable {
    private final PlaybackProgressView f22131a;
    private final View f22132b;

    PlaybackProgressView$$Lambda$2(PlaybackProgressView playbackProgressView, View view) {
        this.f22131a = playbackProgressView;
        this.f22132b = view;
    }

    public final void run() {
        PlaybackProgressView playbackProgressView = this.f22131a;
        View view = this.f22132b;
        view.setVisibility(8);
        view.setAlpha(1.0f);
        playbackProgressView.f22148d = false;
    }
}
