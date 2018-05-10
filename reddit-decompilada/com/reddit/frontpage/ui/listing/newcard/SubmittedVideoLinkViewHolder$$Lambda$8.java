package com.reddit.frontpage.ui.listing.newcard;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.UploadProgress;
import io.reactivex.functions.Predicate;

final /* synthetic */ class SubmittedVideoLinkViewHolder$$Lambda$8 implements Predicate {
    private final VideoUpload f29140a;

    SubmittedVideoLinkViewHolder$$Lambda$8(VideoUpload videoUpload) {
        this.f29140a = videoUpload;
    }

    public final boolean test(Object obj) {
        return ((UploadProgress) obj).requestId.equals(this.f29140a.getRequestId());
    }
}
