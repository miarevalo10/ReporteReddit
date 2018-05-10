package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzjj;
import java.lang.ref.WeakReference;

final class zzbj implements Runnable {
    private /* synthetic */ WeakReference f5539a;
    private /* synthetic */ zzbi f5540b;

    zzbj(zzbi com_google_android_gms_ads_internal_zzbi, WeakReference weakReference) {
        this.f5540b = com_google_android_gms_ads_internal_zzbi;
        this.f5539a = weakReference;
    }

    public final void run() {
        this.f5540b.f5534b = false;
        zza com_google_android_gms_ads_internal_zza = (zza) this.f5539a.get();
        if (com_google_android_gms_ads_internal_zza != null) {
            zzjj b = this.f5540b.f5533a;
            if (com_google_android_gms_ads_internal_zza.mo3954c(b)) {
                com_google_android_gms_ads_internal_zza.mo2003b(b);
            } else {
                zzakb.m5370d("Ad is not visible. Not refreshing ad.");
                com_google_android_gms_ads_internal_zza.f17128d.m4472a(b);
            }
        }
    }
}
