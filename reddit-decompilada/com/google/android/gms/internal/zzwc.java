package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;

final class zzwc implements Runnable {
    private /* synthetic */ ErrorCode f8112a;
    private /* synthetic */ zzvx f8113b;

    zzwc(zzvx com_google_android_gms_internal_zzvx, ErrorCode errorCode) {
        this.f8113b = com_google_android_gms_internal_zzvx;
        this.f8112a = errorCode;
    }

    public final void run() {
        try {
            this.f8113b.f14698a.mo2197a(zzwj.m6772a(this.f8112a));
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdFailedToLoad.", e);
        }
    }
}
