package com.google.android.gms.ads.internal.js;

import android.content.Context;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzaiq;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzall;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzn {
    private final Object f5462a;
    private final Context f5463b;
    private final String f5464c;
    private final zzakd f5465d;
    private zzaiq<zzc> f5466e;
    private zzaiq<zzc> f5467f;
    private zzae f5468g;
    private int f5469h;

    public zzn(Context context, zzakd com_google_android_gms_internal_zzakd, String str) {
        this.f5462a = new Object();
        this.f5469h = 1;
        this.f5464c = str;
        this.f5463b = context.getApplicationContext();
        this.f5465d = com_google_android_gms_internal_zzakd;
        this.f5466e = new zzz();
        this.f5467f = new zzz();
    }

    public zzn(Context context, zzakd com_google_android_gms_internal_zzakd, String str, zzaiq<zzc> com_google_android_gms_internal_zzaiq_com_google_android_gms_ads_internal_js_zzc, zzaiq<zzc> com_google_android_gms_internal_zzaiq_com_google_android_gms_ads_internal_js_zzc2) {
        this(context, com_google_android_gms_internal_zzakd, str);
        this.f5466e = com_google_android_gms_internal_zzaiq_com_google_android_gms_ads_internal_js_zzc;
        this.f5467f = com_google_android_gms_internal_zzaiq_com_google_android_gms_ads_internal_js_zzc2;
    }

    protected final zzae m4447a(zzcv com_google_android_gms_internal_zzcv) {
        zzall com_google_android_gms_ads_internal_js_zzae = new zzae(this.f5467f);
        zzbs.m4486e();
        zzahn.m5173a(new zzo(this, com_google_android_gms_internal_zzcv, com_google_android_gms_ads_internal_js_zzae));
        com_google_android_gms_ads_internal_js_zzae.mo1736a(new zzw(this, com_google_android_gms_ads_internal_js_zzae), new zzx(this, com_google_android_gms_ads_internal_js_zzae));
        return com_google_android_gms_ads_internal_js_zzae;
    }

    public final zzaa m4446a() {
        synchronized (this.f5462a) {
            zzaa a;
            if (this.f5468g != null) {
                if (this.f5468g.f14142a != -1) {
                    if (this.f5469h == 0) {
                        a = this.f5468g.m17386a();
                        return a;
                    } else if (this.f5469h == 1) {
                        this.f5469h = 2;
                        m4447a(null);
                        a = this.f5468g.m17386a();
                        return a;
                    } else if (this.f5469h == 2) {
                        a = this.f5468g.m17386a();
                        return a;
                    } else {
                        a = this.f5468g.m17386a();
                        return a;
                    }
                }
            }
            this.f5469h = 2;
            this.f5468g = m4447a(null);
            a = this.f5468g.m17386a();
            return a;
        }
    }
}
