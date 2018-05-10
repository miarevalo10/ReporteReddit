package com.google.android.gms.internal;

import java.util.concurrent.Future;

final /* synthetic */ class zzakq implements Runnable {
    private final Future f6496a;

    zzakq(Future future) {
        this.f6496a = future;
    }

    public final void run() {
        Future future = this.f6496a;
        if (!future.isDone()) {
            future.cancel(true);
        }
    }
}
