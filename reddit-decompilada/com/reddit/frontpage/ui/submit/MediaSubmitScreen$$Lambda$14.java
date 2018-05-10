package com.reddit.frontpage.ui.submit;

import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.UploadProgress;
import io.reactivex.functions.Predicate;

final /* synthetic */ class MediaSubmitScreen$$Lambda$14 implements Predicate {
    private final MediaSubmitScreen f29317a;

    MediaSubmitScreen$$Lambda$14(MediaSubmitScreen mediaSubmitScreen) {
        this.f29317a = mediaSubmitScreen;
    }

    public final boolean test(Object obj) {
        return ((UploadProgress) obj).requestId.equals(this.f29317a.submitRequestId);
    }
}
