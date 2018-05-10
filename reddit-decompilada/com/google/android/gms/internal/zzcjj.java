package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement.zzb;

final class zzcjj implements Runnable {
    private /* synthetic */ String f7051a;
    private /* synthetic */ String f7052b;
    private /* synthetic */ String f7053c;
    private /* synthetic */ long f7054d;
    private /* synthetic */ zzcir f7055e;

    zzcjj(zzcir com_google_android_gms_internal_zzcir, String str, String str2, String str3, long j) {
        this.f7055e = com_google_android_gms_internal_zzcir;
        this.f7051a = str;
        this.f7052b = str2;
        this.f7053c = str3;
        this.f7054d = j;
    }

    public final void run() {
        if (this.f7051a == null) {
            this.f7055e.f17869a.m5762m().m18370a(this.f7052b, null);
            return;
        }
        zzb com_google_android_gms_measurement_AppMeasurement_zzb = new zzb();
        com_google_android_gms_measurement_AppMeasurement_zzb.f8208b = this.f7053c;
        com_google_android_gms_measurement_AppMeasurement_zzb.f8209c = this.f7051a;
        com_google_android_gms_measurement_AppMeasurement_zzb.f8210d = this.f7054d;
        this.f7055e.f17869a.m5762m().m18370a(this.f7052b, com_google_android_gms_measurement_AppMeasurement_zzb);
    }
}
