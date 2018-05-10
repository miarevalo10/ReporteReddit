package com.google.android.gms.ads.internal.js;

import com.google.android.gms.internal.zzalj;
import com.google.android.gms.internal.zzall;

public final class zzaa extends zzall<zzaj> {
    private final Object f17073b = new Object();
    private final zzae f17074c;
    private boolean f17075d;

    public zzaa(zzae com_google_android_gms_ads_internal_js_zzae) {
        this.f17074c = com_google_android_gms_ads_internal_js_zzae;
    }

    public final void m17383a() {
        synchronized (this.f17073b) {
            if (this.f17075d) {
                return;
            }
            this.f17075d = true;
            mo1736a(new zzab(), new zzalj());
            mo1736a(new zzac(this), new zzad(this));
        }
    }
}
