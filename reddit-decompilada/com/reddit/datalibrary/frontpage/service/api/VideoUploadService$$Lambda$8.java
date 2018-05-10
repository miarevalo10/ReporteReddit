package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Function;

final /* synthetic */ class VideoUploadService$$Lambda$8 implements Function {
    static final Function $instance = new VideoUploadService$$Lambda$8();

    private VideoUploadService$$Lambda$8() {
    }

    public final Object apply(Object obj) {
        return VideoUploadService.lambda$cancelUploadRequest$11$VideoUploadService((VideoUpload) obj);
    }
}
