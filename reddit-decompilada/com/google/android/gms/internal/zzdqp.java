package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy.zzb;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;

final class zzdqp implements zzdpw<zzdpu> {
    zzdqp() {
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13639d(com_google_android_gms_internal_zzfes);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            return mo1859b(zzdse.m21085a(com_google_android_gms_internal_zzfes));
        } catch (Throwable e) {
            throw new GeneralSecurityException("invalid EciesAeadHkdf key format", e);
        }
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdse) {
            zzdse com_google_android_gms_internal_zzdse = (zzdse) com_google_android_gms_internal_zzfhe;
            zzdqv.m5885a(com_google_android_gms_internal_zzdse.m21087a());
            AlgorithmParameterSpec a = zzdup.m5906a(zzdqv.m5882a(com_google_android_gms_internal_zzdse.m21087a().m21093a().m21130a()));
            KeyPairGenerator instance = KeyPairGenerator.getInstance("EC");
            instance.initialize(a);
            KeyPair generateKeyPair = instance.generateKeyPair();
            ECPublicKey eCPublicKey = (ECPublicKey) generateKeyPair.getPublic();
            ECPrivateKey eCPrivateKey = (ECPrivateKey) generateKeyPair.getPrivate();
            ECPoint w = eCPublicKey.getW();
            return zzdsi.m21106b().m21099a().m21100a((zzdsk) zzdsk.m21120b().m21112a().m21113a(com_google_android_gms_internal_zzdse.m21087a()).m21114a(zzfes.m5948a(w.getAffineX().toByteArray())).m21115b(zzfes.m5948a(w.getAffineY().toByteArray())).m20431f()).m21101a(zzfes.m5948a(eCPrivateKey.getS().toByteArray())).m20431f();
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfKeyFormat proto");
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return (zzdsy) zzdsy.m21168b().m21164a("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").m21163a(((zzdsi) mo1858b(com_google_android_gms_internal_zzfes)).mo3499g()).m21162a(zzb.ASYMMETRIC_PRIVATE).m20431f();
    }

    private static zzdpu m13639d(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            com_google_android_gms_internal_zzfes = zzdsi.m21102a(com_google_android_gms_internal_zzfes);
            if (com_google_android_gms_internal_zzfes instanceof zzdsi) {
                zzdsi com_google_android_gms_internal_zzdsi = (zzdsi) com_google_android_gms_internal_zzfes;
                zzdvk.m5924b(com_google_android_gms_internal_zzdsi.f19632a);
                zzdqv.m5885a(com_google_android_gms_internal_zzdsi.m21108a().m21124a());
                zzdsg a = com_google_android_gms_internal_zzdsi.m21108a().m21124a();
                zzdsm a2 = a.m21093a();
                zzdur a3 = zzdqv.m5882a(a2.m21130a());
                com_google_android_gms_internal_zzfes = com_google_android_gms_internal_zzdsi.f19633b.m5959c();
                return (zzdpu) new zzduk((ECPrivateKey) KeyFactory.getInstance("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, com_google_android_gms_internal_zzfes), zzdup.m5906a(a3))), a2.f19643a.m5959c(), zzdqv.m5884a(a2.m21133b()), zzdqv.m5883a(a.m21098d()), new zzdqx(a.m21096b().m21081a()));
            }
            throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
        } catch (zzfes com_google_android_gms_internal_zzfes2) {
            throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", com_google_android_gms_internal_zzfes2);
        }
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdsi) {
            zzdsi com_google_android_gms_internal_zzdsi = (zzdsi) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdsi.f19632a);
            zzdqv.m5885a(com_google_android_gms_internal_zzdsi.m21108a().m21124a());
            zzdsg a = com_google_android_gms_internal_zzdsi.m21108a().m21124a();
            zzdsm a2 = a.m21093a();
            zzdur a3 = zzdqv.m5882a(a2.m21130a());
            com_google_android_gms_internal_zzfhe = com_google_android_gms_internal_zzdsi.f19633b.m5959c();
            return new zzduk((ECPrivateKey) KeyFactory.getInstance("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, com_google_android_gms_internal_zzfhe), zzdup.m5906a(a3))), a2.f19643a.m5959c(), zzdqv.m5884a(a2.m21133b()), zzdqv.m5883a(a.m21098d()), new zzdqx(a.m21096b().m21081a()));
        }
        throw new GeneralSecurityException("expected EciesAeadHkdfPrivateKey proto");
    }
}
