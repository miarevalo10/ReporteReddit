package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy.zzb;
import java.security.GeneralSecurityException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

final class zzdqy implements zzdpw<zzdqa> {
    zzdqy() {
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13656d(com_google_android_gms_internal_zzfes);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            return mo1859b(zzdsu.m21149a(com_google_android_gms_internal_zzfes));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e);
        }
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return (zzdsy) zzdsy.m21168b().m21164a("type.googleapis.com/google.crypto.tink.HmacKey").m21163a(((zzdss) mo1858b(com_google_android_gms_internal_zzfes)).mo3499g()).m21162a(zzb.SYMMETRIC).m20431f();
    }

    private static zzdqa m13656d(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            com_google_android_gms_internal_zzfes = zzdss.m21138a(com_google_android_gms_internal_zzfes);
            if (com_google_android_gms_internal_zzfes instanceof zzdss) {
                zzdss com_google_android_gms_internal_zzdss = (zzdss) com_google_android_gms_internal_zzfes;
                zzdvk.m5924b(com_google_android_gms_internal_zzdss.f19648a);
                if (com_google_android_gms_internal_zzdss.f19649b.mo3503a() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                zzdvg com_google_android_gms_internal_zzdvg;
                m13655a(com_google_android_gms_internal_zzdss.m21145a());
                zzdsq a = com_google_android_gms_internal_zzdss.m21145a().m21158a();
                Key secretKeySpec = new SecretKeySpec(com_google_android_gms_internal_zzdss.f19649b.m5959c(), "HMAC");
                com_google_android_gms_internal_zzfes = com_google_android_gms_internal_zzdss.m21145a().f19657a;
                switch (zzdqz.f7260a[a.ordinal()]) {
                    case 1:
                        com_google_android_gms_internal_zzdvg = new zzdvg("HMACSHA1", secretKeySpec, com_google_android_gms_internal_zzfes);
                        break;
                    case 2:
                        com_google_android_gms_internal_zzdvg = new zzdvg("HMACSHA256", secretKeySpec, com_google_android_gms_internal_zzfes);
                        break;
                    case 3:
                        com_google_android_gms_internal_zzdvg = new zzdvg("HMACSHA512", secretKeySpec, com_google_android_gms_internal_zzfes);
                        break;
                    default:
                        throw new GeneralSecurityException("unknown hash");
                }
                return com_google_android_gms_internal_zzdvg;
            }
            throw new GeneralSecurityException("expected HmacKey proto");
        } catch (zzfes com_google_android_gms_internal_zzfes2) {
            throw new GeneralSecurityException("expected serialized HmacKey proto", com_google_android_gms_internal_zzfes2);
        }
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdsu) {
            zzdsu com_google_android_gms_internal_zzdsu = (zzdsu) com_google_android_gms_internal_zzfhe;
            if (com_google_android_gms_internal_zzdsu.f19653a < 16) {
                throw new GeneralSecurityException("key too short");
            }
            m13655a(com_google_android_gms_internal_zzdsu.m21152a());
            return zzdss.m21142b().m21135a().m21136a(com_google_android_gms_internal_zzdsu.m21152a()).m21137a(zzfes.m5948a(zzdvi.m5921a(com_google_android_gms_internal_zzdsu.f19653a))).m20431f();
        }
        throw new GeneralSecurityException("expected HmacKeyFormat proto");
    }

    private static void m13655a(zzdsw com_google_android_gms_internal_zzdsw) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzdsw.f19657a < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        switch (zzdqz.f7260a[com_google_android_gms_internal_zzdsw.m21158a().ordinal()]) {
            case 1:
                if (com_google_android_gms_internal_zzdsw.f19657a > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case 2:
                if (com_google_android_gms_internal_zzdsw.f19657a > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            case 3:
                if (com_google_android_gms_internal_zzdsw.f19657a > 64) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            default:
                throw new GeneralSecurityException("unknown hash type");
        }
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdss) {
            zzdss com_google_android_gms_internal_zzdss = (zzdss) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdss.f19648a);
            if (com_google_android_gms_internal_zzdss.f19649b.mo3503a() < 16) {
                throw new GeneralSecurityException("key too short");
            }
            m13655a(com_google_android_gms_internal_zzdss.m21145a());
            zzdsq a = com_google_android_gms_internal_zzdss.m21145a().m21158a();
            Key secretKeySpec = new SecretKeySpec(com_google_android_gms_internal_zzdss.f19649b.m5959c(), "HMAC");
            com_google_android_gms_internal_zzfhe = com_google_android_gms_internal_zzdss.m21145a().f19657a;
            switch (zzdqz.f7260a[a.ordinal()]) {
                case 1:
                    return new zzdvg("HMACSHA1", secretKeySpec, com_google_android_gms_internal_zzfhe);
                case 2:
                    return new zzdvg("HMACSHA256", secretKeySpec, com_google_android_gms_internal_zzfhe);
                case 3:
                    return new zzdvg("HMACSHA512", secretKeySpec, com_google_android_gms_internal_zzfhe);
                default:
                    throw new GeneralSecurityException("unknown hash");
            }
        }
        throw new GeneralSecurityException("expected HmacKey proto");
    }
}
