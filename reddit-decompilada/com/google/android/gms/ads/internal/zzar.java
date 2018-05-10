package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zzanm;
import com.google.android.gms.internal.zzoj;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class zzar implements zzanm {
    private /* synthetic */ zzoj f13769a;
    private /* synthetic */ String f13770b;
    private /* synthetic */ zzanh f13771c;

    zzar(zzoj com_google_android_gms_internal_zzoj, String str, zzanh com_google_android_gms_internal_zzanh) {
        this.f13769a = com_google_android_gms_internal_zzoj;
        this.f13770b = str;
        this.f13771c = com_google_android_gms_internal_zzanh;
    }

    public final void mo1512a(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("headline", this.f13769a.mo2105a());
            jSONObject.put("body", this.f13769a.mo2109c());
            jSONObject.put("call_to_action", this.f13769a.mo2112e());
            jSONObject.put("price", this.f13769a.mo2115h());
            jSONObject.put("star_rating", String.valueOf(this.f13769a.mo2113f()));
            jSONObject.put("store", this.f13769a.mo2114g());
            jSONObject.put("icon", zzaq.m4463a(this.f13769a.mo2111d()));
            JSONArray jSONArray = new JSONArray();
            List<Object> b = this.f13769a.mo2107b();
            if (b != null) {
                for (Object a : b) {
                    jSONArray.put(zzaq.m4463a(zzaq.m4461a(a)));
                }
            }
            jSONObject.put("images", jSONArray);
            jSONObject.put("extras", zzaq.m4464a(this.f13769a.mo2118n(), this.f13770b));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("assets", jSONObject);
            jSONObject2.put("template_id", "2");
            this.f13771c.mo3465b("google.afma.nativeExpressAds.loadAssets", jSONObject2);
        } catch (Throwable e) {
            zzakb.m5369c("Exception occurred when loading assets", e);
        }
    }
}
