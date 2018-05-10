package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzckt implements Runnable {
    private /* synthetic */ AtomicReference f7147a;
    private /* synthetic */ zzcgi f7148b;
    private /* synthetic */ boolean f7149c;
    private /* synthetic */ zzckg f7150d;

    zzckt(zzckg com_google_android_gms_internal_zzckg, AtomicReference atomicReference, zzcgi com_google_android_gms_internal_zzcgi, boolean z) {
        this.f7150d = com_google_android_gms_internal_zzckg;
        this.f7147a = atomicReference;
        this.f7148b = com_google_android_gms_internal_zzcgi;
        this.f7149c = z;
    }

    public final void run() {
        synchronized (this.f7147a) {
            try {
                zzche e = this.f7150d.f17888c;
                if (e == null) {
                    this.f7150d.mo1828t().f17816a.m5693a("Failed to get user properties");
                    this.f7147a.notify();
                    return;
                }
                this.f7147a.set(e.mo1831a(this.f7148b, this.f7149c));
                this.f7150d.m18395E();
                this.f7147a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f7150d.mo1828t().f17816a.m5694a("Failed to get user properties", e2);
                    this.f7147a.notify();
                } catch (Throwable th) {
                    this.f7147a.notify();
                }
            }
        }
    }
}
