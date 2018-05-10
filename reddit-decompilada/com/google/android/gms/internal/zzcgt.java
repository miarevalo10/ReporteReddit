package com.google.android.gms.internal;

import android.os.Looper;

final class zzcgt implements Runnable {
    private /* synthetic */ zzcgs f6834a;

    zzcgt(zzcgs com_google_android_gms_internal_zzcgs) {
        this.f6834a = com_google_android_gms_internal_zzcgs;
    }

    public final void run() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f6834a.f6830a.m5755f().m18271a((Runnable) this);
            return;
        }
        boolean b = this.f6834a.m5665b();
        this.f6834a.f6832d = 0;
        if (b && this.f6834a.f6833e) {
            this.f6834a.mo1850a();
        }
    }
}
