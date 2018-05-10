package com.reddit.frontpage.ui.submit;

import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.UploadProgress;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class MediaSubmitScreen$$Lambda$15 implements Consumer {
    private final MediaSubmitScreen f29318a;

    MediaSubmitScreen$$Lambda$15(MediaSubmitScreen mediaSubmitScreen) {
        this.f29318a = mediaSubmitScreen;
    }

    public final void accept(Object obj) {
        Timber.b("Upload progress: %d", new Object[]{Integer.valueOf((int) (100.0f * ((UploadProgress) obj).progress))});
    }
}
