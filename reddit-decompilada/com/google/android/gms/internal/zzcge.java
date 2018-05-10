package com.google.android.gms.internal;

public final class zzcge implements Runnable {
    private /* synthetic */ String f6788a;
    private /* synthetic */ long f6789b;
    private /* synthetic */ zzcgd f6790c;

    public zzcge(zzcgd com_google_android_gms_internal_zzcgd, String str, long j) {
        this.f6790c = com_google_android_gms_internal_zzcgd;
        this.f6788a = str;
        this.f6789b = j;
    }

    public final void run() {
        zzcgd.m13457a(this.f6790c, this.f6788a, this.f6789b);
    }
}
