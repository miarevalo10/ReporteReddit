package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzcki implements Runnable {
    private /* synthetic */ zzcgi f7107a;
    private /* synthetic */ zzckg f7108b;

    zzcki(zzckg com_google_android_gms_internal_zzckg, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7108b = com_google_android_gms_internal_zzckg;
        this.f7107a = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        zzche e = this.f7108b.f17888c;
        if (e == null) {
            this.f7108b.mo1828t().f17816a.m5693a("Failed to reset data on the service; null service");
            return;
        }
        try {
            e.mo1846d(this.f7107a);
        } catch (RemoteException e2) {
            this.f7108b.mo1828t().f17816a.m5694a("Failed to reset data on the service", e2);
        }
        this.f7108b.m18395E();
    }
}
