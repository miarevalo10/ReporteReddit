package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.zzakb;
import org.json.JSONObject;

final class zzv implements Runnable {
    private /* synthetic */ JSONObject f5448a;
    private /* synthetic */ zzu f5449b;

    zzv(zzu com_google_android_gms_ads_internal_gmsg_zzu, JSONObject jSONObject) {
        this.f5449b = com_google_android_gms_ads_internal_gmsg_zzu;
        this.f5448a = jSONObject;
    }

    public final void run() {
        this.f5449b.f5445a.mo3463a("fetchHttpRequestCompleted", this.f5448a);
        zzakb.m5366b("Dispatched http response.");
    }
}
