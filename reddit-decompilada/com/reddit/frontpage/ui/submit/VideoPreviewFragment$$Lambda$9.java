package com.reddit.frontpage.ui.submit;

import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoPreviewFragment$$Lambda$9 implements Consumer {
    private final VideoPreviewFragment f29342a;

    VideoPreviewFragment$$Lambda$9(VideoPreviewFragment videoPreviewFragment) {
        this.f29342a = videoPreviewFragment;
    }

    public final void accept(Object obj) {
        this.f29342a.simpleExoPlayerView.m24331a(((Integer) obj).intValue() == null ? true : null);
    }
}
