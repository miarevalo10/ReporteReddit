package com.google.android.gms.internal;

import java.security.GeneralSecurityException;

final class zzdra implements zzdpq {
    public final zzdpw mo1855a(String str, String str2, int i) throws GeneralSecurityException {
        int i2;
        String toLowerCase = str2.toLowerCase();
        int i3 = -1;
        zzdpw com_google_android_gms_internal_zzdqy;
        if (toLowerCase.hashCode() == 107855) {
            if (toLowerCase.equals("mac")) {
                i2 = 0;
                if (i2 == 0) {
                    throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
                }
                if (str.hashCode() != 836622442) {
                    if (str.equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                        i3 = 0;
                    }
                }
                if (i3 == 0) {
                    throw new GeneralSecurityException(String.format("No support for primitive 'Mac' with key type '%s'.", new Object[]{str}));
                }
                com_google_android_gms_internal_zzdqy = new zzdqy();
                if (i > 0) {
                    return com_google_android_gms_internal_zzdqy;
                }
                throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
            }
        }
        i2 = -1;
        if (i2 == 0) {
            if (str.hashCode() != 836622442) {
                if (str.equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                com_google_android_gms_internal_zzdqy = new zzdqy();
                if (i > 0) {
                    return com_google_android_gms_internal_zzdqy;
                }
                throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
            }
            throw new GeneralSecurityException(String.format("No support for primitive 'Mac' with key type '%s'.", new Object[]{str}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }
}
