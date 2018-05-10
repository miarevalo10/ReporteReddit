package com.reddit.frontpage.ui.listing;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class UserSubmittedListingScreen$$Lambda$3 implements Consumer {
    static final Consumer f29080a = new UserSubmittedListingScreen$$Lambda$3();

    private UserSubmittedListingScreen$$Lambda$3() {
    }

    public final void accept(Object obj) {
        Timber.c((Throwable) obj, "Exception on video delete bus", new Object[0]);
    }
}
