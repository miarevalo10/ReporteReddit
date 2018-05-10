package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.zzbq;

public final class zzci<L> {
    public volatile L f5810a;
    public final zzck<L> f5811b;
    private final zzcj f5812c;

    zzci(Looper looper, L l, String str) {
        this.f5812c = new zzcj(this, looper);
        this.f5810a = zzbq.m4809a((Object) l, (Object) "Listener must not be null");
        this.f5811b = new zzck(l, zzbq.m4810a(str));
    }

    public final void m4755a(zzcl<? super L> com_google_android_gms_common_api_internal_zzcl__super_L) {
        zzbq.m4809a((Object) com_google_android_gms_common_api_internal_zzcl__super_L, (Object) "Notifier must not be null");
        this.f5812c.sendMessage(this.f5812c.obtainMessage(1, com_google_android_gms_common_api_internal_zzcl__super_L));
    }
}
