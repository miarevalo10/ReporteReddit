package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy.zzb;
import java.security.GeneralSecurityException;

final class zzdqm implements zzdpw<zzdpp> {
    zzdqm() {
    }

    private static zzdpp m13626d(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            return m13625c(zzdtl.m21236a(com_google_android_gms_internal_zzfes));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected KmsAeadKey proto", e);
        }
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13626d(com_google_android_gms_internal_zzfes);
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        return m13625c(com_google_android_gms_internal_zzfhe);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            return mo1859b(zzdtn.m21244a(com_google_android_gms_internal_zzfes));
        } catch (Throwable e) {
            throw new GeneralSecurityException("expected serialized KmsAeadKeyFormat proto", e);
        }
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdtn) {
            return zzdtl.m21235a().m21234a((zzdtn) com_google_android_gms_internal_zzfhe).m21233a().m20431f();
        }
        throw new GeneralSecurityException("expected KmsAeadKeyFormat proto");
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return (zzdsy) zzdsy.m21168b().m21164a("type.googleapis.com/google.crypto.tink.KmsAeadKey").m21163a(((zzdtl) mo1858b(com_google_android_gms_internal_zzfes)).mo3499g()).m21162a(zzb.REMOTE).m20431f();
    }

    private static zzdpp m13625c(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdtl) {
            zzdtl com_google_android_gms_internal_zzdtl = (zzdtl) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdtl.f19700a);
            return zzdpz.m5864a((com_google_android_gms_internal_zzdtl.f19701b == null ? zzdtn.m21243a() : com_google_android_gms_internal_zzdtl.f19701b).f19704a).m5863b();
        }
        throw new GeneralSecurityException("expected KmsAeadKey proto");
    }
}
