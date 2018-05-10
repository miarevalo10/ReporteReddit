package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoUploadService$$Lambda$9 implements Predicate {
    static final Predicate $instance = new VideoUploadService$$Lambda$9();

    private VideoUploadService$$Lambda$9() {
    }

    public final boolean test(Object obj) {
        return VideoUploadService.lambda$resumeInterruptedUploads$12$VideoUploadService((VideoUpload) obj);
    }
}
