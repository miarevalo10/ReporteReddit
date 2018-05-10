package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbq;

public class zzah extends zzo {
    final ArraySet<zzh<?>> f17274b = new ArraySet();
    private zzbm f17275f;

    private zzah(zzcf com_google_android_gms_common_api_internal_zzcf) {
        super(com_google_android_gms_common_api_internal_zzcf);
        this.a.mo1610a("ConnectionlessLifecycleHelper", (LifecycleCallback) this);
    }

    public static void m17589a(Activity activity, zzbm com_google_android_gms_common_api_internal_zzbm, zzh<?> com_google_android_gms_common_api_internal_zzh_) {
        zzcf a = LifecycleCallback.m4679a(activity);
        zzah com_google_android_gms_common_api_internal_zzah = (zzah) a.mo1609a("ConnectionlessLifecycleHelper", zzah.class);
        if (com_google_android_gms_common_api_internal_zzah == null) {
            com_google_android_gms_common_api_internal_zzah = new zzah(a);
        }
        com_google_android_gms_common_api_internal_zzah.f17275f = com_google_android_gms_common_api_internal_zzbm;
        zzbq.m4809a((Object) com_google_android_gms_common_api_internal_zzh_, (Object) "ApiKey cannot be null");
        com_google_android_gms_common_api_internal_zzah.f17274b.add(com_google_android_gms_common_api_internal_zzh_);
        com_google_android_gms_common_api_internal_zzbm.m4728a(com_google_android_gms_common_api_internal_zzah);
    }

    private final void m17590g() {
        if (!this.f17274b.isEmpty()) {
            this.f17275f.m4728a(this);
        }
    }

    protected final void mo3410a(ConnectionResult connectionResult, int i) {
        this.f17275f.m4730b(connectionResult, i);
    }

    public final void mo1615b() {
        super.mo1615b();
        m17590g();
    }

    public final void mo3411c() {
        super.mo3411c();
        m17590g();
    }

    protected final void mo3412e() {
        this.f17275f.m4731c();
    }

    public final void mo1617d() {
        super.mo1617d();
        zzbm com_google_android_gms_common_api_internal_zzbm = this.f17275f;
        synchronized (zzbm.f5775b) {
            if (com_google_android_gms_common_api_internal_zzbm.f5782g == this) {
                com_google_android_gms_common_api_internal_zzbm.f5782g = null;
                com_google_android_gms_common_api_internal_zzbm.f5783h.clear();
            }
        }
    }
}
