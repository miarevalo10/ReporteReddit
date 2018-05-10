package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzckk implements Runnable {
    private /* synthetic */ zzcgi f7112a;
    private /* synthetic */ zzckg f7113b;

    zzckk(zzckg com_google_android_gms_internal_zzckg, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7113b = com_google_android_gms_internal_zzckg;
        this.f7112a = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        zzche e = this.f7113b.f17888c;
        if (e == null) {
            this.f7113b.mo1828t().f17816a.m5693a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            e.mo1837a(this.f7112a);
            this.f7113b.m18414a(e, null, this.f7112a);
            this.f7113b.m18395E();
        } catch (RemoteException e2) {
            this.f7113b.mo1828t().f17816a.m5694a("Failed to send app launch to the service", e2);
        }
    }
}
