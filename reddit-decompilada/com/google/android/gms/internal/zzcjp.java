package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;

final class zzcjp implements Runnable {
    private /* synthetic */ ConditionalUserProperty f7060a;
    private /* synthetic */ zzcjn f7061b;

    zzcjp(zzcjn com_google_android_gms_internal_zzcjn, ConditionalUserProperty conditionalUserProperty) {
        this.f7061b = com_google_android_gms_internal_zzcjn;
        this.f7060a = conditionalUserProperty;
    }

    public final void run() {
        zzcjn.m18316a(this.f7061b, this.f7060a);
    }
}
