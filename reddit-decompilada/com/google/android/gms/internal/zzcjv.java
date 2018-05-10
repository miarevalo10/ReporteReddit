package com.google.android.gms.internal;

import android.os.Bundle;

final class zzcjv implements Runnable {
    private /* synthetic */ String f7079a;
    private /* synthetic */ String f7080b;
    private /* synthetic */ long f7081c;
    private /* synthetic */ Bundle f7082d;
    private /* synthetic */ boolean f7083e;
    private /* synthetic */ boolean f7084f;
    private /* synthetic */ boolean f7085g;
    private /* synthetic */ String f7086h = null;
    private /* synthetic */ zzcjn f7087i;

    zzcjv(zzcjn com_google_android_gms_internal_zzcjn, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3) {
        this.f7087i = com_google_android_gms_internal_zzcjn;
        this.f7079a = str;
        this.f7080b = str2;
        this.f7081c = j;
        this.f7082d = bundle;
        this.f7083e = z;
        this.f7084f = z2;
        this.f7085g = z3;
    }

    public final void run() {
        zzcjn.m18317a(this.f7087i, this.f7079a, this.f7080b, this.f7081c, this.f7082d, this.f7083e, this.f7084f, this.f7085g, this.f7086h);
    }
}
