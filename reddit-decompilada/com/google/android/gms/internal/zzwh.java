package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;

final class zzwh implements Runnable {
    private /* synthetic */ ErrorCode f8114a;
    private /* synthetic */ zzvx f8115b;

    zzwh(zzvx com_google_android_gms_internal_zzvx, ErrorCode errorCode) {
        this.f8115b = com_google_android_gms_internal_zzvx;
        this.f8114a = errorCode;
    }

    public final void run() {
        try {
            this.f8115b.f14698a.mo2197a(zzwj.m6772a(this.f8114a));
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdFailedToLoad.", e);
        }
    }
}
