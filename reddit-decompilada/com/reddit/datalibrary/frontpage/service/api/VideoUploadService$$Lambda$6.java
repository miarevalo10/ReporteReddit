package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.TranscodingCompleteEvent;
import io.reactivex.functions.Function;

final /* synthetic */ class VideoUploadService$$Lambda$6 implements Function {
    private final VideoUploadService arg$1;
    private final VideoUpload arg$2;

    VideoUploadService$$Lambda$6(VideoUploadService videoUploadService, VideoUpload videoUpload) {
        this.arg$1 = videoUploadService;
        this.arg$2 = videoUpload;
    }

    public final Object apply(Object obj) {
        return this.arg$1.lambda$onTranscodingComplete$9$VideoUploadService(this.arg$2, (TranscodingCompleteEvent) obj);
    }
}
