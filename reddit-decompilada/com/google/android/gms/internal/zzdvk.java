package com.google.android.gms.internal;

import java.security.GeneralSecurityException;
import java.util.regex.Pattern;

public final class zzdvk {
    private static final Pattern f7342a = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s$", new Object[]{"([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"}), 2);
    private static final Pattern f7343b = Pattern.compile(String.format("^projects/%s/locations/%s/keyRings/%s/cryptoKeys/%s/cryptoKeyVersions/%s$", new Object[]{"([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+", "([0-9a-zA-Z\\-\\.\\_~])+"}), 2);

    public static void m5923a(int i) throws GeneralSecurityException {
        if (i != 16 && i != 24 && i != 32) {
            throw new GeneralSecurityException("invalid AES key size");
        }
    }

    public static void m5924b(int i) throws GeneralSecurityException {
        if (i >= 0) {
            if (i <= 0) {
                return;
            }
        }
        throw new GeneralSecurityException(String.format("key has version %d; only keys with version in range [0..%d] are supported", new Object[]{Integer.valueOf(i), Integer.valueOf(0)}));
    }
}
