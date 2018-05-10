package com.reddit.frontpage.ui.submit;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class VideoPreviewFragment$$Lambda$4 implements Consumer {
    static final Consumer f29337a = new VideoPreviewFragment$$Lambda$4();

    private VideoPreviewFragment$$Lambda$4() {
    }

    public final void accept(Object obj) {
        Timber.c((Throwable) obj, "Failed to generate shutter image", new Object[0]);
    }
}
