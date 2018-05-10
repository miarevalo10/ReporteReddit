package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy.zzb;
import java.security.GeneralSecurityException;

final class zzdqo implements zzdpw<zzdpp> {
    zzdqo() {
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13633d(com_google_android_gms_internal_zzfes);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            return mo1859b(zzdtr.m21260a(com_google_android_gms_internal_zzfes));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized KmsEnvelopeAeadKeyFormat proto", e);
        }
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdtr) {
            return zzdtp.m21254b().m21250a((zzdtr) com_google_android_gms_internal_zzfhe).m21249a().m20431f();
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKeyFormat proto");
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return (zzdsy) zzdsy.m21168b().m21164a("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey").m21163a(((zzdtp) mo1858b(com_google_android_gms_internal_zzfes)).mo3499g()).m21162a(zzb.REMOTE).m20431f();
    }

    private static zzdpp m13633d(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            com_google_android_gms_internal_zzfes = zzdtp.m21251a(com_google_android_gms_internal_zzfes);
            if (com_google_android_gms_internal_zzfes instanceof zzdtp) {
                zzdtp com_google_android_gms_internal_zzdtp = (zzdtp) com_google_android_gms_internal_zzfes;
                zzdvk.m5924b(com_google_android_gms_internal_zzdtp.f19707a);
                return new zzdqn(com_google_android_gms_internal_zzdtp.m21256a().m21263a(), zzdpz.m5864a(com_google_android_gms_internal_zzdtp.m21256a().f19711a).m5863b());
            }
            throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
        } catch (zzfes com_google_android_gms_internal_zzfes2) {
            throw new GeneralSecurityException("expected serialized KmSEnvelopeAeadKey proto", com_google_android_gms_internal_zzfes2);
        }
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdtp) {
            zzdtp com_google_android_gms_internal_zzdtp = (zzdtp) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdtp.f19707a);
            return new zzdqn(com_google_android_gms_internal_zzdtp.m21256a().m21263a(), zzdpz.m5864a(com_google_android_gms_internal_zzdtp.m21256a().f19711a).m5863b());
        }
        throw new GeneralSecurityException("expected KmsEnvelopeAeadKey proto");
    }
}
