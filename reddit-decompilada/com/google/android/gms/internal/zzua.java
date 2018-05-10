package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzad;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.js.zzaa;
import com.google.android.gms.ads.internal.js.zzaj;
import com.google.android.gms.ads.internal.js.zzn;
import com.google.android.gms.ads.internal.zzbs;
import org.json.JSONObject;

@zzzv
public final class zzua<I, O> implements zztp<I, O> {
    private final zztr<O> f18305a;
    private final zzts<I> f18306b;
    private final zzn f18307c;
    private final String f18308d;

    zzua(zzn com_google_android_gms_ads_internal_js_zzn, String str, zzts<I> com_google_android_gms_internal_zzts_I, zztr<O> com_google_android_gms_internal_zztr_O) {
        this.f18307c = com_google_android_gms_ads_internal_js_zzn;
        this.f18308d = str;
        this.f18306b = com_google_android_gms_internal_zzts_I;
        this.f18305a = com_google_android_gms_internal_zztr_O;
    }

    public final zzakv<O> mo1516a(I i) throws Exception {
        return mo3566b(i);
    }

    public final zzakv<O> mo3566b(I i) {
        zzakv com_google_android_gms_internal_zzalf = new zzalf();
        zzall a = this.f18307c.m4446a();
        a.mo1736a(new zzub(this, a, i, com_google_android_gms_internal_zzalf), new zzuc(com_google_android_gms_internal_zzalf, a));
        return com_google_android_gms_internal_zzalf;
    }

    static /* synthetic */ void m19035a(zzua com_google_android_gms_internal_zzua, zzaa com_google_android_gms_ads_internal_js_zzaa, zzaj com_google_android_gms_ads_internal_js_zzaj, Object obj, zzalf com_google_android_gms_internal_zzalf) {
        try {
            zzbs.m4486e();
            String a = zzahn.m5157a();
            zzad com_google_android_gms_ads_internal_gmsg_zzad = zzd.f5440o;
            zzud com_google_android_gms_internal_zzud = new zzud(com_google_android_gms_internal_zzua, com_google_android_gms_ads_internal_js_zzaa, com_google_android_gms_internal_zzalf);
            synchronized (com_google_android_gms_ads_internal_gmsg_zzad.f13728a) {
                com_google_android_gms_ads_internal_gmsg_zzad.f13729b.put(a, com_google_android_gms_internal_zzud);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", a);
            jSONObject.put("args", com_google_android_gms_internal_zzua.f18306b.mo2159a(obj));
            com_google_android_gms_ads_internal_js_zzaj.mo3465b(com_google_android_gms_internal_zzua.f18308d, jSONObject);
        } catch (zzua com_google_android_gms_internal_zzua2) {
            try {
                com_google_android_gms_internal_zzalf.m13329a(com_google_android_gms_internal_zzua2);
                zzakb.m5367b("Unable to invokeJavaScript", com_google_android_gms_internal_zzua2);
            } finally {
                com_google_android_gms_ads_internal_js_zzaa.m17383a();
            }
        }
    }
}
