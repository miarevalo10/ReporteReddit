package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.zzbs;

final class zzwn implements Runnable {
    private /* synthetic */ AdOverlayInfoParcel f8118a;
    private /* synthetic */ zzwl f8119b;

    zzwn(zzwl com_google_android_gms_internal_zzwl, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f8119b = com_google_android_gms_internal_zzwl;
        this.f8118a = adOverlayInfoParcel;
    }

    public final void run() {
        zzbs.m4484c();
        zzl.m4450a(this.f8119b.f18332a, this.f8118a, true);
    }
}
