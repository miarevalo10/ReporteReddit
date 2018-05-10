package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy.zzb;
import java.security.GeneralSecurityException;

final class zzdqj implements zzdpw<zzdpp> {
    zzdqj() {
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13606d(com_google_android_gms_internal_zzfes);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            return mo1859b(zzdro.m21036a(com_google_android_gms_internal_zzfes));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized AesEaxKeyFormat proto", e);
        }
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return (zzdsy) zzdsy.m21168b().m21164a("type.googleapis.com/google.crypto.tink.AesEaxKey").m21163a(((zzdrm) mo1858b(com_google_android_gms_internal_zzfes)).mo3499g()).m21162a(zzb.SYMMETRIC).m20431f();
    }

    private static zzdpp m13606d(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            com_google_android_gms_internal_zzfes = zzdrm.m21026a(com_google_android_gms_internal_zzfes);
            if (com_google_android_gms_internal_zzfes instanceof zzdrm) {
                zzdrm com_google_android_gms_internal_zzdrm = (zzdrm) com_google_android_gms_internal_zzfes;
                zzdvk.m5924b(com_google_android_gms_internal_zzdrm.f19594a);
                zzdvk.m5923a(com_google_android_gms_internal_zzdrm.f19595b.mo3503a());
                if (com_google_android_gms_internal_zzdrm.m21032a().f19603a == 12 || com_google_android_gms_internal_zzdrm.m21032a().f19603a == 16) {
                    return new zzdty(com_google_android_gms_internal_zzdrm.f19595b.m5959c(), com_google_android_gms_internal_zzdrm.m21032a().f19603a);
                }
                throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
            }
            throw new GeneralSecurityException("expected AesEaxKey proto");
        } catch (zzfes com_google_android_gms_internal_zzfes2) {
            throw new GeneralSecurityException("expected serialized AesEaxKey proto", com_google_android_gms_internal_zzfes2);
        }
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdro) {
            zzdro com_google_android_gms_internal_zzdro = (zzdro) com_google_android_gms_internal_zzfhe;
            zzdvk.m5923a(com_google_android_gms_internal_zzdro.f19599a);
            if (com_google_android_gms_internal_zzdro.m21038a().f19603a == 12 || com_google_android_gms_internal_zzdro.m21038a().f19603a == 16) {
                return zzdrm.m21030b().m21025a(zzfes.m5948a(zzdvi.m5921a(com_google_android_gms_internal_zzdro.f19599a))).m21024a(com_google_android_gms_internal_zzdro.m21038a()).m21023a().m20431f();
            }
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
        throw new GeneralSecurityException("expected AesEaxKeyFormat proto");
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdrm) {
            zzdrm com_google_android_gms_internal_zzdrm = (zzdrm) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdrm.f19594a);
            zzdvk.m5923a(com_google_android_gms_internal_zzdrm.f19595b.mo3503a());
            if (com_google_android_gms_internal_zzdrm.m21032a().f19603a == 12 || com_google_android_gms_internal_zzdrm.m21032a().f19603a == 16) {
                return new zzdty(com_google_android_gms_internal_zzdrm.f19595b.m5959c(), com_google_android_gms_internal_zzdrm.m21032a().f19603a);
            }
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
        throw new GeneralSecurityException("expected AesEaxKey proto");
    }
}
