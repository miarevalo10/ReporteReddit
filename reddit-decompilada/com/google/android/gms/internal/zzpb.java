package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzpb implements zzt<Object> {
    private /* synthetic */ zzzb f14592a;
    private /* synthetic */ zzoy f14593b;

    zzpb(zzoy com_google_android_gms_internal_zzoy, zzzb com_google_android_gms_internal_zzzb) {
        this.f14593b = com_google_android_gms_internal_zzoy;
        this.f14592a = com_google_android_gms_internal_zzzb;
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) this.f14593b.f7954a.get();
        if (com_google_android_gms_internal_zzanh == null) {
            this.f14592a.mo2293b("/showOverlay", this);
        } else if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        } else {
            ((View) com_google_android_gms_internal_zzanh).setVisibility(0);
        }
    }
}
