package com.google.android.gms.internal;

import java.util.concurrent.Callable;

final class zzus implements Callable<zzuo> {
    private /* synthetic */ zzul f8093a;
    private /* synthetic */ zzur f8094b;

    zzus(zzur com_google_android_gms_internal_zzur, zzul com_google_android_gms_internal_zzul) {
        this.f8094b = com_google_android_gms_internal_zzur;
        this.f8093a = com_google_android_gms_internal_zzul;
    }

    private final zzuo m6689a() throws Exception {
        synchronized (this.f8094b.f14666i) {
            if (this.f8094b.f14667j) {
                return null;
            }
            return this.f8093a.m14298a(this.f8094b.f14663f, this.f8094b.f14664g);
        }
    }

    public final /* synthetic */ Object call() throws Exception {
        return m6689a();
    }
}
