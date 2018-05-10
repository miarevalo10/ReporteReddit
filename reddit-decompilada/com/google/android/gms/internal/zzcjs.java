package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcjs implements Runnable {
    private /* synthetic */ AtomicReference f7069a;
    private /* synthetic */ String f7070b;
    private /* synthetic */ String f7071c;
    private /* synthetic */ String f7072d;
    private /* synthetic */ boolean f7073e;
    private /* synthetic */ zzcjn f7074f;

    zzcjs(zzcjn com_google_android_gms_internal_zzcjn, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f7074f = com_google_android_gms_internal_zzcjn;
        this.f7069a = atomicReference;
        this.f7070b = str;
        this.f7071c = str2;
        this.f7072d = str3;
        this.f7073e = z;
    }

    public final void run() {
        this.f7074f.s.m5763n().m18419a(this.f7069a, this.f7070b, this.f7071c, this.f7072d, this.f7073e);
    }
}
