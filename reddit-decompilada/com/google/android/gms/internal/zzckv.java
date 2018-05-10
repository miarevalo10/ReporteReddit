package com.google.android.gms.internal;

final class zzckv implements Runnable {
    private /* synthetic */ zzche f7151a;
    private /* synthetic */ zzcku f7152b;

    zzckv(zzcku com_google_android_gms_internal_zzcku, zzche com_google_android_gms_internal_zzche) {
        this.f7152b = com_google_android_gms_internal_zzcku;
        this.f7151a = com_google_android_gms_internal_zzche;
    }

    public final void run() {
        synchronized (this.f7152b) {
            this.f7152b.f14246a = false;
            if (!this.f7152b.f14248c.m18443y()) {
                this.f7152b.f14248c.mo1828t().f17822g.m5693a("Connected to service");
                this.f7152b.f14248c.m18413a(this.f7151a);
            }
        }
    }
}
