package com.google.android.gms.internal;

import java.util.concurrent.Future;

final /* synthetic */ class zzakt implements Runnable {
    private final zzakv f6504a;
    private final Future f6505b;

    zzakt(zzakv com_google_android_gms_internal_zzakv, Future future) {
        this.f6504a = com_google_android_gms_internal_zzakv;
        this.f6505b = future;
    }

    public final void run() {
        zzakv com_google_android_gms_internal_zzakv = this.f6504a;
        Future future = this.f6505b;
        if (com_google_android_gms_internal_zzakv.isCancelled()) {
            future.cancel(true);
        }
    }
}
