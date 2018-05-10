package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdth.zzb;
import com.google.android.gms.internal.zzffu.zza;
import java.security.GeneralSecurityException;

public final class zzdpx {
    zzdth f7241a;

    private zzdpx(zzdth com_google_android_gms_internal_zzdth) {
        this.f7241a = com_google_android_gms_internal_zzdth;
    }

    static final zzdpx m5861a(zzdth com_google_android_gms_internal_zzdth) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzdth != null) {
            if (com_google_android_gms_internal_zzdth.m21206a() > 0) {
                return new zzdpx(com_google_android_gms_internal_zzdth);
            }
        }
        throw new GeneralSecurityException("empty keyset");
    }

    public final String toString() {
        zzdth com_google_android_gms_internal_zzdth = this.f7241a;
        zza a = zzdtj.m21226a().m21210a(com_google_android_gms_internal_zzdth.f19684a);
        for (zzb com_google_android_gms_internal_zzdth_zzb : com_google_android_gms_internal_zzdth.f19685b) {
            a.m21211a((zzdtj.zzb) zzdtj.zzb.m21216a().m21215a(com_google_android_gms_internal_zzdth_zzb.m21198a().f19661a).m21213a(com_google_android_gms_internal_zzdth_zzb.m21201b()).m21214a(com_google_android_gms_internal_zzdth_zzb.m21203d()).m21212a(com_google_android_gms_internal_zzdth_zzb.f19679b).m20431f());
        }
        return ((zzdtj) a.m20431f()).toString();
    }
}
