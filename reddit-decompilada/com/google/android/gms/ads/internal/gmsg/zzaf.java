package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.google.android.gms.internal.zzaeq;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzzv;
import java.util.Map;

@zzzv
public final class zzaf implements zzt<Object> {
    private final zzag f13730a;

    public zzaf(zzag com_google_android_gms_ads_internal_gmsg_zzag) {
        this.f13730a = com_google_android_gms_ads_internal_gmsg_zzag;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zzaeq com_google_android_gms_internal_zzaeq = null;
            try {
                int parseInt = Integer.parseInt((String) map.get("amount"));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    com_google_android_gms_internal_zzaeq = new zzaeq(str2, parseInt);
                }
            } catch (Throwable e) {
                zzakb.m5369c("Unable to parse reward amount.", e);
            }
            this.f13730a.mo4380a(com_google_android_gms_internal_zzaeq);
            return;
        }
        if ("video_start".equals(str)) {
            this.f13730a.d_();
        }
    }
}
