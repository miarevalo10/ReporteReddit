package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

@zzzv
public abstract class zzaan implements zzaal, zzaif<Void> {
    private final zzalh<zzaat> f14027a;
    private final zzaal f14028b;
    private final Object f14029c = new Object();

    public zzaan(zzalh<zzaat> com_google_android_gms_internal_zzalh_com_google_android_gms_internal_zzaat, zzaal com_google_android_gms_internal_zzaal) {
        this.f14027a = com_google_android_gms_internal_zzalh_com_google_android_gms_internal_zzaat;
        this.f14028b = com_google_android_gms_internal_zzaal;
    }

    public final void mo1643a(zzaax com_google_android_gms_internal_zzaax) {
        synchronized (this.f14029c) {
            this.f14028b.mo1643a(com_google_android_gms_internal_zzaax);
            mo3429b();
        }
    }

    final boolean m13144a(zzabb com_google_android_gms_internal_zzabb, zzaat com_google_android_gms_internal_zzaat) {
        try {
            com_google_android_gms_internal_zzabb.mo1651a(com_google_android_gms_internal_zzaat, new zzaaw(this));
            return true;
        } catch (Throwable th) {
            zzakb.m5369c("Could not fetch ad response from ad request service due to an Exception.", th);
            zzbs.m4490i().m13246a(th, "AdRequestClientTask.getAdResponseFromService");
            this.f14028b.mo1643a(new zzaax(0));
            return false;
        }
    }

    public abstract void mo3429b();

    public abstract zzabb mo3430c();

    public final void mo1644d() {
        mo3429b();
    }

    public final /* synthetic */ Object mo1645e() {
        zzabb c = mo3430c();
        if (c == null) {
            this.f14028b.mo1643a(new zzaax(0));
            mo3429b();
            return null;
        }
        this.f14027a.mo1736a(new zzaao(this, c), new zzaap(this));
        return null;
    }
}
