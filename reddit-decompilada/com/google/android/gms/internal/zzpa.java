package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

final class zzpa implements zzanm {
    private /* synthetic */ Map f14590a;
    private /* synthetic */ zzoz f14591b;

    zzpa(zzoz com_google_android_gms_internal_zzoz, Map map) {
        this.f14591b = com_google_android_gms_internal_zzoz;
        this.f14590a = map;
    }

    public final void mo1512a(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        this.f14591b.f14589b.f7955b = (String) this.f14590a.get("id");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("messageType", "htmlLoaded");
            jSONObject.put("id", this.f14591b.f14589b.f7955b);
            this.f14591b.f14588a.mo3577a("sendMessageToNativeJs", jSONObject);
        } catch (Throwable e) {
            zzakb.m5367b("Unable to dispatch sendMessageToNativeJs event", e);
        }
    }
}
