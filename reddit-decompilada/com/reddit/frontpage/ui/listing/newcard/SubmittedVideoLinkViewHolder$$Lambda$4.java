package com.reddit.frontpage.ui.listing.newcard;

import com.reddit.datalibrary.frontpage.requests.models.v1.VideoUpload;
import io.reactivex.functions.Consumer;

final /* synthetic */ class SubmittedVideoLinkViewHolder$$Lambda$4 implements Consumer {
    private final SubmittedVideoLinkViewHolder f29136a;

    SubmittedVideoLinkViewHolder$$Lambda$4(SubmittedVideoLinkViewHolder submittedVideoLinkViewHolder) {
        this.f29136a = submittedVideoLinkViewHolder;
    }

    public final void accept(Object obj) {
        this.f29136a.m37642a((VideoUpload) obj);
    }
}
