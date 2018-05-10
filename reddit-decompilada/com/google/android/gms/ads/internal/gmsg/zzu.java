package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.js.zza;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import java.util.Map;
import org.json.JSONObject;

final class zzu implements Runnable {
    final /* synthetic */ zza f5445a;
    private /* synthetic */ Map f5446b;
    private /* synthetic */ HttpClient f5447c;

    zzu(HttpClient httpClient, Map map, zza com_google_android_gms_ads_internal_js_zza) {
        this.f5447c = httpClient;
        this.f5446b = map;
        this.f5445a = com_google_android_gms_ads_internal_js_zza;
    }

    public final void run() {
        zzakb.m5366b("Received Http request.");
        try {
            JSONObject send = this.f5447c.send(new JSONObject((String) this.f5446b.get("http_request")));
            if (send == null) {
                zzakb.m5368c("Response should not be null.");
            } else {
                zzahn.f6379a.post(new zzv(this, send));
            }
        } catch (Throwable e) {
            zzakb.m5367b("Error converting request to json.", e);
        }
    }
}
