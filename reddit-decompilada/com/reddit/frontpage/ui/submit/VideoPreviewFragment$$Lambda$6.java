package com.reddit.frontpage.ui.submit;

import com.reddit.frontpage.widgets.video.ClippingBounds;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoPreviewFragment$$Lambda$6 implements Consumer {
    private final VideoPreviewFragment f29339a;

    VideoPreviewFragment$$Lambda$6(VideoPreviewFragment videoPreviewFragment) {
        this.f29339a = videoPreviewFragment;
    }

    public final void accept(Object obj) {
        this.f29339a.f39358d = (ClippingBounds) obj;
    }
}
