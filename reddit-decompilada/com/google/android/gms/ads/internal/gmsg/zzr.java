package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzanh;
import java.util.Map;

final class zzr implements zzt<zzanh> {
    zzr() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        if (map.keySet().contains("start")) {
            obj = com_google_android_gms_internal_zzanh.mo4019w();
            synchronized (obj.f6616c) {
                obj.f6622i = true;
            }
            obj.f6628o += 1;
            obj.m5457h();
        } else if (map.keySet().contains("stop")) {
            obj = com_google_android_gms_internal_zzanh.mo4019w();
            obj.f6628o -= 1;
            obj.m5457h();
        } else {
            if (map.keySet().contains("cancel") != null) {
                obj = com_google_android_gms_internal_zzanh.mo4019w();
                obj.f6627n = true;
                obj.m5457h();
            }
        }
    }
}
