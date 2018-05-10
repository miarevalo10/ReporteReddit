package com.google.android.gms.internal;

final class zzmf implements Runnable {
    private /* synthetic */ zzme f7844a;

    zzmf(zzme com_google_android_gms_internal_zzme) {
        this.f7844a = com_google_android_gms_internal_zzme;
    }

    public final void run() {
        if (this.f7844a.f18167a.f18166a != null) {
            try {
                this.f7844a.f18167a.f18166a.mo1963a(1);
            } catch (Throwable e) {
                zzakb.m5369c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
