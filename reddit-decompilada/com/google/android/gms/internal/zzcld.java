package com.google.android.gms.internal;

import java.util.ArrayList;

final class zzcld implements Runnable {
    private /* synthetic */ zzcim f7167a;
    private /* synthetic */ Runnable f7168b;

    zzcld(zzcim com_google_android_gms_internal_zzcim, Runnable runnable) {
        this.f7167a = com_google_android_gms_internal_zzcim;
        this.f7168b = runnable;
    }

    public final void run() {
        this.f7167a.m5772x();
        zzcim com_google_android_gms_internal_zzcim = this.f7167a;
        Runnable runnable = this.f7168b;
        com_google_android_gms_internal_zzcim.m5755f().mo1811c();
        if (com_google_android_gms_internal_zzcim.f6983j == null) {
            com_google_android_gms_internal_zzcim.f6983j = new ArrayList();
        }
        com_google_android_gms_internal_zzcim.f6983j.add(runnable);
        this.f7167a.m5769u();
    }
}
