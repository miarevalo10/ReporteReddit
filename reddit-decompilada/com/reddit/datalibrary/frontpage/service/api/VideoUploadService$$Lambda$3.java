package com.reddit.datalibrary.frontpage.service.api;

import java.util.concurrent.Callable;

final /* synthetic */ class VideoUploadService$$Lambda$3 implements Callable {
    private final VideoUploadService arg$1;
    private final String arg$2;

    VideoUploadService$$Lambda$3(VideoUploadService videoUploadService, String str) {
        this.arg$1 = videoUploadService;
        this.arg$2 = str;
    }

    public final Object call() {
        return this.arg$1.lambda$retryUpload$4$VideoUploadService(this.arg$2);
    }
}
