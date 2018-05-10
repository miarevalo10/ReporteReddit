package com.google.android.gms.ads.internal;

import android.webkit.CookieManager;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;
import java.util.concurrent.Callable;

final class zze implements Callable<String> {
    private /* synthetic */ zzd f5627a;

    zze(zzd com_google_android_gms_ads_internal_zzd) {
        this.f5627a = com_google_android_gms_ads_internal_zzd;
    }

    public final /* synthetic */ Object call() throws Exception {
        String str = "";
        if (!((Boolean) zzkb.m6350f().m6488a(zznh.cm)).booleanValue()) {
            return str;
        }
        CookieManager c = zzbs.m4488g().mo4448c(this.f5627a.e.f5600c);
        return c != null ? c.getCookie("googleads.g.doubleclick.net") : str;
    }
}
