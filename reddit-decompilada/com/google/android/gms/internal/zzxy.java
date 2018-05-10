package com.google.android.gms.internal;

final class zzxy implements Runnable {
    private /* synthetic */ zzafo f8144a;
    private /* synthetic */ zzxw f8145b;

    zzxy(zzxw com_google_android_gms_internal_zzxw, zzafo com_google_android_gms_internal_zzafo) {
        this.f8145b = com_google_android_gms_internal_zzxw;
        this.f8144a = com_google_android_gms_internal_zzafo;
    }

    public final void run() {
        synchronized (this.f8145b.f18337c) {
            zzxw com_google_android_gms_internal_zzxw = this.f8145b;
            com_google_android_gms_internal_zzxw.f18335a.mo3389b(this.f8144a);
        }
    }
}
