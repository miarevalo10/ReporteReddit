package com.reddit.frontpage.ui.listing.newcard;

import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;

final /* synthetic */ class VideoCardLinkViewHolder$$Lambda$0 implements Runnable {
    private final VideoCardLinkViewHolder f21378a;

    VideoCardLinkViewHolder$$Lambda$0(VideoCardLinkViewHolder videoCardLinkViewHolder) {
        this.f21378a = videoCardLinkViewHolder;
    }

    public final void run() {
        this.f21378a.f37304v.f21426g.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CLICK_OVERFLOW);
    }
}
