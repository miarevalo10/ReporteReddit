package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Function;

final /* synthetic */ class VideoUploadService$$Lambda$10 implements Function {
    static final Function $instance = new VideoUploadService$$Lambda$10();

    private VideoUploadService$$Lambda$10() {
    }

    public final Object apply(Object obj) {
        return VideoUploadService.lambda$resumeInterruptedUploads$13$VideoUploadService((VideoUpload) obj);
    }
}
