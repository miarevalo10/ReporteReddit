package com.reddit.frontpage.ui.submit;

import com.reddit.frontpage.widgets.video.ClippingBounds;
import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoPreviewFragment$$Lambda$5 implements Predicate {
    private final VideoPreviewFragment f29338a;

    VideoPreviewFragment$$Lambda$5(VideoPreviewFragment videoPreviewFragment) {
        this.f29338a = videoPreviewFragment;
    }

    public final boolean test(Object obj) {
        return ((ClippingBounds) obj).f22103a.equals(this.f29338a.f39355a);
    }
}
