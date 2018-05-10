package com.reddit.frontpage.ui.listing.newcard.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.datalibrary.frontpage.requests.models.v2.Link;
import com.reddit.frontpage.commons.analytics.events.v2.VideoPlayerEvent;

final /* synthetic */ class VideoLifecycleDelegate$$Lambda$1 implements OnClickListener {
    private final VideoLifecycleDelegate f21413a;
    private final Link f21414b;

    VideoLifecycleDelegate$$Lambda$1(VideoLifecycleDelegate videoLifecycleDelegate, Link link) {
        this.f21413a = videoLifecycleDelegate;
        this.f21414b = link;
    }

    public final void onClick(View view) {
        view = this.f21413a;
        Link link = this.f21414b;
        view.f21422c.ad_();
        view.f21422c.a_(link);
        view.f21422c.mo6966b(view.f21436q);
        if (view.f21426g != null) {
            view.f21426g.m24367c(VideoPlayerEvent.VIDEO_PLAYER_CHANGE_PAGETYPE);
        }
    }
}
