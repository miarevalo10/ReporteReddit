package com.google.android.gms.internal;

final class zzckx implements Runnable {
    private /* synthetic */ zzche f7155a;
    private /* synthetic */ zzcku f7156b;

    zzckx(zzcku com_google_android_gms_internal_zzcku, zzche com_google_android_gms_internal_zzche) {
        this.f7156b = com_google_android_gms_internal_zzcku;
        this.f7155a = com_google_android_gms_internal_zzche;
    }

    public final void run() {
        synchronized (this.f7156b) {
            this.f7156b.f14246a = false;
            if (!this.f7156b.f14248c.m18443y()) {
                this.f7156b.f14248c.mo1828t().f17821f.m5693a("Connected to remote service");
                this.f7156b.f14248c.m18413a(this.f7155a);
            }
        }
    }
}
