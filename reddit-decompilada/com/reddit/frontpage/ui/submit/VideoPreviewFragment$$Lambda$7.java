package com.reddit.frontpage.ui.submit;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class VideoPreviewFragment$$Lambda$7 implements Consumer {
    private final VideoPreviewFragment f29340a;

    VideoPreviewFragment$$Lambda$7(VideoPreviewFragment videoPreviewFragment) {
        this.f29340a = videoPreviewFragment;
    }

    public final void accept(Object obj) {
        obj = this.f29340a;
        Timber.b("Player end event received", new Object[0]);
        if (obj.gifSwitch.isChecked()) {
            obj.f39356b.m24358a(obj.f39358d != null ? ((long) obj.f39358d.f22104b) * 1000 : 0);
        } else {
            obj.f39356b.m24368d();
        }
    }
}
