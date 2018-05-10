package com.google.android.gms.internal;

final /* synthetic */ class zzsa implements Runnable {
    private final zzrz f7984a;
    private final zzrq f7985b;
    private final zzalf f7986c;
    private final zzrr f7987d;

    zzsa(zzrz com_google_android_gms_internal_zzrz, zzrq com_google_android_gms_internal_zzrq, zzalf com_google_android_gms_internal_zzalf, zzrr com_google_android_gms_internal_zzrr) {
        this.f7984a = com_google_android_gms_internal_zzrz;
        this.f7985b = com_google_android_gms_internal_zzrq;
        this.f7986c = com_google_android_gms_internal_zzalf;
        this.f7987d = com_google_android_gms_internal_zzrr;
    }

    public final void run() {
        zzrz com_google_android_gms_internal_zzrz = this.f7984a;
        zzrq com_google_android_gms_internal_zzrq = this.f7985b;
        zzalf com_google_android_gms_internal_zzalf = this.f7986c;
        try {
            com_google_android_gms_internal_zzalf.m13330b(com_google_android_gms_internal_zzrq.mo1649n().mo2156a(this.f7987d));
        } catch (Throwable e) {
            zzakb.m5367b("Unable to obtain a cache service instance.", e);
            com_google_android_gms_internal_zzalf.m13329a(e);
            zzrx.m14243a(com_google_android_gms_internal_zzrz.f14617a);
        }
    }
}
