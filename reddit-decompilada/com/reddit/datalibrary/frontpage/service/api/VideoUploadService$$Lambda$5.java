package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Function;

final /* synthetic */ class VideoUploadService$$Lambda$5 implements Function {
    private final VideoUploadService arg$1;
    private final String arg$2;

    VideoUploadService$$Lambda$5(VideoUploadService videoUploadService, String str) {
        this.arg$1 = videoUploadService;
        this.arg$2 = str;
    }

    public final Object apply(Object obj) {
        return this.arg$1.lambda$retryUpload$6$VideoUploadService(this.arg$2, (VideoUpload) obj);
    }
}
