package com.google.android.gms.internal;

import com.google.android.gms.dynamic.zzn;

final class zzaea implements Runnable {
    private /* synthetic */ zzva f6237a;
    private /* synthetic */ zzjj f6238b;
    private /* synthetic */ zzaeg f6239c;
    private /* synthetic */ zzady f6240d;

    zzaea(zzady com_google_android_gms_internal_zzady, zzva com_google_android_gms_internal_zzva, zzjj com_google_android_gms_internal_zzjj, zzaeg com_google_android_gms_internal_zzaeg) {
        this.f6240d = com_google_android_gms_internal_zzady;
        this.f6237a = com_google_android_gms_internal_zzva;
        this.f6238b = com_google_android_gms_internal_zzjj;
        this.f6239c = com_google_android_gms_internal_zzaeg;
    }

    public final void run() {
        try {
            this.f6237a.mo2173a(zzn.m17692a(this.f6240d.f17511c), this.f6238b, null, this.f6239c, this.f6240d.f17516h);
        } catch (Throwable e) {
            String str = "Fail to initialize adapter ";
            String valueOf = String.valueOf(this.f6240d.f17515g);
            zzakb.m5369c(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
            this.f6240d.mo3431a(0);
        }
    }
}
