package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;

final class zzail implements Runnable {
    private /* synthetic */ zzaig f6411a;

    zzail(zzaig com_google_android_gms_internal_zzaig) {
        this.f6411a = com_google_android_gms_internal_zzaig;
    }

    public final void run() {
        zzaim n = zzbs.m4495n();
        Context d = this.f6411a.f6398e;
        String e = this.f6411a.f6395b;
        String f = this.f6411a.f6396c;
        String g = this.f6411a.f6397d;
        boolean b = n.m5283b();
        if (n.m5284b(d, e, f)) {
            if (!(b || TextUtils.isEmpty(g))) {
                n.m5281a(d, f, g, e);
            }
            zzakb.m5366b("Device is linked for debug signals.");
            zzaim.m5277a(d, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        n.m5285c(d, e, f);
    }
}
