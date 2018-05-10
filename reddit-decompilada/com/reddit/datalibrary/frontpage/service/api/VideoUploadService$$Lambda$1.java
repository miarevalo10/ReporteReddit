package com.reddit.datalibrary.frontpage.service.api;

import java.util.concurrent.Callable;

final /* synthetic */ class VideoUploadService$$Lambda$1 implements Callable {
    private final VideoUploadService arg$1;
    private final String arg$2;
    private final String arg$3;
    private final boolean arg$4;

    VideoUploadService$$Lambda$1(VideoUploadService videoUploadService, String str, String str2, boolean z) {
        this.arg$1 = videoUploadService;
        this.arg$2 = str;
        this.arg$3 = str2;
        this.arg$4 = z;
    }

    public final Object call() {
        return this.arg$1.lambda$uploadVideoFile$2$VideoUploadService(this.arg$2, this.arg$3, this.arg$4);
    }
}
