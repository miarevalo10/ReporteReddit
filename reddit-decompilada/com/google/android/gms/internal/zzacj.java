package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzacj implements zzt<Object> {
    private /* synthetic */ zzach f14038a;

    zzacj(zzach com_google_android_gms_internal_zzach) {
        this.f14038a = com_google_android_gms_internal_zzach;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.f14038a.f6106b) {
            if (this.f14038a.f6109e.isDone()) {
                return;
            }
            zzacn com_google_android_gms_internal_zzacn = new zzacn(-2, map);
            if (this.f14038a.f6107c.equals(com_google_android_gms_internal_zzacn.f6154f)) {
                String str = com_google_android_gms_internal_zzacn.f6156h;
                if (str == null) {
                    zzakb.m5371e("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (str.contains("%40mediation_adapters%40")) {
                    map = str.replaceAll("%40mediation_adapters%40", zzaga.m5121a(this.f14038a.f6105a, (String) map.get("check_adapters"), this.f14038a.f6108d));
                    com_google_android_gms_internal_zzacn.f6156h = map;
                    str = "Ad request URL modified to ";
                    map = String.valueOf(map);
                    zzagf.m13278a(map.length() != 0 ? str.concat(map) : new String(str));
                }
                this.f14038a.f6109e.m13330b(com_google_android_gms_internal_zzacn);
                return;
            }
        }
    }
}
