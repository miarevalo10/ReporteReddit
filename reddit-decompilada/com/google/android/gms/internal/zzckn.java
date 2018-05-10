package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzckn implements Runnable {
    private /* synthetic */ zzcgi f7116a;
    private /* synthetic */ zzckg f7117b;

    zzckn(zzckg com_google_android_gms_internal_zzckg, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7117b = com_google_android_gms_internal_zzckg;
        this.f7116a = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        zzche e = this.f7117b.f17888c;
        if (e == null) {
            this.f7117b.mo1828t().f17816a.m5693a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            e.mo1844b(this.f7116a);
            this.f7117b.m18395E();
        } catch (RemoteException e2) {
            this.f7117b.mo1828t().f17816a.m5694a("Failed to send measurementEnabled to the service", e2);
        }
    }
}
