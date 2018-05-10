package com.google.android.gms.internal;

final class zzuv implements Runnable {
    private /* synthetic */ zzuo f8097a;

    zzuv(zzuo com_google_android_gms_internal_zzuo) {
        this.f8097a = com_google_android_gms_internal_zzuo;
    }

    public final void run() {
        try {
            this.f8097a.f8088c.mo2183c();
        } catch (Throwable e) {
            zzakb.m5369c("Could not destroy mediation adapter.", e);
        }
    }
}
