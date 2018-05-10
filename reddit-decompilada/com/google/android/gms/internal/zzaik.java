package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;

final class zzaik implements Runnable {
    private /* synthetic */ zzaig f6410a;

    zzaik(zzaig com_google_android_gms_internal_zzaig) {
        this.f6410a = com_google_android_gms_internal_zzaig;
    }

    public final void run() {
        zzaim n = zzbs.m4495n();
        Context d = this.f6410a.f6398e;
        String e = this.f6410a.f6395b;
        String f = this.f6410a.f6396c;
        if (!n.m5282a(d, e, f)) {
            zzaim.m5277a(d, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if ("2".equals(n.f6412a)) {
            zzakb.m5366b("Creative is not pushed for this device.");
            zzaim.m5277a(d, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(n.f6412a)) {
            zzakb.m5366b("The app is not linked for creative preview.");
            n.m5285c(d, e, f);
        } else {
            if ("0".equals(n.f6412a)) {
                zzakb.m5366b("Device is linked for in app preview.");
                zzaim.m5277a(d, "The device is successfully linked for creative preview.", false, true);
            }
        }
    }
}
