package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement.zzb;

final class zzckl implements Runnable {
    private /* synthetic */ zzb f7114a;
    private /* synthetic */ zzckg f7115b;

    zzckl(zzckg com_google_android_gms_internal_zzckg, zzb com_google_android_gms_measurement_AppMeasurement_zzb) {
        this.f7115b = com_google_android_gms_internal_zzckg;
        this.f7114a = com_google_android_gms_measurement_AppMeasurement_zzb;
    }

    public final void run() {
        zzche e = this.f7115b.f17888c;
        if (e == null) {
            this.f7115b.mo1828t().f17816a.m5693a("Failed to send current screen to service");
            return;
        }
        try {
            long j;
            String str;
            String str2;
            String packageName;
            if (this.f7114a == null) {
                j = 0;
                str = null;
                str2 = null;
                packageName = this.f7115b.mo1820l().getPackageName();
            } else {
                j = this.f7114a.f8210d;
                str = this.f7114a.f8208b;
                str2 = this.f7114a.f8209c;
                packageName = this.f7115b.mo1820l().getPackageName();
            }
            e.mo1836a(j, str, str2, packageName);
            this.f7115b.m18395E();
        } catch (RemoteException e2) {
            this.f7115b.mo1828t().f17816a.m5694a("Failed to send current screen to the service", e2);
        }
    }
}
