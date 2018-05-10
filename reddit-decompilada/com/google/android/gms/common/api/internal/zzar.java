package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.internal.zzj;
import java.util.Map;

final class zzar extends zzay {
    final /* synthetic */ zzao f13883a;
    private final Map<zze, zzaq> f13884b;

    public zzar(zzao com_google_android_gms_common_api_internal_zzao, Map<zze, zzaq> map) {
        this.f13883a = com_google_android_gms_common_api_internal_zzao;
        super(com_google_android_gms_common_api_internal_zzao);
        this.f13884b = map;
    }

    public final void mo1580a() {
        int i = 0;
        int i2 = 0;
        for (zze com_google_android_gms_common_api_Api_zze : this.f13884b.keySet()) {
            if (!((zzaq) this.f13884b.get(com_google_android_gms_common_api_Api_zze)).f13882c) {
                i2 = 1;
                break;
            }
            i2 = 1;
        }
        if (i2 != 0) {
            i = this.f13883a.f13862d.mo1537a(this.f13883a.f13861c);
        }
        if (i != 0) {
            this.f13883a.f13859a.m17604a(new zzas(this, this.f13883a, new ConnectionResult(i, null)));
            return;
        }
        if (this.f13883a.f13871m) {
            this.f13883a.f13869k.mo4027l();
        }
        for (zze com_google_android_gms_common_api_Api_zze2 : this.f13884b.keySet()) {
            zzj com_google_android_gms_common_internal_zzj = (zzj) this.f13884b.get(com_google_android_gms_common_api_Api_zze2);
            if (i != 0) {
                this.f13883a.f13859a.m17604a(new zzat(this.f13883a, com_google_android_gms_common_internal_zzj));
            } else {
                com_google_android_gms_common_api_Api_zze2.m12806a(com_google_android_gms_common_internal_zzj);
            }
        }
    }
}
