package com.google.android.gms.internal;

final class zzcjw implements Runnable {
    private /* synthetic */ String f7088a;
    private /* synthetic */ String f7089b;
    private /* synthetic */ Object f7090c;
    private /* synthetic */ long f7091d;
    private /* synthetic */ zzcjn f7092e;

    zzcjw(zzcjn com_google_android_gms_internal_zzcjn, String str, String str2, Object obj, long j) {
        this.f7092e = com_google_android_gms_internal_zzcjn;
        this.f7088a = str;
        this.f7089b = str2;
        this.f7090c = obj;
        this.f7091d = j;
    }

    public final void run() {
        zzcjn.m18318a(this.f7092e, this.f7088a, this.f7089b, this.f7090c, this.f7091d);
    }
}
