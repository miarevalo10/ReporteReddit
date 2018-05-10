package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzzv;
import java.util.Map;

@zzzv
public final class zza implements zzt<Object> {
    private final zzb f13714a;

    public zza(zzb com_google_android_gms_ads_internal_gmsg_zzb) {
        this.f13714a = com_google_android_gms_ads_internal_gmsg_zzb;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzakb.m5371e("App event with no name parameter.");
        } else {
            this.f13714a.mo3387a(str, (String) map.get("info"));
        }
    }
}
