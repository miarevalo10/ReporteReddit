package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzckq implements Runnable {
    private /* synthetic */ AtomicReference f7130a;
    private /* synthetic */ String f7131b;
    private /* synthetic */ String f7132c;
    private /* synthetic */ String f7133d;
    private /* synthetic */ zzcgi f7134e;
    private /* synthetic */ zzckg f7135f;

    zzckq(zzckg com_google_android_gms_internal_zzckg, AtomicReference atomicReference, String str, String str2, String str3, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7135f = com_google_android_gms_internal_zzckg;
        this.f7130a = atomicReference;
        this.f7131b = str;
        this.f7132c = str2;
        this.f7133d = str3;
        this.f7134e = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        synchronized (this.f7130a) {
            try {
                zzche e = this.f7135f.f17888c;
                if (e == null) {
                    this.f7135f.mo1828t().f17816a.m5696a("Failed to get conditional properties", zzchm.m18154a(this.f7131b), this.f7132c, this.f7133d);
                    this.f7130a.set(Collections.emptyList());
                    this.f7130a.notify();
                    return;
                }
                AtomicReference atomicReference;
                Object a;
                if (TextUtils.isEmpty(this.f7131b)) {
                    atomicReference = this.f7130a;
                    a = e.mo1832a(this.f7132c, this.f7133d, this.f7134e);
                } else {
                    atomicReference = this.f7130a;
                    a = e.mo1833a(this.f7131b, this.f7132c, this.f7133d);
                }
                atomicReference.set(a);
                this.f7135f.m18395E();
                this.f7130a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f7135f.mo1828t().f17816a.m5696a("Failed to get conditional properties", zzchm.m18154a(this.f7131b), this.f7132c, e2);
                    this.f7130a.set(Collections.emptyList());
                    this.f7130a.notify();
                } catch (Throwable th) {
                    this.f7130a.notify();
                }
            }
        }
    }
}
