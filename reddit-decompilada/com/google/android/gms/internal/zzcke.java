package com.google.android.gms.internal;

final class zzcke implements Runnable {
    private /* synthetic */ zzckf f7105a;
    private /* synthetic */ zzckc f7106b;

    zzcke(zzckc com_google_android_gms_internal_zzckc, zzckf com_google_android_gms_internal_zzckf) {
        this.f7106b = com_google_android_gms_internal_zzckc;
        this.f7105a = com_google_android_gms_internal_zzckf;
    }

    public final void run() {
        zzckc.m18365a(this.f7106b, this.f7105a);
        this.f7106b.f17877a = null;
        this.f7106b.mo1817i().m18416a(null);
    }
}
