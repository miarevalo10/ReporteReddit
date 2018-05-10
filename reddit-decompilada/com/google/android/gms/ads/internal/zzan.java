package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzl;

final class zzan implements Runnable {
    private /* synthetic */ AdOverlayInfoParcel f5505a;
    private /* synthetic */ zzam f5506b;

    zzan(zzam com_google_android_gms_ads_internal_zzam, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f5506b = com_google_android_gms_ads_internal_zzam;
        this.f5505a = adOverlayInfoParcel;
    }

    public final void run() {
        zzbs.m4484c();
        zzl.m4450a(this.f5506b.f17169a.e.f5600c, this.f5505a, true);
    }
}
