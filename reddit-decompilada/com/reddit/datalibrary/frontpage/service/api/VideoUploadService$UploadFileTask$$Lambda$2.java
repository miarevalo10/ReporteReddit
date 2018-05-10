package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.UploadProgress;

final /* synthetic */ class VideoUploadService$UploadFileTask$$Lambda$2 implements UploadProgressListener {
    static final UploadProgressListener $instance = new VideoUploadService$UploadFileTask$$Lambda$2();

    private VideoUploadService$UploadFileTask$$Lambda$2() {
    }

    public final void onProgress(String str, float f) {
        VideoUploadService.UPLOAD_PROGRESS_BUS.onNext(new UploadProgress(str, f));
    }
}
