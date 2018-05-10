package com.reddit.frontpage.widgets.video;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.functions.Consumer;

final /* synthetic */ class PlaybackProgressView$$Lambda$8 implements Consumer {
    private final PlaybackProgressView f29553a;

    PlaybackProgressView$$Lambda$8(PlaybackProgressView playbackProgressView) {
        this.f29553a = playbackProgressView;
    }

    public final void accept(Object obj) {
        PlaybackProgressView playbackProgressView = this.f29553a;
        VideoPlayer videoPlayer = (VideoPlayer) obj;
        if (FrontpageApplication.m28873i().mo5025a().m23652a()) {
            videoPlayer.m24362a(false);
            playbackProgressView.f22146b.setImageResource(C1761R.drawable.icon_audio_off);
        }
    }
}
