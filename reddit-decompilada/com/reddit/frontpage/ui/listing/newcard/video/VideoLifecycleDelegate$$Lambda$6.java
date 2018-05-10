package com.reddit.frontpage.ui.listing.newcard.video;

import com.reddit.frontpage.bus.VideoPlayerStateChangedEventBus.PlayerState;
import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoLifecycleDelegate$$Lambda$6 implements Predicate {
    private final VideoLifecycleDelegate f29152a;

    VideoLifecycleDelegate$$Lambda$6(VideoLifecycleDelegate videoLifecycleDelegate) {
        this.f29152a = videoLifecycleDelegate;
    }

    public final boolean test(Object obj) {
        return ((PlayerState) obj).url.equals(this.f29152a.f21429j);
    }
}
