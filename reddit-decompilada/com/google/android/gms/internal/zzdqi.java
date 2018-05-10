package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy.zzb;
import java.security.GeneralSecurityException;

final class zzdqi implements zzdpw<zzdvf> {
    zzdqi() {
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13600d(com_google_android_gms_internal_zzfes);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            return mo1859b(zzdri.m21011a(com_google_android_gms_internal_zzfes));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrKeyFormat proto", e);
        }
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return (zzdsy) zzdsy.m21168b().m21164a("type.googleapis.com/google.crypto.tink.AesCtrKey").m21163a(((zzdrg) mo1858b(com_google_android_gms_internal_zzfes)).mo3499g()).m21162a(zzb.SYMMETRIC).m20431f();
    }

    private static zzdtx m13600d(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            com_google_android_gms_internal_zzfes = zzdrg.m21000a(com_google_android_gms_internal_zzfes);
            if (com_google_android_gms_internal_zzfes instanceof zzdrg) {
                zzdrg com_google_android_gms_internal_zzdrg = (zzdrg) com_google_android_gms_internal_zzfes;
                zzdvk.m5924b(com_google_android_gms_internal_zzdrg.f19582a);
                zzdvk.m5923a(com_google_android_gms_internal_zzdrg.f19583b.mo3503a());
                m13599a(com_google_android_gms_internal_zzdrg.m21007a());
                return new zzdtx(com_google_android_gms_internal_zzdrg.f19583b.m5959c(), com_google_android_gms_internal_zzdrg.m21007a().f19591a);
            }
            throw new GeneralSecurityException("expected AesCtrKey proto");
        } catch (zzfes com_google_android_gms_internal_zzfes2) {
            throw new GeneralSecurityException("expected serialized AesCtrKey proto", com_google_android_gms_internal_zzfes2);
        }
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdri) {
            zzdri com_google_android_gms_internal_zzdri = (zzdri) com_google_android_gms_internal_zzfhe;
            zzdvk.m5923a(com_google_android_gms_internal_zzdri.f19587a);
            m13599a(com_google_android_gms_internal_zzdri.m21014a());
            return zzdrg.m21004b().m20998a(com_google_android_gms_internal_zzdri.m21014a()).m20999a(zzfes.m5948a(zzdvi.m5921a(com_google_android_gms_internal_zzdri.f19587a))).m20997a().m20431f();
        }
        throw new GeneralSecurityException("expected AesCtrKeyFormat proto");
    }

    private static void m13599a(zzdrk com_google_android_gms_internal_zzdrk) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzdrk.f19591a >= 12) {
            if (com_google_android_gms_internal_zzdrk.f19591a <= 16) {
                return;
            }
        }
        throw new GeneralSecurityException("invalid IV size");
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdrg) {
            zzdrg com_google_android_gms_internal_zzdrg = (zzdrg) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdrg.f19582a);
            zzdvk.m5923a(com_google_android_gms_internal_zzdrg.f19583b.mo3503a());
            m13599a(com_google_android_gms_internal_zzdrg.m21007a());
            return new zzdtx(com_google_android_gms_internal_zzdrg.f19583b.m5959c(), com_google_android_gms_internal_zzdrg.m21007a().f19591a);
        }
        throw new GeneralSecurityException("expected AesCtrKey proto");
    }
}
