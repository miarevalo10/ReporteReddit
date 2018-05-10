package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzpc implements zzt<Object> {
    private /* synthetic */ zzzb f14594a;
    private /* synthetic */ zzoy f14595b;

    zzpc(zzoy com_google_android_gms_internal_zzoy, zzzb com_google_android_gms_internal_zzzb) {
        this.f14595b = com_google_android_gms_internal_zzoy;
        this.f14594a = com_google_android_gms_internal_zzzb;
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) this.f14595b.f7954a.get();
        if (com_google_android_gms_internal_zzanh == null) {
            this.f14594a.mo2293b("/hideOverlay", this);
        } else if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        } else {
            ((View) com_google_android_gms_internal_zzanh).setVisibility(8);
        }
    }
}
