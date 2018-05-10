package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzanh;
import java.util.Map;

final class zzs implements zzt<zzanh> {
    zzs() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        if (map.keySet().contains("start")) {
            com_google_android_gms_internal_zzanh.mo3997e(true);
        }
        if (map.keySet().contains("stop")) {
            com_google_android_gms_internal_zzanh.mo3997e(false);
        }
    }
}
