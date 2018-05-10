package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.zzcxi;
import com.google.android.gms.internal.zzcxq;
import java.lang.ref.WeakReference;

final class zzav extends zzcxi {
    private final WeakReference<zzao> f19107a;

    zzav(zzao com_google_android_gms_common_api_internal_zzao) {
        this.f19107a = new WeakReference(com_google_android_gms_common_api_internal_zzao);
    }

    public final void mo3496a(zzcxq com_google_android_gms_internal_zzcxq) {
        zzao com_google_android_gms_common_api_internal_zzao = (zzao) this.f19107a.get();
        if (com_google_android_gms_common_api_internal_zzao != null) {
            com_google_android_gms_common_api_internal_zzao.f13859a.m17604a(new zzaw(com_google_android_gms_common_api_internal_zzao, com_google_android_gms_common_api_internal_zzao, com_google_android_gms_internal_zzcxq));
        }
    }
}
