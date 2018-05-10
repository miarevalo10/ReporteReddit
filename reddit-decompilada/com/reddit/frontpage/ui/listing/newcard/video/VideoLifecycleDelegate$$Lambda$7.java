package com.reddit.frontpage.ui.listing.newcard.video;

import com.reddit.frontpage.bus.VideoPlayerStateChangedEventBus.PlayerState;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoLifecycleDelegate$$Lambda$7 implements Consumer {
    private final VideoLifecycleDelegate f29153a;

    VideoLifecycleDelegate$$Lambda$7(VideoLifecycleDelegate videoLifecycleDelegate) {
        this.f29153a = videoLifecycleDelegate;
    }

    public final void accept(Object obj) {
        VideoLifecycleDelegate videoLifecycleDelegate = this.f29153a;
        videoLifecycleDelegate.f21431l = ((PlayerState) obj).playing;
        if (videoLifecycleDelegate.f21431l != null) {
            VideoLifecycleDelegate.f21419a.onNext(videoLifecycleDelegate.f21432m.getId());
        } else {
            videoLifecycleDelegate.f21428i = null;
        }
        videoLifecycleDelegate.m23530h();
    }
}
