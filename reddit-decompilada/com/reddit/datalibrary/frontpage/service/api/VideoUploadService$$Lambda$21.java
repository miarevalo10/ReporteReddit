package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.BiFunction;

final /* synthetic */ class VideoUploadService$$Lambda$21 implements BiFunction {
    private final VideoUploadService arg$1;
    private final VideoUpload arg$2;

    VideoUploadService$$Lambda$21(VideoUploadService videoUploadService, VideoUpload videoUpload) {
        this.arg$1 = videoUploadService;
        this.arg$2 = videoUpload;
    }

    public final Object apply(Object obj, Object obj2) {
        return this.arg$1.lambda$null$8$VideoUploadService(this.arg$2, (VideoUpload) obj, (Boolean) obj2);
    }
}
