package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.UploadProgress;
import io.reactivex.functions.Consumer;

final /* synthetic */ class VideoUploadService$UploadFileTask$$Lambda$1 implements Consumer {
    private final UploadFileTask arg$1;
    private final String arg$2;

    VideoUploadService$UploadFileTask$$Lambda$1(UploadFileTask uploadFileTask, String str) {
        this.arg$1 = uploadFileTask;
        this.arg$2 = str;
    }

    public final void accept(Object obj) {
        this.arg$1.lambda$setupProgressListener$1$VideoUploadService$UploadFileTask(this.arg$2, (UploadProgress) obj);
    }
}
