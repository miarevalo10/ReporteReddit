package com.google.android.gms.internal;

import android.content.ComponentName;

final class zzckw implements Runnable {
    private /* synthetic */ ComponentName f7153a;
    private /* synthetic */ zzcku f7154b;

    zzckw(zzcku com_google_android_gms_internal_zzcku, ComponentName componentName) {
        this.f7154b = com_google_android_gms_internal_zzcku;
        this.f7153a = componentName;
    }

    public final void run() {
        zzckg.m18399a(this.f7154b.f14248c, this.f7153a);
    }
}
