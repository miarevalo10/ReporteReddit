package com.google.android.gms.internal;

final class zzmh implements Runnable {
    private /* synthetic */ zzmg f7845a;

    zzmh(zzmg com_google_android_gms_internal_zzmg) {
        this.f7845a = com_google_android_gms_internal_zzmg;
    }

    public final void run() {
        if (this.f7845a.f18168a != null) {
            try {
                this.f7845a.f18168a.mo1963a(1);
            } catch (Throwable e) {
                zzakb.m5369c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
