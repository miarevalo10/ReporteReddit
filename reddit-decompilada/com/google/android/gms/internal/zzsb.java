package com.google.android.gms.internal;

import java.util.concurrent.Future;

final /* synthetic */ class zzsb implements Runnable {
    private final zzalf f7988a;
    private final Future f7989b;

    zzsb(zzalf com_google_android_gms_internal_zzalf, Future future) {
        this.f7988a = com_google_android_gms_internal_zzalf;
        this.f7989b = future;
    }

    public final void run() {
        zzalf com_google_android_gms_internal_zzalf = this.f7988a;
        Future future = this.f7989b;
        if (com_google_android_gms_internal_zzalf.isCancelled()) {
            future.cancel(true);
        }
    }
}
