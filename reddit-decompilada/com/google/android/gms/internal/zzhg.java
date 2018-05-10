package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;

@zzzv
public final class zzhg {
    public final Object f7656a = new Object();
    public zzhh f7657b = null;
    public boolean f7658c = false;

    public final void m6283a(zzhj com_google_android_gms_internal_zzhj) {
        synchronized (this.f7656a) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.au)).booleanValue()) {
                if (this.f7657b == null) {
                    this.f7657b = new zzhh();
                }
                zzhh com_google_android_gms_internal_zzhh = this.f7657b;
                synchronized (com_google_android_gms_internal_zzhh.f7661c) {
                    com_google_android_gms_internal_zzhh.f7662d.add(com_google_android_gms_internal_zzhj);
                }
                return;
            }
        }
    }

    public final Activity m6282a() {
        synchronized (this.f7656a) {
            if (this.f7657b != null) {
                Activity activity = this.f7657b.f7659a;
                return activity;
            }
            return null;
        }
    }

    public final Context m6284b() {
        synchronized (this.f7656a) {
            if (this.f7657b != null) {
                Context context = this.f7657b.f7660b;
                return context;
            }
            return null;
        }
    }
}
