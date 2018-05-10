package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzzv;
import java.util.Map;

@zzzv
public final class zzw implements zzt<Object> {
    private final zzx f13736a;

    public zzw(zzx com_google_android_gms_ads_internal_gmsg_zzx) {
        this.f13736a = com_google_android_gms_ads_internal_gmsg_zzx;
    }

    public final void zza(Object obj, Map<String, String> map) {
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (Throwable e) {
            zzakb.m5367b("Fail to parse float", e);
        }
        this.f13736a.mo4381a(equals);
        this.f13736a.mo4382a(equals2, f);
    }
}
