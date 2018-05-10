package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzbs;
import io.fabric.sdk.android.services.network.HttpRequest;
import org.json.JSONObject;

@zzzv
public final class zzact extends zzacv {
    final Context f14040a;
    SharedPreferences f14041b;
    private final Object f14042c = new Object();
    private final zztp<JSONObject, JSONObject> f14043d;

    public zzact(Context context, zztp<JSONObject, JSONObject> com_google_android_gms_internal_zztp_org_json_JSONObject__org_json_JSONObject) {
        this.f14040a = context.getApplicationContext();
        this.f14043d = com_google_android_gms_internal_zztp_org_json_JSONObject__org_json_JSONObject;
    }

    public final zzakv<Void> mo1654a() {
        synchronized (this.f14042c) {
            if (this.f14041b == null) {
                this.f14041b = this.f14040a.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzbs.m4492k().mo1632a() - this.f14041b.getLong("js_last_update", 0) < ((Long) zzkb.m6350f().m6488a(zznh.bH)).longValue()) {
            return zzakl.m5377a(null);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzakd.m17801a().f17551a);
            jSONObject.put("mf", zzkb.m6350f().m6488a(zznh.bI));
            jSONObject.put("cl", "179146524");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", HttpRequest.METHOD_HEAD);
            return zzakl.m5380a(this.f14043d.mo3566b(jSONObject), new zzacu(this), zzala.f6512b);
        } catch (Throwable e) {
            zzakb.m5367b("Unable to populate SDK Core Constants parameters.", e);
            return zzakl.m5377a(null);
        }
    }
}
