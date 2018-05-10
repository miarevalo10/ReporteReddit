package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzjj;

final class zzai implements Runnable {
    private /* synthetic */ zzjj f5502a;
    private /* synthetic */ int f5503b;
    private /* synthetic */ zzag f5504c;

    zzai(zzag com_google_android_gms_ads_internal_zzag, zzjj com_google_android_gms_internal_zzjj, int i) {
        this.f5504c = com_google_android_gms_ads_internal_zzag;
        this.f5502a = com_google_android_gms_internal_zzjj;
        this.f5503b = i;
    }

    public final void run() {
        synchronized (this.f5504c.f17152s) {
            zzag.m17483a(this.f5504c, this.f5502a, this.f5503b);
        }
    }
}
