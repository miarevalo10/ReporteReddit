package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcjr implements Runnable {
    private /* synthetic */ AtomicReference f7064a;
    private /* synthetic */ String f7065b;
    private /* synthetic */ String f7066c;
    private /* synthetic */ String f7067d;
    private /* synthetic */ zzcjn f7068e;

    zzcjr(zzcjn com_google_android_gms_internal_zzcjn, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f7068e = com_google_android_gms_internal_zzcjn;
        this.f7064a = atomicReference;
        this.f7065b = str;
        this.f7066c = str2;
        this.f7067d = str3;
    }

    public final void run() {
        this.f7068e.s.m5763n().m18418a(this.f7064a, this.f7065b, this.f7066c, this.f7067d);
    }
}
