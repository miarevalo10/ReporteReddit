package com.google.android.gms.common.api.internal;

abstract class zzbj {
    private final zzbh f5771a;

    protected zzbj(zzbh com_google_android_gms_common_api_internal_zzbh) {
        this.f5771a = com_google_android_gms_common_api_internal_zzbh;
    }

    protected abstract void mo1578a();

    public final void m4706a(zzbi com_google_android_gms_common_api_internal_zzbi) {
        com_google_android_gms_common_api_internal_zzbi.f17276a.lock();
        try {
            if (com_google_android_gms_common_api_internal_zzbi.f17286k == this.f5771a) {
                mo1578a();
            }
            com_google_android_gms_common_api_internal_zzbi.f17276a.unlock();
        } catch (Throwable th) {
            com_google_android_gms_common_api_internal_zzbi.f17276a.unlock();
        }
    }
}
