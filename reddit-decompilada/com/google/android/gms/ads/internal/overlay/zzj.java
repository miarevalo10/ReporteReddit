package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.internal.zzagb;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzajg;
import com.google.android.gms.internal.zzzv;

@zzzv
final class zzj extends zzagb {
    final /* synthetic */ zzd f17124a;

    private zzj(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        this.f17124a = com_google_android_gms_ads_internal_overlay_zzd;
    }

    public final void mo3385b() {
    }

    public final void mo3384a() {
        zzajg w = zzbs.m4504w();
        Bitmap bitmap = (Bitmap) w.f6447a.get(Integer.valueOf(this.f17124a.f17105b.f17094o.f17175e));
        if (bitmap != null) {
            zzahn.f6379a.post(new zzk(this, zzbs.m4488g().mo4387a(this.f17124a.f17104a, bitmap, this.f17124a.f17105b.f17094o.f17173c, this.f17124a.f17105b.f17094o.f17174d)));
        }
    }
}
