package com.google.android.gms.internal;

import android.content.Context;

final class zzahp implements Runnable {
    private /* synthetic */ Context f6387a;
    private /* synthetic */ zzahn f6388b;

    zzahp(zzahn com_google_android_gms_internal_zzahn, Context context) {
        this.f6388b = com_google_android_gms_internal_zzahn;
        this.f6387a = context;
    }

    public final void run() {
        synchronized (this.f6388b.f6381c) {
            this.f6388b.f6383e = zzahn.m5198c(this.f6387a);
            this.f6388b.f6381c.notifyAll();
        }
    }
}
