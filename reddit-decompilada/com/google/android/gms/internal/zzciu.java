package com.google.android.gms.internal;

final class zzciu implements Runnable {
    private /* synthetic */ zzcgl f7007a;
    private /* synthetic */ zzcgi f7008b;
    private /* synthetic */ zzcir f7009c;

    zzciu(zzcir com_google_android_gms_internal_zzcir, zzcgl com_google_android_gms_internal_zzcgl, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7009c = com_google_android_gms_internal_zzcir;
        this.f7007a = com_google_android_gms_internal_zzcgl;
        this.f7008b = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        this.f7009c.f17869a.m5772x();
        this.f7009c.f17869a.m5740a(this.f7007a, this.f7008b);
    }
}
