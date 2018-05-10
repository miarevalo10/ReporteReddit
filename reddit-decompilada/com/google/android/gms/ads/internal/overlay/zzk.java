package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

final class zzk implements Runnable {
    private /* synthetic */ Drawable f5487a;
    private /* synthetic */ zzj f5488b;

    zzk(zzj com_google_android_gms_ads_internal_overlay_zzj, Drawable drawable) {
        this.f5488b = com_google_android_gms_ads_internal_overlay_zzj;
        this.f5487a = drawable;
    }

    public final void run() {
        this.f5488b.f17124a.f17104a.getWindow().setBackgroundDrawable(this.f5487a);
    }
}
