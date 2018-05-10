package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;

final class zzcjq implements Runnable {
    private /* synthetic */ ConditionalUserProperty f7062a;
    private /* synthetic */ zzcjn f7063b;

    zzcjq(zzcjn com_google_android_gms_internal_zzcjn, ConditionalUserProperty conditionalUserProperty) {
        this.f7063b = com_google_android_gms_internal_zzcjn;
        this.f7062a = conditionalUserProperty;
    }

    public final void run() {
        zzcjn.m18322b(this.f7063b, this.f7062a);
    }
}
