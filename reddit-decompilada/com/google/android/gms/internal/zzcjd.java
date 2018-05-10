package com.google.android.gms.internal;

final class zzcjd implements Runnable {
    private /* synthetic */ zzcha f7035a;
    private /* synthetic */ String f7036b;
    private /* synthetic */ zzcir f7037c;

    zzcjd(zzcir com_google_android_gms_internal_zzcir, zzcha com_google_android_gms_internal_zzcha, String str) {
        this.f7037c = com_google_android_gms_internal_zzcir;
        this.f7035a = com_google_android_gms_internal_zzcha;
        this.f7036b = str;
    }

    public final void run() {
        this.f7037c.f17869a.m5772x();
        this.f7037c.f17869a.m5742a(this.f7035a, this.f7036b);
    }
}
