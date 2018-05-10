package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

final class zzbv implements Runnable {
    private /* synthetic */ ConnectionResult f5796a;
    private /* synthetic */ zzbu f5797b;

    zzbv(zzbu com_google_android_gms_common_api_internal_zzbu, ConnectionResult connectionResult) {
        this.f5797b = com_google_android_gms_common_api_internal_zzbu;
        this.f5796a = connectionResult;
    }

    public final void run() {
        if (this.f5796a.m17584b()) {
            this.f5797b.f13937f = true;
            if (this.f5797b.f13933b.mo4023h()) {
                this.f5797b.m12995a();
                return;
            } else {
                this.f5797b.f13933b.m12805a(null, Collections.emptySet());
                return;
            }
        }
        ((zzbo) this.f5797b.f13932a.f5781f.get(this.f5797b.f13934c)).mo1583a(this.f5796a);
    }
}
