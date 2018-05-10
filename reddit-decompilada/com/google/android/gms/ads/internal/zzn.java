package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class zzn implements OnTouchListener {
    private /* synthetic */ zzw f5638a;
    private /* synthetic */ zzl f5639b;

    zzn(zzl com_google_android_gms_ads_internal_zzl, zzw com_google_android_gms_ads_internal_zzw) {
        this.f5639b = com_google_android_gms_ads_internal_zzl;
        this.f5638a = com_google_android_gms_ads_internal_zzw;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.f5638a.f5653a = true;
        if (this.f5639b.f5634b != null) {
            this.f5639b.f5634b.mo1707c();
        }
        return null;
    }
}
