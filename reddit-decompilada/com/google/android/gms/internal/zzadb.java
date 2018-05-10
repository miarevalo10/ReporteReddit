package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import org.json.JSONObject;

@zzzv
public final class zzadb implements zzacf {
    private zztp<JSONObject, JSONObject> f14045a;
    private zztp<JSONObject, JSONObject> f14046b;

    public zzadb(Context context) {
        this.f14045a = zzbs.m4499r().m6661a(context, zzakd.m17801a()).m6665a("google.afma.request.getAdDictionary", zztu.f8035a, zztu.f8035a);
        this.f14046b = zzbs.m4499r().m6661a(context, zzakd.m17801a()).m6665a("google.afma.sdkConstants.getSdkConstants", zztu.f8035a, zztu.f8035a);
    }

    public final zztp<JSONObject, JSONObject> mo1657a() {
        return this.f14045a;
    }

    public final zztp<JSONObject, JSONObject> mo1658b() {
        return this.f14046b;
    }
}
