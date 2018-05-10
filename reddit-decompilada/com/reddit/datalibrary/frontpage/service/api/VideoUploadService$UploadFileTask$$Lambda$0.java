package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.UploadProgress;
import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoUploadService$UploadFileTask$$Lambda$0 implements Predicate {
    private final UploadFileTask arg$1;

    VideoUploadService$UploadFileTask$$Lambda$0(UploadFileTask uploadFileTask) {
        this.arg$1 = uploadFileTask;
    }

    public final boolean test(Object obj) {
        return this.arg$1.lambda$setupProgressListener$0$VideoUploadService$UploadFileTask((UploadProgress) obj);
    }
}
