package com.google.android.gms.internal;

import com.google.android.gms.internal.zzdtv.zza;
import java.security.GeneralSecurityException;

public final class zzdqg {
    public static final zzdtv f7254a = ((zzdtv) ((zza) zzdtv.m21269a().m20427a(zzdrb.f7262a)).m21267a(zzdpr.m5854a("TinkAead", "Aead", "AesCtrHmacAeadKey")).m21267a(zzdpr.m5854a("TinkAead", "Aead", "AesEaxKey")).m21267a(zzdpr.m5854a("TinkAead", "Aead", "AesGcmKey")).m21267a(zzdpr.m5854a("TinkAead", "Aead", "ChaCha20Poly1305Key")).m21267a(zzdpr.m5854a("TinkAead", "Aead", "KmsAeadKey")).m21267a(zzdpr.m5854a("TinkAead", "Aead", "KmsEnvelopeAeadKey")).m21268a("TINK_AEAD_1_0_0").m20431f());

    static {
        try {
            m5880a();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void m5880a() throws GeneralSecurityException {
        zzdqe.m5874a("TinkAead", new zzdqf());
        zzdrb.m5894a();
    }
}
