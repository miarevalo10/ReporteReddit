package com.google.android.gms.internal;

final class zzcit implements Runnable {
    private /* synthetic */ zzcgl f7004a;
    private /* synthetic */ zzcgi f7005b;
    private /* synthetic */ zzcir f7006c;

    zzcit(zzcir com_google_android_gms_internal_zzcir, zzcgl com_google_android_gms_internal_zzcgl, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7006c = com_google_android_gms_internal_zzcir;
        this.f7004a = com_google_android_gms_internal_zzcgl;
        this.f7005b = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        this.f7006c.f17869a.m5772x();
        this.f7006c.f17869a.m5747b(this.f7004a, this.f7005b);
    }
}
