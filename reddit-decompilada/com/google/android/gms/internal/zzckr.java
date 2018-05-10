package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzckr implements Runnable {
    private /* synthetic */ AtomicReference f7136a;
    private /* synthetic */ String f7137b;
    private /* synthetic */ String f7138c;
    private /* synthetic */ String f7139d;
    private /* synthetic */ boolean f7140e;
    private /* synthetic */ zzcgi f7141f;
    private /* synthetic */ zzckg f7142g;

    zzckr(zzckg com_google_android_gms_internal_zzckg, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzcgi com_google_android_gms_internal_zzcgi) {
        this.f7142g = com_google_android_gms_internal_zzckg;
        this.f7136a = atomicReference;
        this.f7137b = str;
        this.f7138c = str2;
        this.f7139d = str3;
        this.f7140e = z;
        this.f7141f = com_google_android_gms_internal_zzcgi;
    }

    public final void run() {
        synchronized (this.f7136a) {
            try {
                zzche e = this.f7142g.f17888c;
                if (e == null) {
                    this.f7142g.mo1828t().f17816a.m5696a("Failed to get user properties", zzchm.m18154a(this.f7137b), this.f7138c, this.f7139d);
                    this.f7136a.set(Collections.emptyList());
                    this.f7136a.notify();
                    return;
                }
                AtomicReference atomicReference;
                Object a;
                if (TextUtils.isEmpty(this.f7137b)) {
                    atomicReference = this.f7136a;
                    a = e.mo1835a(this.f7138c, this.f7139d, this.f7140e, this.f7141f);
                } else {
                    atomicReference = this.f7136a;
                    a = e.mo1834a(this.f7137b, this.f7138c, this.f7139d, this.f7140e);
                }
                atomicReference.set(a);
                this.f7142g.m18395E();
                this.f7136a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f7142g.mo1828t().f17816a.m5696a("Failed to get user properties", zzchm.m18154a(this.f7137b), this.f7138c, e2);
                    this.f7136a.set(Collections.emptyList());
                    this.f7136a.notify();
                } catch (Throwable th) {
                    this.f7136a.notify();
                }
            }
        }
    }
}
