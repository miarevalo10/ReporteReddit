package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

final class zzdqv {
    public static zzdur m5882a(zzdso com_google_android_gms_internal_zzdso) throws GeneralSecurityException {
        switch (zzdqw.f7258b[com_google_android_gms_internal_zzdso.ordinal()]) {
            case 1:
                return zzdur.NIST_P256;
            case 2:
                return zzdur.NIST_P384;
            case 3:
                return zzdur.NIST_P521;
            default:
                String valueOf = String.valueOf(com_google_android_gms_internal_zzdso);
                StringBuilder stringBuilder = new StringBuilder(20 + String.valueOf(valueOf).length());
                stringBuilder.append("unknown curve type: ");
                stringBuilder.append(valueOf);
                throw new GeneralSecurityException(stringBuilder.toString());
        }
    }

    public static zzdus m5883a(zzdsa com_google_android_gms_internal_zzdsa) throws GeneralSecurityException {
        switch (zzdqw.f7259c[com_google_android_gms_internal_zzdsa.ordinal()]) {
            case 1:
                return zzdus.UNCOMPRESSED;
            case 2:
                return zzdus.COMPRESSED;
            default:
                String valueOf = String.valueOf(com_google_android_gms_internal_zzdsa);
                StringBuilder stringBuilder = new StringBuilder(22 + String.valueOf(valueOf).length());
                stringBuilder.append("unknown point format: ");
                stringBuilder.append(valueOf);
                throw new GeneralSecurityException(stringBuilder.toString());
        }
    }

    public static String m5884a(zzdsq com_google_android_gms_internal_zzdsq) throws NoSuchAlgorithmException {
        switch (zzdqw.f7257a[com_google_android_gms_internal_zzdsq.ordinal()]) {
            case 1:
                return "HmacSha1";
            case 2:
                return "HmacSha256";
            case 3:
                return "HmacSha512";
            default:
                String valueOf = String.valueOf(com_google_android_gms_internal_zzdsq);
                StringBuilder stringBuilder = new StringBuilder(27 + String.valueOf(valueOf).length());
                stringBuilder.append("hash unsupported for HMAC: ");
                stringBuilder.append(valueOf);
                throw new NoSuchAlgorithmException(stringBuilder.toString());
        }
    }

    public static void m5885a(zzdsg com_google_android_gms_internal_zzdsg) throws GeneralSecurityException {
        zzdup.m5906a(m5882a(com_google_android_gms_internal_zzdsg.m21093a().m21130a()));
        m5884a(com_google_android_gms_internal_zzdsg.m21093a().m21133b());
        if (com_google_android_gms_internal_zzdsg.m21098d() == zzdsa.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzdqe.m5870a(com_google_android_gms_internal_zzdsg.m21096b().m21081a());
    }
}
