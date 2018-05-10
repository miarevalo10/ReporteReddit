package com.reddit.frontpage.ui.listing.newcard;

import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.UploadProgress;
import io.reactivex.functions.Consumer;

final /* synthetic */ class SubmittedVideoLinkViewHolder$$Lambda$9 implements Consumer {
    private final SubmittedVideoLinkViewHolder f29141a;

    SubmittedVideoLinkViewHolder$$Lambda$9(SubmittedVideoLinkViewHolder submittedVideoLinkViewHolder) {
        this.f29141a = submittedVideoLinkViewHolder;
    }

    public final void accept(Object obj) {
        this.f29141a.linkProgress.setProgress((int) (100.0f * ((UploadProgress) obj).progress));
    }
}
