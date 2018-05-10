package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzanh;
import java.util.Map;

final class zzq implements zzt<zzanh> {
    zzq() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        String str = (String) map.get("action");
        if ("pause".equals(str)) {
            com_google_android_gms_internal_zzanh.h_();
            return;
        }
        if ("resume".equals(str)) {
            com_google_android_gms_internal_zzanh.i_();
        }
    }
}
