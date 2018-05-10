package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

@zzzv
public final class zzaaw extends zzabf {
    private final WeakReference<zzaal> f17420a;

    public zzaaw(zzaal com_google_android_gms_internal_zzaal) {
        this.f17420a = new WeakReference(com_google_android_gms_internal_zzaal);
    }

    public final void mo1653a(zzaax com_google_android_gms_internal_zzaax) {
        zzaal com_google_android_gms_internal_zzaal = (zzaal) this.f17420a.get();
        if (com_google_android_gms_internal_zzaal != null) {
            com_google_android_gms_internal_zzaal.mo1643a(com_google_android_gms_internal_zzaax);
        }
    }
}
