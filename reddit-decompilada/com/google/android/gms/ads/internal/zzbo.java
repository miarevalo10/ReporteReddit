package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class zzbo implements OnTouchListener {
    private /* synthetic */ zzbm f5543a;

    zzbo(zzbm com_google_android_gms_ads_internal_zzbm) {
        this.f5543a = com_google_android_gms_ads_internal_zzbm;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f5543a.f17192h != null) {
            this.f5543a.f17192h.m5820a(motionEvent);
        }
        return false;
    }
}
