package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzaci implements zzt<Object> {
    private /* synthetic */ zzach f14037a;

    zzaci(zzach com_google_android_gms_internal_zzach) {
        this.f14037a = com_google_android_gms_internal_zzach;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.f14037a.f6106b) {
            if (this.f14037a.f6109e.isDone()) {
            } else if (this.f14037a.f6107c.equals(map.get("request_id"))) {
                zzacn com_google_android_gms_internal_zzacn = new zzacn(1, map);
                map = com_google_android_gms_internal_zzacn.f6152d;
                String valueOf = String.valueOf(com_google_android_gms_internal_zzacn.f6149a);
                StringBuilder stringBuilder = new StringBuilder((24 + String.valueOf(map).length()) + String.valueOf(valueOf).length());
                stringBuilder.append("Invalid ");
                stringBuilder.append(map);
                stringBuilder.append(" request error: ");
                stringBuilder.append(valueOf);
                zzakb.m5371e(stringBuilder.toString());
                this.f14037a.f6109e.m13330b(com_google_android_gms_internal_zzacn);
            }
        }
    }
}
