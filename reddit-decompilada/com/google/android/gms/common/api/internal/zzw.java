package com.google.android.gms.common.api.internal;

final class zzw implements Runnable {
    private /* synthetic */ zzv f5857a;

    zzw(zzv com_google_android_gms_common_api_internal_zzv) {
        this.f5857a = com_google_android_gms_common_api_internal_zzv;
    }

    public final void run() {
        this.f5857a.f13985m.lock();
        try {
            zzv.m13060b(this.f5857a);
        } finally {
            this.f5857a.f13985m.unlock();
        }
    }
}
