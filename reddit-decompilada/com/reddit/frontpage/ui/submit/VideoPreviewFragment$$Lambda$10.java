package com.reddit.frontpage.ui.submit;

import com.reddit.frontpage.service.video.VideoTrimService.VideoTrimEvent;
import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoPreviewFragment$$Lambda$10 implements Predicate {
    private final VideoPreviewFragment f29334a;

    VideoPreviewFragment$$Lambda$10(VideoPreviewFragment videoPreviewFragment) {
        this.f29334a = videoPreviewFragment;
    }

    public final boolean test(Object obj) {
        return this.f29334a.f39357c.getAbsolutePath().equals(((VideoTrimEvent) obj).f21042b);
    }
}
