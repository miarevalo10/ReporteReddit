package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoUploadService$$Lambda$14 implements Consumer {
    private final VideoUploadService arg$1;

    VideoUploadService$$Lambda$14(VideoUploadService videoUploadService) {
        this.arg$1 = videoUploadService;
    }

    public final void accept(Object obj) {
        this.arg$1.lambda$resumeInterruptedUploads$17$VideoUploadService((VideoUpload) obj);
    }
}
