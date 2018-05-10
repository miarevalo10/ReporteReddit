package com.reddit.frontpage.ui.listing.newcard;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class SubmittedVideoLinkViewHolder$$Lambda$5 implements Consumer {
    static final Consumer f29137a = new SubmittedVideoLinkViewHolder$$Lambda$5();

    private SubmittedVideoLinkViewHolder$$Lambda$5() {
    }

    public final void accept(Object obj) {
        Timber.c((Throwable) obj, "Failed to read video upload data from DB", new Object[0]);
    }
}
