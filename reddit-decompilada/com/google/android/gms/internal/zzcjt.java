package com.google.android.gms.internal;

public final class zzcjt implements Runnable {
    private /* synthetic */ long f7075a;
    private /* synthetic */ zzcjn f7076b;

    public zzcjt(zzcjn com_google_android_gms_internal_zzcjn, long j) {
        this.f7076b = com_google_android_gms_internal_zzcjn;
        this.f7075a = j;
    }

    public final void run() {
        this.f7076b.mo1829u().f17840m.m5703a(this.f7075a);
        this.f7076b.mo1828t().f17821f.m5694a("Minimum session duration set", Long.valueOf(this.f7075a));
    }
}
