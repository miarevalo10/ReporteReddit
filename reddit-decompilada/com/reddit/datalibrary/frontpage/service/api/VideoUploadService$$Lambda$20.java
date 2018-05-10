package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.TranscodingCompleteEvent;
import java.util.concurrent.Callable;

final /* synthetic */ class VideoUploadService$$Lambda$20 implements Callable {
    private final VideoUploadService arg$1;
    private final TranscodingCompleteEvent arg$2;
    private final VideoUpload arg$3;

    VideoUploadService$$Lambda$20(VideoUploadService videoUploadService, TranscodingCompleteEvent transcodingCompleteEvent, VideoUpload videoUpload) {
        this.arg$1 = videoUploadService;
        this.arg$2 = transcodingCompleteEvent;
        this.arg$3 = videoUpload;
    }

    public final Object call() {
        return this.arg$1.lambda$null$7$VideoUploadService(this.arg$2, this.arg$3);
    }
}
