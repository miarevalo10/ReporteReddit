package com.google.android.gms.ads.internal.js;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzagf;
import com.google.android.gms.internal.zzaiq;
import com.google.android.gms.internal.zzalj;
import com.google.android.gms.internal.zzall;

public final class zzae extends zzall<zzc> {
    private final Object f17076b = new Object();
    private zzaiq<zzc> f17077c;
    private boolean f17078d;
    private int f17079e;

    public zzae(zzaiq<zzc> com_google_android_gms_internal_zzaiq_com_google_android_gms_ads_internal_js_zzc) {
        this.f17077c = com_google_android_gms_internal_zzaiq_com_google_android_gms_ads_internal_js_zzc;
        this.f17078d = false;
        this.f17079e = 0;
    }

    private final void m17385e() {
        synchronized (this.f17076b) {
            zzbq.m4813a(this.f17079e >= 0);
            if (this.f17078d && this.f17079e == 0) {
                zzagf.m13278a("No reference is left (including root). Cleaning up engine.");
                mo1736a(new zzah(this), new zzalj());
            } else {
                zzagf.m13278a("There are still references to the engine. Not destroying.");
            }
        }
    }

    public final zzaa m17386a() {
        zzaa com_google_android_gms_ads_internal_js_zzaa = new zzaa(this);
        synchronized (this.f17076b) {
            mo1736a(new zzaf(com_google_android_gms_ads_internal_js_zzaa), new zzag(com_google_android_gms_ads_internal_js_zzaa));
            zzbq.m4813a(this.f17079e >= 0);
            this.f17079e++;
        }
        return com_google_android_gms_ads_internal_js_zzaa;
    }

    protected final void m17387b() {
        synchronized (this.f17076b) {
            zzbq.m4813a(this.f17079e > 0);
            zzagf.m13278a("Releasing 1 reference for JS Engine");
            this.f17079e--;
            m17385e();
        }
    }

    public final void m17388c() {
        synchronized (this.f17076b) {
            zzbq.m4813a(this.f17079e >= 0);
            zzagf.m13278a("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.f17078d = true;
            m17385e();
        }
    }
}
