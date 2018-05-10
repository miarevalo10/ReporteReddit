package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.instabug.library.model.NetworkLog;
import java.util.Map;

final class zzoz implements zzt<Object> {
    final /* synthetic */ zzzb f14588a;
    final /* synthetic */ zzoy f14589b;

    zzoz(zzoy com_google_android_gms_internal_zzoy, zzzb com_google_android_gms_internal_zzzb) {
        this.f14589b = com_google_android_gms_internal_zzoy;
        this.f14588a = com_google_android_gms_internal_zzzb;
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) this.f14589b.f7954a.get();
        if (com_google_android_gms_internal_zzanh == null) {
            this.f14588a.mo2293b("/loadHtml", this);
            return;
        }
        com_google_android_gms_internal_zzanh.mo4019w().f6617d = new zzpa(this, map);
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2) != null) {
            com_google_android_gms_internal_zzanh.loadData(str, NetworkLog.HTML, "UTF-8");
        } else {
            com_google_android_gms_internal_zzanh.loadDataWithBaseURL(str2, str, NetworkLog.HTML, "UTF-8", null);
        }
    }
}
