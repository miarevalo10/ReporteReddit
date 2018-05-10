package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

final class zzacd implements Runnable {
    private /* synthetic */ zzaat f6100a;
    private /* synthetic */ zzabe f6101b;
    private /* synthetic */ zzacb f6102c;

    zzacd(zzacb com_google_android_gms_internal_zzacb, zzaat com_google_android_gms_internal_zzaat, zzabe com_google_android_gms_internal_zzabe) {
        this.f6102c = com_google_android_gms_internal_zzacb;
        this.f6100a = com_google_android_gms_internal_zzaat;
        this.f6101b = com_google_android_gms_internal_zzabe;
    }

    public final void run() {
        zzaax a;
        try {
            a = this.f6102c.mo1650a(this.f6100a);
        } catch (Throwable e) {
            zzbs.m4490i().m13246a(e, "AdRequestServiceImpl.loadAdAsync");
            zzakb.m5369c("Could not fetch ad response due to an Exception.", e);
            a = null;
        }
        if (a == null) {
            a = new zzaax(0);
        }
        try {
            this.f6101b.mo1653a(a);
        } catch (Throwable e2) {
            zzakb.m5369c("Fail to forward ad response.", e2);
        }
    }
}
