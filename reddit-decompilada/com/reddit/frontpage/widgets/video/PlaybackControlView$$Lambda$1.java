package com.reddit.frontpage.widgets.video;

import com.reddit.frontpage.widgets.video.VideoEventBus.VideoEventWrapper;
import io.reactivex.functions.Predicate;

final /* synthetic */ class PlaybackControlView$$Lambda$1 implements Predicate {
    private final PlaybackControlView f29543a;

    PlaybackControlView$$Lambda$1(PlaybackControlView playbackControlView) {
        this.f29543a = playbackControlView;
    }

    public final boolean test(Object obj) {
        return ((VideoEventWrapper) obj).f22207b != this.f29543a.f22114b ? true : null;
    }
}
