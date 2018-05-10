package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzckj implements Runnable {
    private /* synthetic */ AtomicReference f7109a;
    private /* synthetic */ zzcgi f7110b;
    private /* synthetic */ zzckg f7111c;

    zzckj(zzckg com_google_android_gms_internal_zzckg, AtomicReference atomicReference, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7111c = com_google_android_gms_internal_zzckg;
        this.f7109a = atomicReference;
        this.f7110b = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        synchronized (this.f7109a) {
            try {
                zzche e = this.f7111c.f17888c;
                if (e == null) {
                    this.f7111c.mo1828t().f17816a.m5693a("Failed to get app instance id");
                    this.f7109a.notify();
                    return;
                }
                this.f7109a.set(e.mo1845c(this.f7110b));
                String str = (String) this.f7109a.get();
                if (str != null) {
                    this.f7111c.mo1814f().m18331a(str);
                    this.f7111c.mo1829u().f17836i.m5706a(str);
                }
                this.f7111c.m18395E();
                this.f7109a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f7111c.mo1828t().f17816a.m5694a("Failed to get app instance id", e2);
                    this.f7109a.notify();
                } catch (Throwable th) {
                    this.f7109a.notify();
                }
            }
        }
    }
}
