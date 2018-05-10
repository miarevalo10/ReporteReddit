package com.reddit.frontpage.ui.submit;

import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoPreviewFragment$$Lambda$8 implements Predicate {
    private final VideoPreviewFragment f29341a;

    VideoPreviewFragment$$Lambda$8(VideoPreviewFragment videoPreviewFragment) {
        this.f29341a = videoPreviewFragment;
    }

    public final boolean test(Object obj) {
        return this.f29341a.gifSwitch.isChecked() == null ? true : null;
    }
}
