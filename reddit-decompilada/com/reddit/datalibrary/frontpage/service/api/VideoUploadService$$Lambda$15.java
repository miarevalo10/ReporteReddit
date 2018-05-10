package com.reddit.datalibrary.frontpage.service.api;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class VideoUploadService$$Lambda$15 implements Consumer {
    static final Consumer $instance = new VideoUploadService$$Lambda$15();

    private VideoUploadService$$Lambda$15() {
    }

    public final void accept(Object obj) {
        Timber.c((Throwable) obj, "Error reading DB for interrupted uploads", new Object[0]);
    }
}
