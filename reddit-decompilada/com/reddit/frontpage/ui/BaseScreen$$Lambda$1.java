package com.reddit.frontpage.ui;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

final /* synthetic */ class BaseScreen$$Lambda$1 implements Consumer {
    static final Consumer f28866a = new BaseScreen$$Lambda$1();

    private BaseScreen$$Lambda$1() {
    }

    public final void accept(Object obj) {
        Timber.c((Throwable) obj, "Error getting avatar for nav drawer icon", new Object[0]);
    }
}
