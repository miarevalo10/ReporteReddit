package com.reddit.frontpage.ui.detail.video;

import com.reddit.frontpage.bus.VideoPlayerStateChangedEventBus.PlayerState;
import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoDetailScreen$$Lambda$10 implements Predicate {
    private final VideoDetailScreen f28965a;

    VideoDetailScreen$$Lambda$10(VideoDetailScreen videoDetailScreen) {
        this.f28965a = videoDetailScreen;
    }

    public final boolean test(Object obj) {
        PlayerState playerState = (PlayerState) obj;
        return (!playerState.playing || playerState.url.equals(this.f28965a.aa) == null) ? null : true;
    }
}
