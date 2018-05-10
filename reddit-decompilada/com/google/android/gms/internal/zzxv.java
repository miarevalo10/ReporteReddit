package com.google.android.gms.internal;

final class zzxv implements Runnable {
    private /* synthetic */ zzxu f8142a;

    zzxv(zzxu com_google_android_gms_internal_zzxu) {
        this.f8142a = com_google_android_gms_internal_zzxu;
    }

    public final void run() {
        if (this.f8142a.f14748h.get()) {
            zzakb.m5368c("Timed out waiting for WebView to finish loading.");
            this.f8142a.mo1644d();
        }
    }
}
