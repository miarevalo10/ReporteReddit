package com.google.android.gms.internal;

final class zzk implements Runnable {
    private final zzr f7766a;
    private final zzw f7767b;
    private final Runnable f7768c;

    public zzk(zzr com_google_android_gms_internal_zzr, zzw com_google_android_gms_internal_zzw, Runnable runnable) {
        this.f7766a = com_google_android_gms_internal_zzr;
        this.f7767b = com_google_android_gms_internal_zzw;
        this.f7768c = runnable;
    }

    public final void run() {
        if ((this.f7767b.f8110c == null ? 1 : null) != null) {
            this.f7766a.mo1728a(this.f7767b.f8108a);
        } else {
            zzr com_google_android_gms_internal_zzr = this.f7766a;
            zzad com_google_android_gms_internal_zzad = this.f7767b.f8110c;
            if (com_google_android_gms_internal_zzr.f7969d != null) {
                com_google_android_gms_internal_zzr.f7969d.mo1726a(com_google_android_gms_internal_zzad);
            }
        }
        if (this.f7767b.f8111d) {
            this.f7766a.m6628b("intermediate-response");
        } else {
            this.f7766a.m6630c("done");
        }
        if (this.f7768c != null) {
            this.f7768c.run();
        }
    }
}
