package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdsy.zzb;
import java.security.GeneralSecurityException;

final class zzdql implements zzdpw<zzdpp> {
    zzdql() {
    }

    private static zzdry m13618a() throws GeneralSecurityException {
        return (zzdry) zzdry.m21071a().m21069a().m21070a(zzfes.m5948a(zzdvi.m5921a(32))).m20431f();
    }

    public final /* synthetic */ Object mo1856a(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13619d(com_google_android_gms_internal_zzfes);
    }

    public final zzfhe mo1858b(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return m13618a();
    }

    public final zzfhe mo1859b(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        return m13618a();
    }

    public final zzdsy mo1860c(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        return (zzdsy) zzdsy.m21168b().m21164a("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key").m21163a(m13618a().mo3499g()).m21162a(zzb.SYMMETRIC).m20431f();
    }

    private static zzdpp m13619d(zzfes com_google_android_gms_internal_zzfes) throws GeneralSecurityException {
        try {
            com_google_android_gms_internal_zzfes = zzdry.m21072a(com_google_android_gms_internal_zzfes);
            if (com_google_android_gms_internal_zzfes instanceof zzdry) {
                zzdry com_google_android_gms_internal_zzdry = (zzdry) com_google_android_gms_internal_zzfes;
                zzdvk.m5924b(com_google_android_gms_internal_zzdry.f19617a);
                if (com_google_android_gms_internal_zzdry.f19618b.mo3503a() == 32) {
                    return zzdug.m13696a(com_google_android_gms_internal_zzdry.f19618b.m5959c());
                }
                throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
            }
            throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
        } catch (zzfes com_google_android_gms_internal_zzfes2) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305 key", com_google_android_gms_internal_zzfes2);
        }
    }

    public final /* synthetic */ Object mo1857a(zzfhe com_google_android_gms_internal_zzfhe) throws GeneralSecurityException {
        if (com_google_android_gms_internal_zzfhe instanceof zzdry) {
            zzdry com_google_android_gms_internal_zzdry = (zzdry) com_google_android_gms_internal_zzfhe;
            zzdvk.m5924b(com_google_android_gms_internal_zzdry.f19617a);
            if (com_google_android_gms_internal_zzdry.f19618b.mo3503a() == 32) {
                return zzdug.m13696a(com_google_android_gms_internal_zzdry.f19618b.m5959c());
            }
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
        throw new GeneralSecurityException("expected ChaCha20Poly1305Key proto");
    }
}
