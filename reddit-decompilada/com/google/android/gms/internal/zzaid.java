package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzbs;

@TargetApi(21)
public final class zzaid extends zzaic {
    public final zzani mo3436a(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        return new zzaot(com_google_android_gms_internal_zzanh, z);
    }

    public final CookieManager mo4448c(Context context) {
        if (zzaht.m5234e()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzakb.m5367b("Failed to obtain CookieManager.", th);
            zzbs.m4490i().m13246a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final int mo3963f() {
        return 16974374;
    }
}
