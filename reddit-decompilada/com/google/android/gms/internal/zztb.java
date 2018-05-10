package com.google.android.gms.internal;

final class zztb implements Runnable {
    private /* synthetic */ zztc f7995a;
    private /* synthetic */ zztd f7996b;

    zztb(zztc com_google_android_gms_internal_zztc, zztd com_google_android_gms_internal_zztd) {
        this.f7995a = com_google_android_gms_internal_zztc;
        this.f7996b = com_google_android_gms_internal_zztd;
    }

    public final void run() {
        try {
            this.f7995a.mo2157a(this.f7996b);
        } catch (Throwable e) {
            zzakb.m5369c("Could not propagate interstitial ad event.", e);
        }
    }
}
