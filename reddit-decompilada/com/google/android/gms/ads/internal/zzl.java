package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzafb;
import com.google.android.gms.internal.zzafp;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzanh;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zznx;
import com.google.android.gms.internal.zzya;

final class zzl implements Runnable {
    final /* synthetic */ zzafp f5633a;
    final /* synthetic */ zzafb f5634b;
    final /* synthetic */ zzi f5635c;
    private /* synthetic */ zznu f5636d;

    zzl(zzi com_google_android_gms_ads_internal_zzi, zzafp com_google_android_gms_internal_zzafp, zzafb com_google_android_gms_internal_zzafb, zznu com_google_android_gms_internal_zznu) {
        this.f5635c = com_google_android_gms_ads_internal_zzi;
        this.f5633a = com_google_android_gms_internal_zzafp;
        this.f5634b = com_google_android_gms_internal_zzafb;
        this.f5636d = com_google_android_gms_internal_zznu;
    }

    public final void run() {
        if (this.f5633a.f6315b.f17458r && this.f5635c.e.f5623z != null) {
            String str = null;
            if (this.f5633a.f6315b.f17441a != null) {
                zzbs.m4486e();
                str = zzahn.m5162a(this.f5633a.f6315b.f17441a);
            }
            zznx com_google_android_gms_internal_zznv = new zznv(this.f5635c, str, this.f5633a.f6315b.f17442b);
            this.f5635c.e.f5589F = 1;
            try {
                this.f5635c.c = false;
                this.f5635c.e.f5623z.mo2065a(com_google_android_gms_internal_zznv);
                return;
            } catch (Throwable e) {
                zzakb.m5369c("Could not call the onCustomRenderedAdLoadedListener.", e);
                this.f5635c.c = true;
            }
        }
        zzw com_google_android_gms_ads_internal_zzw = new zzw(this.f5635c.e.f5600c, this.f5634b, this.f5633a.f6315b.f17425E);
        try {
            zzanh a = this.f5635c.mo4379a(this.f5633a, com_google_android_gms_ads_internal_zzw, this.f5634b);
            a.setOnTouchListener(new zzn(this, com_google_android_gms_ads_internal_zzw));
            a.setOnClickListener(new zzo(this, com_google_android_gms_ads_internal_zzw));
            this.f5635c.e.f5589F = 0;
            zzbt com_google_android_gms_ads_internal_zzbt = this.f5635c.e;
            zzbs.m4485d();
            com_google_android_gms_ads_internal_zzbt.f5605h = zzya.m6803a(this.f5635c.e.f5600c, this.f5635c, this.f5633a, this.f5635c.e.f5601d, a, this.f5635c.m, this.f5635c, this.f5636d);
        } catch (Throwable e2) {
            zzakb.m5367b("Could not obtain webview.", e2);
            zzahn.f6379a.post(new zzm(this));
        }
    }
}
