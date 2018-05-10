package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.js.zzaa;
import com.google.android.gms.ads.internal.js.zzaj;
import com.google.android.gms.ads.internal.js.zzn;
import org.json.JSONObject;

@zzzv
public final class zzgf implements zzgo {
    final Context f14476a;
    final zzt<zzaj> f14477b = new zzgk(this);
    final zzt<zzaj> f14478c = new zzgl(this);
    final zzt<zzaj> f14479d = new zzgm(this);
    final zzt<zzaj> f14480e = new zzgn(this);
    private final zzft f14481f;
    private final zzz f14482g;
    private zzaa f14483h;
    private boolean f14484i;

    public final void mo1946a(JSONObject jSONObject, boolean z) {
        this.f14483h.mo1736a(new zzgi(jSONObject), new zzalj());
    }

    public final boolean mo1947a() {
        return this.f14484i;
    }

    public final void mo1948b() {
        this.f14483h.mo1736a(new zzgj(this), new zzalj());
        this.f14483h.m17383a();
    }

    public zzgf(zzft com_google_android_gms_internal_zzft, zzn com_google_android_gms_ads_internal_js_zzn, Context context) {
        this.f14481f = com_google_android_gms_internal_zzft;
        this.f14476a = context;
        this.f14482g = new zzz(this.f14476a);
        this.f14483h = com_google_android_gms_ads_internal_js_zzn.m4446a();
        this.f14483h.mo1736a(new zzgg(this), new zzgh(this));
        com_google_android_gms_internal_zzft = "Core JS tracking ad unit: ";
        com_google_android_gms_ads_internal_js_zzn = String.valueOf(this.f14481f.f7578b.f7573c);
        zzakb.m5366b(com_google_android_gms_ads_internal_js_zzn.length() != null ? com_google_android_gms_internal_zzft.concat(com_google_android_gms_ads_internal_js_zzn) : new String(com_google_android_gms_internal_zzft));
    }
}
