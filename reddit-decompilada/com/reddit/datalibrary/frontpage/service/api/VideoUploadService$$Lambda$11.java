package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoUploadService$$Lambda$11 implements Predicate {
    static final Predicate $instance = new VideoUploadService$$Lambda$11();

    private VideoUploadService$$Lambda$11() {
    }

    public final boolean test(Object obj) {
        return VideoUploadService.lambda$resumeInterruptedUploads$14$VideoUploadService((VideoUpload) obj);
    }
}
