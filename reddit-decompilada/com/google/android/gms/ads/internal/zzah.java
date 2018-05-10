package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzjj;

final class zzah implements Runnable {
    private /* synthetic */ zzjj f5500a;
    private /* synthetic */ zzag f5501b;

    zzah(zzag com_google_android_gms_ads_internal_zzag, zzjj com_google_android_gms_internal_zzjj) {
        this.f5501b = com_google_android_gms_ads_internal_zzag;
        this.f5500a = com_google_android_gms_internal_zzjj;
    }

    public final void run() {
        synchronized (this.f5501b.f17152s) {
            if (zzag.m17485b(this.f5501b)) {
                zzag.m17482a(this.f5501b, this.f5500a);
            } else {
                zzag.m17483a(this.f5501b, this.f5500a, 1);
            }
        }
    }
}
