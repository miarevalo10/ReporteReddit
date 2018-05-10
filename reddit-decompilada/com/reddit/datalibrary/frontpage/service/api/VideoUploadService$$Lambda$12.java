package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Function;

final /* synthetic */ class VideoUploadService$$Lambda$12 implements Function {
    private final VideoUploadService arg$1;

    VideoUploadService$$Lambda$12(VideoUploadService videoUploadService) {
        this.arg$1 = videoUploadService;
    }

    public final Object apply(Object obj) {
        return this.arg$1.lambda$resumeInterruptedUploads$15$VideoUploadService((VideoUpload) obj);
    }
}
