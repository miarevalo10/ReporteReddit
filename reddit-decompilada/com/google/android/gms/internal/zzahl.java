package com.google.android.gms.internal;

import java.util.concurrent.Future;

final class zzahl implements Runnable {
    private /* synthetic */ zzalf f6375a;
    private /* synthetic */ Future f6376b;

    zzahl(zzalf com_google_android_gms_internal_zzalf, Future future) {
        this.f6375a = com_google_android_gms_internal_zzalf;
        this.f6376b = future;
    }

    public final void run() {
        if (this.f6375a.isCancelled()) {
            this.f6376b.cancel(true);
        }
    }
}
