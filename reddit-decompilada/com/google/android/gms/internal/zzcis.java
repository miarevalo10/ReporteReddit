package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;

final class zzcis implements Runnable {
    private /* synthetic */ zzcgi f7002a;
    private /* synthetic */ zzcir f7003b;

    zzcis(zzcir com_google_android_gms_internal_zzcir, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7003b = com_google_android_gms_internal_zzcir;
        this.f7002a = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        this.f7003b.f17869a.m5772x();
        zzcim a = this.f7003b.f17869a;
        zzcgi com_google_android_gms_internal_zzcgi = this.f7002a;
        a.m5755f().mo1811c();
        a.m5736a();
        zzbq.m4810a(com_google_android_gms_internal_zzcgi.f17759a);
        a.m5752c(com_google_android_gms_internal_zzcgi);
    }
}
