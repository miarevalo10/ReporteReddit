package com.reddit.frontpage.widgets.video;

import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import io.reactivex.functions.Consumer;

final /* synthetic */ class PlaybackProgressView$$Lambda$4 implements Consumer {
    private final PlaybackProgressView f29549a;

    PlaybackProgressView$$Lambda$4(PlaybackProgressView playbackProgressView) {
        this.f29549a = playbackProgressView;
    }

    public final void accept(Object obj) {
        PlaybackProgressView playbackProgressView = this.f29549a;
        switch (((VideoEventWrapper) obj).f22206a) {
            case null:
                playbackProgressView.m24303a(true);
                return;
            case 1:
                playbackProgressView.m24305b(true);
                return;
            case 2:
                playbackProgressView.m24303a(true);
                break;
            default:
                break;
        }
    }
}
