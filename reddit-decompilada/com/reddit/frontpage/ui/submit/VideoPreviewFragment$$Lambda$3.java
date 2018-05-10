package com.reddit.frontpage.ui.submit;

import android.graphics.Bitmap;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoPreviewFragment$$Lambda$3 implements Consumer {
    private final VideoPreviewFragment f29336a;

    VideoPreviewFragment$$Lambda$3(VideoPreviewFragment videoPreviewFragment) {
        this.f29336a = videoPreviewFragment;
    }

    public final void accept(Object obj) {
        VideoPreviewFragment videoPreviewFragment = this.f29336a;
        Bitmap bitmap = (Bitmap) obj;
        if (videoPreviewFragment.isAdded()) {
            videoPreviewFragment.f39360h = bitmap;
            videoPreviewFragment.simpleExoPlayerView.setShutterImage(bitmap);
        }
    }
}
