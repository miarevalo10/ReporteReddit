package com.google.android.gms.internal;

final class zzaag implements Runnable {
    private /* synthetic */ zzzy f6015a;

    zzaag(zzzy com_google_android_gms_internal_zzzy) {
        this.f6015a = com_google_android_gms_internal_zzzy;
    }

    public final void run() {
        synchronized (this.f6015a.f18368e) {
            if (this.f6015a.f18366c == null) {
                return;
            }
            this.f6015a.mo3385b();
            this.f6015a.m19185a(2, "Timed out waiting for ad response.");
        }
    }
}
