package com.google.android.gms.internal;

import android.view.View;
import java.lang.ref.WeakReference;

public final class zzfv implements zzhd {
    private WeakReference<zzos> f14462a;

    public zzfv(zzos com_google_android_gms_internal_zzos) {
        this.f14462a = new WeakReference(com_google_android_gms_internal_zzos);
    }

    public final View mo1943a() {
        zzos com_google_android_gms_internal_zzos = (zzos) this.f14462a.get();
        return com_google_android_gms_internal_zzos != null ? com_google_android_gms_internal_zzos.mo2087h() : null;
    }

    public final boolean mo1944b() {
        return this.f14462a.get() == null;
    }

    public final zzhd mo1945c() {
        return new zzfx((zzos) this.f14462a.get());
    }
}
