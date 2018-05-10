package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy.zzb;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;

class zzdqh implements zzdpw<zzdpp> {
    private static final Logger f14304a = Logger.getLogger(zzdqh.class.getName());

    zzdqh() throws GeneralSecurityException {
        zzdqe.m5875a("type.googleapis.com/google.crypto.tink.AesCtrKey", new zzdqi());
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13593d(com_google_android_gms_internal_zzfes);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            return mo1859b(zzdre.m20990a(com_google_android_gms_internal_zzfes));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKeyFormat proto", e);
        }
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdre) {
            zzdre com_google_android_gms_internal_zzdre = (zzdre) com_google_android_gms_internal_zzfhe;
            zzdrg com_google_android_gms_internal_zzdrg = (zzdrg) zzdqe.m5871a("type.googleapis.com/google.crypto.tink.AesCtrKey", com_google_android_gms_internal_zzdre.m20992a());
            return zzdrc.m20983d().m20977a(com_google_android_gms_internal_zzdrg).m20978a((zzdss) zzdqe.m5871a("type.googleapis.com/google.crypto.tink.HmacKey", com_google_android_gms_internal_zzdre.m20995b())).m20976a(0).m20431f();
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKeyFormat proto");
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return (zzdsy) zzdsy.m21168b().m21164a("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey").m21163a(((zzdrc) mo1858b(com_google_android_gms_internal_zzfes)).mo3499g()).m21162a(zzb.SYMMETRIC).m20431f();
    }

    private static zzdpp m13593d(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            com_google_android_gms_internal_zzfes = zzdrc.m20979a(com_google_android_gms_internal_zzfes);
            if (com_google_android_gms_internal_zzfes instanceof zzdrc) {
                zzdrc com_google_android_gms_internal_zzdrc = (zzdrc) com_google_android_gms_internal_zzfes;
                zzdvk.m5924b(com_google_android_gms_internal_zzdrc.f19573a);
                return new zzdut((zzdvf) zzdqe.m5879b("type.googleapis.com/google.crypto.tink.AesCtrKey", com_google_android_gms_internal_zzdrc.m20985a()), (zzdqa) zzdqe.m5879b("type.googleapis.com/google.crypto.tink.HmacKey", com_google_android_gms_internal_zzdrc.m20988b()), com_google_android_gms_internal_zzdrc.m20988b().m21145a().f19657a);
            }
            throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
        } catch (zzfes com_google_android_gms_internal_zzfes2) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKey proto", com_google_android_gms_internal_zzfes2);
        }
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdrc) {
            zzdrc com_google_android_gms_internal_zzdrc = (zzdrc) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdrc.f19573a);
            return new zzdut((zzdvf) zzdqe.m5879b("type.googleapis.com/google.crypto.tink.AesCtrKey", com_google_android_gms_internal_zzdrc.m20985a()), (zzdqa) zzdqe.m5879b("type.googleapis.com/google.crypto.tink.HmacKey", com_google_android_gms_internal_zzdrc.m20988b()), com_google_android_gms_internal_zzdrc.m20988b().m21145a().f19657a);
        }
        throw new GeneralSecurityException("expected AesCtrHmacAeadKey proto");
    }
}
