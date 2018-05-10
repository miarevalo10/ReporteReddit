package com.google.android.gms.internal;

import java.security.GeneralSecurityException;

public final class zzdrb {
    public static final zzdtv f7262a = ((zzdtv) zzdtv.m21269a().m21268a("TINK_MAC_1_0_0").m21267a(zzdpr.m5854a("TinkMac", "Mac", "HmacKey")).m20431f());

    static {
        try {
            m5894a();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void m5894a() throws GeneralSecurityException {
        zzdqe.m5874a("TinkMac", new zzdra());
    }
}
