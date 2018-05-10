package com.google.android.gms.internal;

final class zzhi implements Runnable {
    private /* synthetic */ zzhh f7669a;

    zzhi(zzhh com_google_android_gms_internal_zzhh) {
        this.f7669a = com_google_android_gms_internal_zzhh;
    }

    public final void run() {
        synchronized (this.f7669a.f7661c) {
            if (this.f7669a.f7665g && this.f7669a.f7666h) {
                this.f7669a.f7665g = false;
                zzakb.m5366b("App went background");
                for (zzhj d : this.f7669a.f7662d) {
                    try {
                        d.mo1716d(false);
                    } catch (Throwable e) {
                        zzakb.m5367b("OnForegroundStateChangedListener threw exception.", e);
                    }
                }
            } else {
                zzakb.m5366b("App is still foreground");
            }
        }
    }
}
