package com.google.android.gms.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzcjx implements Runnable {
    private /* synthetic */ AtomicReference f7093a;
    private /* synthetic */ boolean f7094b;
    private /* synthetic */ zzcjn f7095c;

    zzcjx(zzcjn com_google_android_gms_internal_zzcjn, AtomicReference atomicReference, boolean z) {
        this.f7095c = com_google_android_gms_internal_zzcjn;
        this.f7093a = atomicReference;
        this.f7094b = z;
    }

    public final void run() {
        this.f7095c.mo1817i().m18420a(this.f7093a, this.f7094b);
    }
}
