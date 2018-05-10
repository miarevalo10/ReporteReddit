package com.reddit.frontpage.widgets.video;

import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import io.reactivex.functions.Consumer;

final /* synthetic */ class PlaybackControlView$$Lambda$2 implements Consumer {
    private final PlaybackControlView f29544a;

    PlaybackControlView$$Lambda$2(PlaybackControlView playbackControlView) {
        this.f29544a = playbackControlView;
    }

    public final void accept(Object obj) {
        PlaybackControlView playbackControlView = this.f29544a;
        switch (((VideoEventWrapper) obj).f22206a) {
            case null:
                playbackControlView.m24267a(true);
                return;
            case 1:
                playbackControlView.m24270b(true);
                return;
            case 2:
                playbackControlView.m24267a((boolean) null);
                return;
            case 3:
                playbackControlView.m24269b();
                break;
            default:
                break;
        }
    }
}
