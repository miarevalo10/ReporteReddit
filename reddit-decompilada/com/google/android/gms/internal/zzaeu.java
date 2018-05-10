package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class zzaeu implements Runnable {
    private /* synthetic */ zzakv f6257a;
    private /* synthetic */ zzaes f6258b;

    zzaeu(zzaes com_google_android_gms_internal_zzaes, zzakv com_google_android_gms_internal_zzakv) {
        this.f6258b = com_google_android_gms_internal_zzaes;
        this.f6257a = com_google_android_gms_internal_zzakv;
    }

    public final void run() {
        try {
            Map map = (Map) this.f6257a.get();
            zzaes com_google_android_gms_internal_zzaes = this.f6258b;
            if (map != null) {
                for (String str : map.keySet()) {
                    String str2;
                    JSONArray optJSONArray = new JSONObject((String) map.get(str2)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (com_google_android_gms_internal_zzaes.f14050b) {
                            int length = optJSONArray.length();
                            zzfke b = com_google_android_gms_internal_zzaes.m13221b(str2);
                            if (b == null) {
                                String str3 = "Cannot find the corresponding resource object for ";
                                str2 = String.valueOf(str2);
                                zzafa.m5071a(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                            } else {
                                b.f18090e = new String[length];
                                int i = 0;
                                for (int i2 = 0; i2 < length; i2++) {
                                    b.f18090e[i2] = optJSONArray.getJSONObject(i2).getString("threat_type");
                                }
                                boolean z = com_google_android_gms_internal_zzaes.f14049a;
                                if (length > 0) {
                                    i = 1;
                                }
                                com_google_android_gms_internal_zzaes.f14049a = i | z;
                            }
                        }
                    }
                }
            }
            if (this.f6258b.f14049a) {
                synchronized (this.f6258b.f14050b) {
                    this.f6258b.f14051c.f18045a = Integer.valueOf(9);
                }
            }
            this.f6258b.m13225e();
        } catch (Throwable e) {
            String str4 = "Failed to get SafeBrowsing metadata";
            if (((Boolean) zzkb.m6350f().m6488a(zznh.cl)).booleanValue()) {
                zzakb.m5364a(str4, e);
            }
        }
    }
}
