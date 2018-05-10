package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanm;
import com.google.android.gms.internal.zzol;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class zzas implements zzanm {
    private /* synthetic */ zzol f13772a;
    private /* synthetic */ String f13773b;
    private /* synthetic */ zzanh f13774c;

    zzas(zzol com_google_android_gms_internal_zzol, String str, zzanh com_google_android_gms_internal_zzanh) {
        this.f13772a = com_google_android_gms_internal_zzol;
        this.f13773b = str;
        this.f13774c = com_google_android_gms_internal_zzanh;
    }

    public final void mo1512a(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.f13772a.mo2123a());
            jSONObject.put("body", this.f13772a.mo2130e());
            jSONObject.put("call_to_action", this.f13772a.mo2132g());
            jSONObject.put("advertiser", this.f13772a.mo2133h());
            jSONObject.put("logo", zzaq.m4463a(this.f13772a.mo2131f()));
            JSONArray jSONArray = new JSONArray();
            List<Object> b = this.f13772a.mo2125b();
            if (b != null) {
                for (Object a : b) {
                    jSONArray.put(zzaq.m4463a(zzaq.m4461a(a)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", zzaq.m4464a(this.f13772a.mo2136n(), this.f13773b));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "1");
            this.f13774c.mo3465b("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (Throwable e) {
            zzakb.m5369c("Exception occurred when loading assets", e);
        }
    }
}
