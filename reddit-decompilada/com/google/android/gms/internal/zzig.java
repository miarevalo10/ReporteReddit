package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzf;

final class zzig implements zzf {
    private /* synthetic */ zzid f14512a;

    zzig(zzid com_google_android_gms_internal_zzid) {
        this.f14512a = com_google_android_gms_internal_zzid;
    }

    public final void mo1620a() {
        synchronized (this.f14512a.f7722b) {
            try {
                if (this.f14512a.f7723c != null) {
                    this.f14512a.f7725e = this.f14512a.f7723c.mo1649n();
                }
            } catch (Throwable e) {
                zzakb.m5367b("Unable to obtain a cache service instance.", e);
                zzid.m6312a(this.f14512a);
            }
            this.f14512a.f7722b.notifyAll();
        }
    }

    public final void mo1621a(int i) {
        synchronized (this.f14512a.f7722b) {
            this.f14512a.f7725e = null;
            this.f14512a.f7722b.notifyAll();
        }
    }
}
