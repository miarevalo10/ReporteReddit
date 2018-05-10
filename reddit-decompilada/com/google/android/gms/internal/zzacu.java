package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import org.json.JSONObject;

final /* synthetic */ class zzacu implements zzakh {
    private final zzact f14044a;

    zzacu(zzact com_google_android_gms_internal_zzact) {
        this.f14044a = com_google_android_gms_internal_zzact;
    }

    public final Object mo1655a(Object obj) {
        zzact com_google_android_gms_internal_zzact = this.f14044a;
        zznh.m6491a(com_google_android_gms_internal_zzact.f14040a, (JSONObject) obj);
        com_google_android_gms_internal_zzact.f14041b.edit().putLong("js_last_update", zzbs.m4492k().mo1632a()).apply();
        return null;
    }
}
