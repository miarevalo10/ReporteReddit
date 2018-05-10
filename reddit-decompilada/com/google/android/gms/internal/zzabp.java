package com.google.android.gms.internal;

final class zzabp implements Runnable {
    private /* synthetic */ zzafp f6070a;
    private /* synthetic */ zzabo f6071b;

    zzabp(zzabo com_google_android_gms_internal_zzabo, zzafp com_google_android_gms_internal_zzafp) {
        this.f6071b = com_google_android_gms_internal_zzabo;
        this.f6070a = com_google_android_gms_internal_zzafp;
    }

    public final void run() {
        this.f6071b.f17488h.mo3386a(this.f6070a);
        if (this.f6071b.f17492l != null) {
            this.f6071b.f17492l.m17383a();
            this.f6071b.f17492l = null;
        }
    }
}
