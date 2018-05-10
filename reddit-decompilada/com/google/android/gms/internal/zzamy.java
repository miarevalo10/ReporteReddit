package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzamy implements Runnable {
    private /* synthetic */ zzamx f6589a;

    zzamy(zzamx com_google_android_gms_internal_zzamx) {
        this.f6589a = com_google_android_gms_internal_zzamx;
    }

    public final void run() {
        zzamz x = zzbs.m4505x();
        x.f6590a.remove(this.f6589a);
    }
}
