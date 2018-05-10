package com.reddit.frontpage.widgets.video;

import io.reactivex.functions.Predicate;

final /* synthetic */ class PlaybackControlView$$Lambda$3 implements Predicate {
    private final PlaybackControlView f29545a;

    PlaybackControlView$$Lambda$3(PlaybackControlView playbackControlView) {
        this.f29545a = playbackControlView;
    }

    public final boolean test(Object obj) {
        return ((ClippingBounds) obj).f22103a.equals(this.f29545a.f22113a);
    }
}
