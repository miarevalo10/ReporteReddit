package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzzv;
import java.lang.ref.WeakReference;

@zzzv
public final class zzbi {
    zzjj f5533a;
    boolean f5534b;
    private final zzbk f5535c;
    private final Runnable f5536d;
    private boolean f5537e;
    private long f5538f;

    public zzbi(zza com_google_android_gms_ads_internal_zza) {
        this(com_google_android_gms_ads_internal_zza, new zzbk(zzahn.f6379a));
    }

    private zzbi(zza com_google_android_gms_ads_internal_zza, zzbk com_google_android_gms_ads_internal_zzbk) {
        this.f5534b = false;
        this.f5537e = false;
        this.f5538f = 0;
        this.f5535c = com_google_android_gms_ads_internal_zzbk;
        this.f5536d = new zzbj(this, new WeakReference(com_google_android_gms_ads_internal_zza));
    }

    public final void m4471a() {
        this.f5534b = false;
        this.f5535c.m4476a(this.f5536d);
    }

    public final void m4472a(zzjj com_google_android_gms_internal_zzjj) {
        m4473a(com_google_android_gms_internal_zzjj, 60000);
    }

    public final void m4474b() {
        this.f5537e = true;
        if (this.f5534b) {
            this.f5535c.m4476a(this.f5536d);
        }
    }

    public final void m4475c() {
        this.f5537e = false;
        if (this.f5534b) {
            this.f5534b = false;
            m4473a(this.f5533a, this.f5538f);
        }
    }

    public final void m4473a(zzjj com_google_android_gms_internal_zzjj, long j) {
        if (this.f5534b) {
            zzakb.m5371e("An ad refresh is already scheduled.");
            return;
        }
        this.f5533a = com_google_android_gms_internal_zzjj;
        this.f5534b = true;
        this.f5538f = j;
        if (this.f5537e == null) {
            StringBuilder stringBuilder = new StringBuilder(65);
            stringBuilder.append("Scheduling ad refresh ");
            stringBuilder.append(j);
            stringBuilder.append(" milliseconds from now.");
            zzakb.m5370d(stringBuilder.toString());
            com_google_android_gms_internal_zzjj = this.f5535c;
            com_google_android_gms_internal_zzjj.f5541a.postDelayed(this.f5536d, j);
        }
    }
}
