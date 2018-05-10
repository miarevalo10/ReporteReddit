package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class zzbg extends zzby {
    private WeakReference<zzba> f13929a;

    zzbg(zzba com_google_android_gms_common_api_internal_zzba) {
        this.f13929a = new WeakReference(com_google_android_gms_common_api_internal_zzba);
    }

    public final void mo1603a() {
        zzba com_google_android_gms_common_api_internal_zzba = (zzba) this.f13929a.get();
        if (com_google_android_gms_common_api_internal_zzba != null) {
            zzba.m12953a(com_google_android_gms_common_api_internal_zzba);
        }
    }
}
