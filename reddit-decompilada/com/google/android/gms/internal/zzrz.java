package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzf;

final class zzrz implements zzf {
    final /* synthetic */ zzrx f14617a;
    private /* synthetic */ zzalf f14618b;
    private /* synthetic */ zzrr f14619c;

    zzrz(zzrx com_google_android_gms_internal_zzrx, zzalf com_google_android_gms_internal_zzalf, zzrr com_google_android_gms_internal_zzrr) {
        this.f14617a = com_google_android_gms_internal_zzrx;
        this.f14618b = com_google_android_gms_internal_zzalf;
        this.f14619c = com_google_android_gms_internal_zzrr;
    }

    public final void mo1620a() {
        synchronized (this.f14617a.f14616d) {
            if (this.f14617a.f14614b) {
                return;
            }
            this.f14617a.f14614b = true;
            zzrq e = this.f14617a.f14613a;
            if (e == null) {
                return;
            }
            this.f14618b.mo1732a(new zzsb(this.f14618b, zzahh.m5148a(new zzsa(this, e, this.f14618b, this.f14619c))), zzala.f6512b);
        }
    }

    public final void mo1621a(int i) {
    }
}
