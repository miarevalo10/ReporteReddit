package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi.zza;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.internal.zzbq;

public final class zzd {
    private zzcz f5858a;
    private Looper f5859b;

    public final zza m4775a() {
        if (this.f5858a == null) {
            this.f5858a = new zzg();
        }
        if (this.f5859b == null) {
            this.f5859b = Looper.getMainLooper();
        }
        return new zza(this.f5858a, this.f5859b);
    }

    public final zzd m4776a(Looper looper) {
        zzbq.m4809a((Object) looper, (Object) "Looper must not be null.");
        this.f5859b = looper;
        return this;
    }

    public final zzd m4777a(zzcz com_google_android_gms_common_api_internal_zzcz) {
        zzbq.m4809a((Object) com_google_android_gms_common_api_internal_zzcz, (Object) "StatusExceptionMapper must not be null.");
        this.f5858a = com_google_android_gms_common_api_internal_zzcz;
        return this;
    }
}
