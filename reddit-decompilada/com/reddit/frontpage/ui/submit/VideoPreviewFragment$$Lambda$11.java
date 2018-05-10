package com.reddit.frontpage.ui.submit;

import android.support.design.widget.Snackbar;
import com.reddit.frontpage.C1761R;
import com.reddit.frontpage.service.video.VideoTrimService.VideoTrimEvent;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoPreviewFragment$$Lambda$11 implements Consumer {
    private final VideoPreviewFragment f29335a;

    VideoPreviewFragment$$Lambda$11(VideoPreviewFragment videoPreviewFragment) {
        this.f29335a = videoPreviewFragment;
    }

    public final void accept(Object obj) {
        VideoPreviewFragment videoPreviewFragment = this.f29335a;
        VideoTrimEvent videoTrimEvent = (VideoTrimEvent) obj;
        if (videoPreviewFragment.f39359g != null) {
            videoPreviewFragment.f39359g.a(false);
            videoPreviewFragment.f39359g = null;
        }
        if (videoTrimEvent.f21041a) {
            videoPreviewFragment.m39575b(videoTrimEvent.f21043c);
        } else {
            Snackbar.a(videoPreviewFragment.videoLayout, C1761R.string.trimming_failed, -1).a();
        }
    }
}
