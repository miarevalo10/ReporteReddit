package com.google.android.gms.internal;

import java.util.concurrent.Future;

final class zzace implements Runnable {
    private /* synthetic */ Future f6103a;

    zzace(Future future) {
        this.f6103a = future;
    }

    public final void run() {
        if (!this.f6103a.isDone()) {
            this.f6103a.cancel(true);
        }
    }
}
