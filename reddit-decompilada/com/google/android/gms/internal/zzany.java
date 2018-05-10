package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.zzt;
import java.util.Map;

final class zzany implements zzt<zzanh> {
    private /* synthetic */ zzanx f14207a;

    zzany(zzanx com_google_android_gms_internal_zzanx) {
        this.f14207a = com_google_android_gms_internal_zzanx;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.f14207a.f19183b) {
                        if (this.f14207a.f19206y != parseInt) {
                            this.f14207a.f19206y = parseInt;
                            this.f14207a.requestLayout();
                        }
                    }
                } catch (Throwable e) {
                    zzakb.m5369c("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
