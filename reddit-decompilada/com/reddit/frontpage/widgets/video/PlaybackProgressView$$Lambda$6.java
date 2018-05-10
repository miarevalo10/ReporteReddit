package com.reddit.frontpage.widgets.video;

import io.reactivex.functions.Predicate;

final /* synthetic */ class PlaybackProgressView$$Lambda$6 implements Predicate {
    private final PlaybackProgressView f29551a;

    PlaybackProgressView$$Lambda$6(PlaybackProgressView playbackProgressView) {
        this.f29551a = playbackProgressView;
    }

    public final boolean test(Object obj) {
        obj = this.f29551a;
        obj = obj.f22147c != null ? VideoPlayer.m24337a(obj.f22147c) : null;
        return (obj == null || obj.f22223e == null) ? null : true;
    }
}
