package com.reddit.frontpage.ui.detail;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class BaseDetailScreen$$Lambda$22 implements Consumer {
    static final Consumer f28936a = new BaseDetailScreen$$Lambda$22();

    private BaseDetailScreen$$Lambda$22() {
    }

    public final void accept(Object obj) {
        Timber.c((Throwable) obj, "Error getting post flairs", new Object[0]);
    }
}
