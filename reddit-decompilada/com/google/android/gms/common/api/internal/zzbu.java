package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzj;
import java.util.Set;

final class zzbu implements zzcy, zzj {
    final /* synthetic */ zzbm f13932a;
    private final zze f13933b;
    private final zzh<?> f13934c;
    private zzan f13935d = null;
    private Set<Scope> f13936e = null;
    private boolean f13937f = false;

    public zzbu(zzbm com_google_android_gms_common_api_internal_zzbm, zze com_google_android_gms_common_api_Api_zze, zzh<?> com_google_android_gms_common_api_internal_zzh_) {
        this.f13932a = com_google_android_gms_common_api_internal_zzbm;
        this.f13933b = com_google_android_gms_common_api_Api_zze;
        this.f13934c = com_google_android_gms_common_api_internal_zzh_;
    }

    private final void m12995a() {
        if (this.f13937f && this.f13935d != null) {
            this.f13933b.m12805a(this.f13935d, this.f13936e);
        }
    }

    public final void mo1579a(ConnectionResult connectionResult) {
        this.f13932a.f5784i.post(new zzbv(this, connectionResult));
    }

    public final void mo1606a(zzan com_google_android_gms_common_internal_zzan, Set<Scope> set) {
        if (com_google_android_gms_common_internal_zzan != null) {
            if (set != null) {
                this.f13935d = com_google_android_gms_common_internal_zzan;
                this.f13936e = set;
                m12995a();
                return;
            }
        }
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        mo1607b(new ConnectionResult(4));
    }

    public final void mo1607b(ConnectionResult connectionResult) {
        zzbo com_google_android_gms_common_api_internal_zzbo = (zzbo) this.f13932a.f5781f.get(this.f13934c);
        zzbq.m4812a(com_google_android_gms_common_api_internal_zzbo.f17298h.f5784i);
        com_google_android_gms_common_api_internal_zzbo.f17291a.mo4292e();
        com_google_android_gms_common_api_internal_zzbo.mo1583a(connectionResult);
    }
}
