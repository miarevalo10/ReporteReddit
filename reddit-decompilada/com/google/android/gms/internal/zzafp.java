package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;
import org.json.JSONObject;

@zzzv
public final class zzafp {
    public final zzaat f6314a;
    public final zzaax f6315b;
    public final zzui f6316c;
    public final zzjn f6317d;
    public final int f6318e;
    public final long f6319f;
    public final long f6320g;
    public final JSONObject f6321h;
    public final zzis f6322i;
    public final boolean f6323j;

    public zzafp(zzaat com_google_android_gms_internal_zzaat, zzaax com_google_android_gms_internal_zzaax, int i, long j, long j2, zzix com_google_android_gms_internal_zzix) {
        this.f6314a = com_google_android_gms_internal_zzaat;
        this.f6315b = com_google_android_gms_internal_zzaax;
        this.f6316c = null;
        this.f6317d = null;
        this.f6318e = i;
        this.f6319f = j;
        this.f6320g = j2;
        this.f6321h = null;
        this.f6322i = new zzis(com_google_android_gms_internal_zzix, ((Boolean) zzkb.m6350f().m6488a(zznh.cJ)).booleanValue());
        this.f6323j = false;
    }

    public zzafp(zzaat com_google_android_gms_internal_zzaat, zzaax com_google_android_gms_internal_zzaax, zzui com_google_android_gms_internal_zzui, zzjn com_google_android_gms_internal_zzjn, int i, long j, long j2, JSONObject jSONObject, zzis com_google_android_gms_internal_zzis, Boolean bool) {
        boolean booleanValue;
        this.f6314a = com_google_android_gms_internal_zzaat;
        this.f6315b = com_google_android_gms_internal_zzaax;
        this.f6316c = com_google_android_gms_internal_zzui;
        this.f6317d = com_google_android_gms_internal_zzjn;
        this.f6318e = i;
        this.f6319f = j;
        this.f6320g = j2;
        this.f6321h = jSONObject;
        this.f6322i = com_google_android_gms_internal_zzis;
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            zzbs.m4486e();
            booleanValue = zzahn.m5195b(com_google_android_gms_internal_zzaat.f17396c);
        }
        this.f6323j = booleanValue;
    }
}
