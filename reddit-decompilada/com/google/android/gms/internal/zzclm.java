package com.google.android.gms.internal;

import android.content.Intent;

final class zzclm extends zzcgs {
    private /* synthetic */ zzcll f14252a;

    zzclm(zzcll com_google_android_gms_internal_zzcll, zzcim com_google_android_gms_internal_zzcim) {
        this.f14252a = com_google_android_gms_internal_zzcll;
        super(com_google_android_gms_internal_zzcim);
    }

    public final void mo1850a() {
        this.f14252a.m18500y();
        this.f14252a.mo1828t().f17822g.m5693a("Sending upload intent from DelayedRunnable");
        Intent className = new Intent().setClassName(this.f14252a.mo1820l(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        this.f14252a.mo1820l().sendBroadcast(className);
    }
}
