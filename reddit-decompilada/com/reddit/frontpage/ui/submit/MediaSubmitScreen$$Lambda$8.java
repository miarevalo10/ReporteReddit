package com.reddit.frontpage.ui.submit;

import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.VideoUtil;
import java.util.concurrent.Callable;

final /* synthetic */ class MediaSubmitScreen$$Lambda$8 implements Callable {
    private final MediaSubmitScreen f21619a;

    MediaSubmitScreen$$Lambda$8(MediaSubmitScreen mediaSubmitScreen) {
        this.f21619a = mediaSubmitScreen;
    }

    public final Object call() {
        return VideoUtil.m24052a(FrontpageApplication.f27402a, this.f21619a.mediaFile.getAbsolutePath());
    }
}
