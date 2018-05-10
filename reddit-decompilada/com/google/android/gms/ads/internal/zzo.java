package com.google.android.gms.ads.internal;

import android.view.View;
import android.view.View.OnClickListener;

final class zzo implements OnClickListener {
    private /* synthetic */ zzw f5640a;
    private /* synthetic */ zzl f5641b;

    zzo(zzl com_google_android_gms_ads_internal_zzl, zzw com_google_android_gms_ads_internal_zzw) {
        this.f5641b = com_google_android_gms_ads_internal_zzl;
        this.f5640a = com_google_android_gms_ads_internal_zzw;
    }

    public final void onClick(View view) {
        this.f5640a.f5653a = true;
        if (this.f5641b.f5634b != null) {
            this.f5641b.f5634b.mo1707c();
        }
    }
}
