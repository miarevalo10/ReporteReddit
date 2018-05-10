package com.reddit.datalibrary.frontpage.service.api;

import java.util.concurrent.Callable;

final /* synthetic */ class VideoUploadService$$Lambda$7 implements Callable {
    private final VideoUploadService arg$1;
    private final String arg$2;

    VideoUploadService$$Lambda$7(VideoUploadService videoUploadService, String str) {
        this.arg$1 = videoUploadService;
        this.arg$2 = str;
    }

    public final Object call() {
        return this.arg$1.lambda$cancelUploadRequest$10$VideoUploadService(this.arg$2);
    }
}
