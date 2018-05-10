package com.reddit.frontpage.ui.submit;

import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.VideoUtil;
import java.util.concurrent.Callable;

final /* synthetic */ class VideoPreviewFragment$$Lambda$2 implements Callable {
    private final VideoPreviewFragment f21635a;

    VideoPreviewFragment$$Lambda$2(VideoPreviewFragment videoPreviewFragment) {
        this.f21635a = videoPreviewFragment;
    }

    public final Object call() {
        return VideoUtil.m24052a(FrontpageApplication.f27402a, this.f21635a.f39357c.getAbsolutePath());
    }
}
