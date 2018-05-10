package com.reddit.frontpage.ui.listing.newcard.video;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class VideoLifecycleDelegate$$Lambda$5 implements Consumer {
    static final Consumer f29151a = new VideoLifecycleDelegate$$Lambda$5();

    private VideoLifecycleDelegate$$Lambda$5() {
    }

    public final void accept(Object obj) {
        Timber.c((Throwable) obj, "Exception on play subject", new Object[0]);
    }
}
