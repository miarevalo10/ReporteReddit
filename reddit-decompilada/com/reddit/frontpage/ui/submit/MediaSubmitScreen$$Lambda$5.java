package com.reddit.frontpage.ui.submit;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Consumer;

final /* synthetic */ class MediaSubmitScreen$$Lambda$5 implements Consumer {
    private final MediaSubmitScreen f29323a;

    MediaSubmitScreen$$Lambda$5(MediaSubmitScreen mediaSubmitScreen) {
        this.f29323a = mediaSubmitScreen;
    }

    public final void accept(Object obj) {
        this.f29323a.m41123a((VideoUpload) obj);
    }
}
