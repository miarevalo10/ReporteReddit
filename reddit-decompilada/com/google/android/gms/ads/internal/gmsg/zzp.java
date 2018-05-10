package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import java.util.Map;

final class zzp implements zzt<zzanh> {
    zzp() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        if (((Boolean) zzkb.m6350f().m6488a(zznh.bf)).booleanValue()) {
            com_google_android_gms_internal_zzanh.mo3995d(Boolean.parseBoolean((String) map.get("disabled")) ^ 1);
        }
    }
}
