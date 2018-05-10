package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcjz implements Runnable {
    private /* synthetic */ AtomicReference f7097a;
    private /* synthetic */ zzcjn f7098b;

    zzcjz(zzcjn com_google_android_gms_internal_zzcjn, AtomicReference atomicReference) {
        this.f7098b = com_google_android_gms_internal_zzcjn;
        this.f7097a = atomicReference;
    }

    public final void run() {
        this.f7098b.mo1817i().m18417a(this.f7097a);
    }
}
