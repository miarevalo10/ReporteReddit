package com.google.android.gms.internal;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;

final class zzdqq implements zzdpw<zzdpv> {
    zzdqq() {
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13645d(com_google_android_gms_internal_zzfes);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    private static zzdpv m13645d(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            com_google_android_gms_internal_zzfes = zzdsk.m21116a(com_google_android_gms_internal_zzfes);
            if (com_google_android_gms_internal_zzfes instanceof zzdsk) {
                zzdsk com_google_android_gms_internal_zzdsk = (zzdsk) com_google_android_gms_internal_zzfes;
                zzdvk.m5924b(com_google_android_gms_internal_zzdsk.f19637a);
                zzdqv.m5885a(com_google_android_gms_internal_zzdsk.m21124a());
                zzdsg a = com_google_android_gms_internal_zzdsk.m21124a();
                zzdsm a2 = a.m21093a();
                zzdur a3 = zzdqv.m5882a(a2.m21130a());
                byte[] c = com_google_android_gms_internal_zzdsk.f19638b.m5959c();
                com_google_android_gms_internal_zzfes = com_google_android_gms_internal_zzdsk.f19639c.m5959c();
                ECParameterSpec a4 = zzdup.m5906a(a3);
                com_google_android_gms_internal_zzfes = new ECPoint(new BigInteger(1, c), new BigInteger(1, com_google_android_gms_internal_zzfes));
                zzdup.m5908a(com_google_android_gms_internal_zzfes, a4.getCurve());
                return (zzdpv) new zzdul((ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(com_google_android_gms_internal_zzfes, a4)), a2.f19643a.m5959c(), zzdqv.m5884a(a2.m21133b()), zzdqv.m5883a(a.m21098d()), new zzdqx(a.m21096b().m21081a()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
        } catch (zzfes com_google_android_gms_internal_zzfes2) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPublicKey proto", com_google_android_gms_internal_zzfes2);
        }
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdsk) {
            zzdsk com_google_android_gms_internal_zzdsk = (zzdsk) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdsk.f19637a);
            zzdqv.m5885a(com_google_android_gms_internal_zzdsk.m21124a());
            zzdsg a = com_google_android_gms_internal_zzdsk.m21124a();
            zzdsm a2 = a.m21093a();
            zzdur a3 = zzdqv.m5882a(a2.m21130a());
            byte[] c = com_google_android_gms_internal_zzdsk.f19638b.m5959c();
            com_google_android_gms_internal_zzfhe = com_google_android_gms_internal_zzdsk.f19639c.m5959c();
            ECParameterSpec a4 = zzdup.m5906a(a3);
            com_google_android_gms_internal_zzfhe = new ECPoint(new BigInteger(1, c), new BigInteger(1, com_google_android_gms_internal_zzfhe));
            zzdup.m5908a(com_google_android_gms_internal_zzfhe, a4.getCurve());
            return new zzdul((ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(com_google_android_gms_internal_zzfhe, a4)), a2.f19643a.m5959c(), zzdqv.m5884a(a2.m21133b()), zzdqv.m5883a(a.m21098d()), new zzdqx(a.m21096b().m21081a()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPublicKey proto");
    }
}
