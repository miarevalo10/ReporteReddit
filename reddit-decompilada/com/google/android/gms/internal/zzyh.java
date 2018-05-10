package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzaq;
import java.util.concurrent.CountDownLatch;

final class zzyh implements Runnable {
    private /* synthetic */ CountDownLatch f8149a;
    private /* synthetic */ zzyg f8150b;

    zzyh(zzyg com_google_android_gms_internal_zzyg, CountDownLatch countDownLatch) {
        this.f8150b = com_google_android_gms_internal_zzyg;
        this.f8149a = countDownLatch;
    }

    public final void run() {
        synchronized (this.f8150b.d) {
            this.f8150b.f19246m = zzaq.m4466a(this.f8150b.f19245l, this.f8150b.f19240g, this.f8149a);
        }
    }
}
