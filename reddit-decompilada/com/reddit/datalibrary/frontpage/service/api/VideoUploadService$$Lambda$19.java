package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoUploadService$$Lambda$19 implements Predicate {
    static final Predicate $instance = new VideoUploadService$$Lambda$19();

    private VideoUploadService$$Lambda$19() {
    }

    public final boolean test(Object obj) {
        return VideoUploadService.lambda$getInterruptedUploads$21$VideoUploadService((VideoUpload) obj);
    }
}
