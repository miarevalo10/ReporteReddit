package com.google.android.gms.internal;

import org.json.JSONObject;

final class zzabq implements Runnable {
    final /* synthetic */ JSONObject f6072a;
    final /* synthetic */ String f6073b;
    private /* synthetic */ zzabo f6074c;

    zzabq(zzabo com_google_android_gms_internal_zzabo, JSONObject jSONObject, String str) {
        this.f6074c = com_google_android_gms_internal_zzabo;
        this.f6072a = jSONObject;
        this.f6073b = str;
    }

    public final void run() {
        this.f6074c.f17492l = zzabo.f17484d.m4446a();
        this.f6074c.f17492l.mo1736a(new zzabr(this), new zzabs(this));
    }
}
