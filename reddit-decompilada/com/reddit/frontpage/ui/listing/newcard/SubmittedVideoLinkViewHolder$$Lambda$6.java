package com.reddit.frontpage.ui.listing.newcard;

import com.reddit.datalibrary.frontpage.service.api.VideoUploadService.VideoState;
import io.reactivex.functions.Predicate;

final /* synthetic */ class SubmittedVideoLinkViewHolder$$Lambda$6 implements Predicate {
    private final String f29138a;

    SubmittedVideoLinkViewHolder$$Lambda$6(String str) {
        this.f29138a = str;
    }

    public final boolean test(Object obj) {
        return ((VideoState) obj).requestId.equals(this.f29138a);
    }
}
