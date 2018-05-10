package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.overlay.zzd;

final class zzanl implements Runnable {
    private /* synthetic */ zzani f6644a;

    zzanl(zzani com_google_android_gms_internal_zzani) {
        this.f6644a = com_google_android_gms_internal_zzani;
    }

    public final void run() {
        this.f6644a.f6614a.mo3970G();
        zzd s = this.f6644a.f6614a.mo4011s();
        if (s != null) {
            s.f17110g.removeView(s.f17106c);
            s.m17406a(true);
        }
        if (this.f6644a.f6619f != null) {
            this.f6644a.f6619f.mo1515a();
            this.f6644a.f6619f = null;
        }
    }
}
