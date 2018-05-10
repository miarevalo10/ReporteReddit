package com.reddit.frontpage.widgets.video;

import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.FrontpageApplication;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class PlaybackProgressView$$Lambda$9 implements Consumer {
    private final PlaybackProgressView f29554a;

    PlaybackProgressView$$Lambda$9(PlaybackProgressView playbackProgressView) {
        this.f29554a = playbackProgressView;
    }

    public final void accept(Object obj) {
        PlaybackProgressView playbackProgressView = this.f29554a;
        Timber.b("Received audio event [%d]", new Object[]{(Integer) obj});
        if (((Integer) obj).intValue() == -1) {
            if (playbackProgressView.f22146b != null) {
                obj = VideoPlayer.m24337a(playbackProgressView.f22147c);
                if (obj != null && !obj.f22223e) {
                    obj.m24363b();
                    playbackProgressView.f22146b.setImageResource(C1761R.drawable.icon_audio_on);
                    FrontpageApplication.m28873i().mo5025a().m23653b();
                }
            }
        }
    }
}
