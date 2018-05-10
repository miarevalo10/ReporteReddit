package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzou;
import java.util.List;

final class zzbd implements Runnable {
    private /* synthetic */ zzou f5520a;
    private /* synthetic */ int f5521b;
    private /* synthetic */ List f5522c;
    private /* synthetic */ zzba f5523d;

    zzbd(zzba com_google_android_gms_ads_internal_zzba, zzou com_google_android_gms_internal_zzou, int i, List list) {
        this.f5523d = com_google_android_gms_ads_internal_zzba;
        this.f5520a = com_google_android_gms_internal_zzou;
        this.f5521b = i;
        this.f5522c = list;
    }

    public final void run() {
        try {
            boolean z = false;
            zzba com_google_android_gms_ads_internal_zzba;
            if ((this.f5520a instanceof zzol) && this.f5523d.e.f5615r != null) {
                com_google_android_gms_ads_internal_zzba = this.f5523d;
                if (this.f5521b != this.f5522c.size() - 1) {
                    z = true;
                }
                com_google_android_gms_ads_internal_zzba.c = z;
                this.f5523d.e.f5615r.mo2152a((zzol) this.f5520a);
            } else if (!(this.f5520a instanceof zzoj) || this.f5523d.e.f5614q == null) {
                zza com_google_android_gms_ads_internal_zza = this.f5523d;
                if (this.f5521b != this.f5522c.size() - 1) {
                    z = true;
                }
                com_google_android_gms_ads_internal_zza.mo4266a(3, z);
            } else {
                com_google_android_gms_ads_internal_zzba = this.f5523d;
                if (this.f5521b != this.f5522c.size() - 1) {
                    z = true;
                }
                com_google_android_gms_ads_internal_zzba.c = z;
                this.f5523d.e.f5614q.mo2151a((zzoj) this.f5520a);
            }
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAppInstallAdLoaded or onContentAdLoaded method", e);
        }
    }
}
