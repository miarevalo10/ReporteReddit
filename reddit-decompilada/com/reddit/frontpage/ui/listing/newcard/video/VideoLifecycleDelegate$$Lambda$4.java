package com.reddit.frontpage.ui.listing.newcard.video;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class VideoLifecycleDelegate$$Lambda$4 implements Consumer {
    private final VideoLifecycleDelegate f29150a;

    VideoLifecycleDelegate$$Lambda$4(VideoLifecycleDelegate videoLifecycleDelegate) {
        this.f29150a = videoLifecycleDelegate;
    }

    public final void accept(Object obj) {
        VideoLifecycleDelegate videoLifecycleDelegate = this.f29150a;
        Timber.b("Received play notification, this video [%s}, play video [%s]", new Object[]{videoLifecycleDelegate.f21432m.getId(), (String) obj});
        if (videoLifecycleDelegate.f21426g != null && videoLifecycleDelegate.f21432m.getId().equals(r6) == null) {
            videoLifecycleDelegate.f21426g.m24366c();
        }
    }
}
