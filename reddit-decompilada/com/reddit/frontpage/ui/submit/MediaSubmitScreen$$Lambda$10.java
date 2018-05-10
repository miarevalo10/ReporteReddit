package com.reddit.frontpage.ui.submit;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class MediaSubmitScreen$$Lambda$10 implements Consumer {
    static final Consumer f29314a = new MediaSubmitScreen$$Lambda$10();

    private MediaSubmitScreen$$Lambda$10() {
    }

    public final void accept(Object obj) {
        Timber.c((Throwable) obj, "Failed to generate shutter image", new Object[0]);
    }
}
