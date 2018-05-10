package com.reddit.frontpage.widgets.video;

import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import io.reactivex.functions.Predicate;

final /* synthetic */ class PlaybackProgressView$$Lambda$3 implements Predicate {
    private final PlaybackProgressView f29548a;

    PlaybackProgressView$$Lambda$3(PlaybackProgressView playbackProgressView) {
        this.f29548a = playbackProgressView;
    }

    public final boolean test(Object obj) {
        return ((VideoEventWrapper) obj).f22207b != this.f29548a.f22149e ? true : null;
    }
}
