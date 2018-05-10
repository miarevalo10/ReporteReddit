package com.google.android.gms.internal;

public final class zzcju implements Runnable {
    private /* synthetic */ long f7077a;
    private /* synthetic */ zzcjn f7078b;

    public zzcju(zzcjn com_google_android_gms_internal_zzcjn, long j) {
        this.f7078b = com_google_android_gms_internal_zzcjn;
        this.f7077a = j;
    }

    public final void run() {
        this.f7078b.mo1829u().f17841n.m5703a(this.f7077a);
        this.f7078b.mo1828t().f17821f.m5694a("Session timeout duration set", Long.valueOf(this.f7077a));
    }
}
