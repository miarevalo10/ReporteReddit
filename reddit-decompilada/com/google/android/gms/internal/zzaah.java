package com.google.android.gms.internal;

import android.content.Context;

final class zzaah implements Runnable {
    private /* synthetic */ zzalh f6016a;
    private /* synthetic */ zzzy f6017b;

    zzaah(zzzy com_google_android_gms_internal_zzzy, zzalh com_google_android_gms_internal_zzalh) {
        this.f6017b = com_google_android_gms_internal_zzzy;
        this.f6016a = com_google_android_gms_internal_zzalh;
    }

    public final void run() {
        synchronized (this.f6017b.f18368e) {
            zzaif com_google_android_gms_internal_zzaaq;
            zzzy com_google_android_gms_internal_zzzy = this.f6017b;
            zzaal com_google_android_gms_internal_zzaal = this.f6017b;
            zzakd com_google_android_gms_internal_zzakd = this.f6017b.f18364a.f6051j;
            zzalh com_google_android_gms_internal_zzalh = this.f6016a;
            Context context = com_google_android_gms_internal_zzaal.f18365b;
            if (new zzaak(context).mo1642a(com_google_android_gms_internal_zzakd)) {
                zzakb.m5366b("Fetching ad response from local ad request service.");
                com_google_android_gms_internal_zzaaq = new zzaaq(context, com_google_android_gms_internal_zzalh, com_google_android_gms_internal_zzaal);
                com_google_android_gms_internal_zzaaq.mo1645e();
            } else {
                zzakb.m5366b("Fetching ad response from remote ad request service.");
                zzkb.m6345a();
                if (zzajr.m5335c(context)) {
                    com_google_android_gms_internal_zzaaq = new zzaar(context, com_google_android_gms_internal_zzakd, com_google_android_gms_internal_zzalh, com_google_android_gms_internal_zzaal);
                } else {
                    zzakb.m5371e("Failed to connect to remote ad request service.");
                    com_google_android_gms_internal_zzaaq = null;
                }
            }
            com_google_android_gms_internal_zzzy.f18366c = com_google_android_gms_internal_zzaaq;
            if (this.f6017b.f18366c == null) {
                this.f6017b.m19185a(0, "Could not start the ad request service.");
                zzahn.f6379a.removeCallbacks(this.f6017b.f18372i);
            }
        }
    }
}
