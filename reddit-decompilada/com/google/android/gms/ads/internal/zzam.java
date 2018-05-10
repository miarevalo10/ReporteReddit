package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.zzagb;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzzv;

@zzzv
final class zzam extends zzagb {
    final /* synthetic */ zzak f17169a;
    private final int f17170b;

    public zzam(zzak com_google_android_gms_ads_internal_zzak, int i) {
        this.f17169a = com_google_android_gms_ads_internal_zzak;
        this.f17170b = i;
    }

    public final void mo3384a() {
        zzao com_google_android_gms_ads_internal_zzao = new zzao(this.f17169a.e.f5590G, this.f17169a.m21510E(), this.f17169a.f19797k, this.f17169a.f19798l, this.f17169a.e.f5590G ? this.f17170b : -1, this.f17169a.f19799n, this.f17169a.e.f5607j.f6283I);
        int A = this.f17169a.e.f5607j.f6289b.mo3964A();
        if (A == -1) {
            A = this.f17169a.e.f5607j.f6294g;
        }
        zzahn.f6379a.post(new zzan(this, new AdOverlayInfoParcel(this.f17169a, this.f17169a, this.f17169a, this.f17169a.e.f5607j.f6289b, A, this.f17169a.e.f5602e, this.f17169a.e.f5607j.f6313z, com_google_android_gms_ads_internal_zzao)));
    }

    public final void mo3385b() {
    }
}
