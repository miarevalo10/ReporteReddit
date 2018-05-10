package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdrs.zza;
import java.security.GeneralSecurityException;
import java.util.Arrays;

final class zzdqx implements zzduj {
    private final String f14309a;
    private final int f14310b;
    private zzdrs f14311c;
    private zzdrc f14312d;
    private int f14313e;

    public final int mo1863a() {
        return this.f14310b;
    }

    zzdqx(zzdtd com_google_android_gms_internal_zzdtd) throws GeneralSecurityException {
        this.f14309a = com_google_android_gms_internal_zzdtd.f19666a;
        if (this.f14309a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzdru a = zzdru.m21060a(com_google_android_gms_internal_zzdtd.f19667b);
                this.f14311c = (zzdrs) zzdqe.m5878b(com_google_android_gms_internal_zzdtd);
                this.f14310b = a.f19612b;
            } catch (zzdtd com_google_android_gms_internal_zzdtd2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", com_google_android_gms_internal_zzdtd2);
            }
        } else if (this.f14309a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzdre a2 = zzdre.m20990a(com_google_android_gms_internal_zzdtd2.f19667b);
                this.f14312d = (zzdrc) zzdqe.m5878b(com_google_android_gms_internal_zzdtd2);
                this.f14313e = a2.m20992a().f19587a;
                this.f14310b = this.f14313e + a2.m20995b().f19653a;
            } catch (zzdtd com_google_android_gms_internal_zzdtd22) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", com_google_android_gms_internal_zzdtd22);
            }
        } else {
            String str = "unsupported AEAD DEM key type: ";
            String valueOf = String.valueOf(this.f14309a);
            throw new GeneralSecurityException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public final zzdpp mo1864a(byte[] bArr) throws GeneralSecurityException {
        if (this.f14309a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            return (zzdpp) zzdqe.m5879b(this.f14309a, (zzdrs) ((zza) zzdrs.m21050a().m20427a(this.f14311c)).m21049a(zzfes.m5948a(bArr)).m20431f());
        } else if (this.f14309a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.f14313e);
            zzdss com_google_android_gms_internal_zzdss = (zzdss) ((zzdss.zza) zzdss.m21142b().m20427a(this.f14312d.m20988b())).m21137a(zzfes.m5948a(Arrays.copyOfRange(bArr, this.f14313e, this.f14310b))).m20431f();
            return (zzdpp) zzdqe.m5879b(this.f14309a, (zzdrc) zzdrc.m20983d().m20976a(this.f14312d.f19573a).m20977a((zzdrg) ((zzdrg.zza) zzdrg.m21004b().m20427a(this.f14312d.m20985a())).m20999a(zzfes.m5948a(copyOfRange)).m20431f()).m20978a(com_google_android_gms_internal_zzdss).m20431f());
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
