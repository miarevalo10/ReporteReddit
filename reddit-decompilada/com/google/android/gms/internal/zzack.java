package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzack implements zzt<Object> {
    private /* synthetic */ zzach f14039a;

    zzack(zzach com_google_android_gms_internal_zzach) {
        this.f14039a = com_google_android_gms_internal_zzach;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.f14039a.f6106b) {
            if (this.f14039a.f6109e.isDone()) {
                return;
            }
            zzacn com_google_android_gms_internal_zzacn = new zzacn(-2, map);
            if (this.f14039a.f6107c.equals(com_google_android_gms_internal_zzacn.f6154f) == null) {
                return;
            }
            this.f14039a.f6109e.m13330b(com_google_android_gms_internal_zzacn);
        }
    }
}
