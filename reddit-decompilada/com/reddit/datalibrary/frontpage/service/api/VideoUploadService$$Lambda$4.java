package com.reddit.datalibrary.frontpage.service.api;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Predicate;

final /* synthetic */ class VideoUploadService$$Lambda$4 implements Predicate {
    static final Predicate $instance = new VideoUploadService$$Lambda$4();

    private VideoUploadService$$Lambda$4() {
    }

    public final boolean test(Object obj) {
        return VideoUploadService.lambda$retryUpload$5$VideoUploadService((VideoUpload) obj);
    }
}
