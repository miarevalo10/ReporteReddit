package com.reddit.frontpage.ui.listing.newcard.video;

import com.reddit.frontpage.util.ScreenUtil;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoLifecycleDelegate$$Lambda$3 implements Consumer {
    private final VideoLifecycleDelegate f29149a;

    VideoLifecycleDelegate$$Lambda$3(VideoLifecycleDelegate videoLifecycleDelegate) {
        this.f29149a = videoLifecycleDelegate;
    }

    public final void accept(Object obj) {
        obj = this.f29149a;
        if (obj.f21426g != null) {
            obj.f21426g.m24368d();
            ScreenUtil.m23891c(obj.f21421b);
        }
    }
}
