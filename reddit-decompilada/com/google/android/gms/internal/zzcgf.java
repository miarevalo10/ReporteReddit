package com.google.android.gms.internal;

public final class zzcgf implements Runnable {
    private /* synthetic */ String f6791a;
    private /* synthetic */ long f6792b;
    private /* synthetic */ zzcgd f6793c;

    public zzcgf(zzcgd com_google_android_gms_internal_zzcgd, String str, long j) {
        this.f6793c = com_google_android_gms_internal_zzcgd;
        this.f6791a = str;
        this.f6792b = j;
    }

    public final void run() {
        zzcgd.m13460b(this.f6793c, this.f6791a, this.f6792b);
    }
}
