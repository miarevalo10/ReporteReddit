package com.reddit.frontpage.widgets.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.reddit.frontpage.widgets.video.SimpleExoPlayerView.ExoPlayerViewCommentsListener;

final /* synthetic */ class SimpleExoPlayerView$$Lambda$1 implements OnClickListener {
    private final ExoPlayerViewCommentsListener f22171a;

    SimpleExoPlayerView$$Lambda$1(ExoPlayerViewCommentsListener exoPlayerViewCommentsListener) {
        this.f22171a = exoPlayerViewCommentsListener;
    }

    public final void onClick(View view) {
        SimpleExoPlayerView.m24311a(this.f22171a);
    }
}
