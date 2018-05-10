package com.google.android.gms.internal;

import java.security.GeneralSecurityException;

final class zzdqr implements zzdpq {
    public final zzdpw mo1855a(String str, String str2, int i) throws GeneralSecurityException {
        int i2;
        zzdpw com_google_android_gms_internal_zzdqp;
        String toLowerCase = str2.toLowerCase();
        int hashCode = toLowerCase.hashCode();
        int i3 = -1;
        if (hashCode != 275448849) {
            if (hashCode == 1420614889) {
                if (toLowerCase.equals("hybridencrypt")) {
                    i2 = 1;
                    switch (i2) {
                        case 0:
                            if (str.hashCode() != -80133005) {
                                if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
                                    i3 = 0;
                                }
                            }
                            if (i3 != 0) {
                                com_google_android_gms_internal_zzdqp = new zzdqp();
                                break;
                            }
                            throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
                        case 1:
                            if (str.hashCode() != 396454335) {
                                if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                                    i3 = 0;
                                }
                            }
                            if (i3 != 0) {
                                com_google_android_gms_internal_zzdqp = new zzdqq();
                                break;
                            }
                            throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
                        default:
                            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
                    }
                    if (i > 0) {
                        return com_google_android_gms_internal_zzdqp;
                    }
                    throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
                }
            }
        } else if (toLowerCase.equals("hybriddecrypt")) {
            i2 = 0;
            switch (i2) {
                case 0:
                    if (str.hashCode() != -80133005) {
                        if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        com_google_android_gms_internal_zzdqp = new zzdqp();
                        break;
                    }
                    throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
                case 1:
                    if (str.hashCode() != 396454335) {
                        if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                            i3 = 0;
                        }
                    }
                    if (i3 != 0) {
                        com_google_android_gms_internal_zzdqp = new zzdqq();
                        break;
                    }
                    throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
                default:
                    throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
            }
            if (i > 0) {
                return com_google_android_gms_internal_zzdqp;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        i2 = -1;
        switch (i2) {
            case 0:
                if (str.hashCode() != -80133005) {
                    if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey")) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    com_google_android_gms_internal_zzdqp = new zzdqp();
                    break;
                }
                throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
            case 1:
                if (str.hashCode() != 396454335) {
                    if (str.equals("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    com_google_android_gms_internal_zzdqp = new zzdqq();
                    break;
                }
                throw new GeneralSecurityException(String.format("No support for primitive 'HybridEncrypt' with key type '%s'.", new Object[]{str}));
            default:
                throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
        }
        if (i > 0) {
            return com_google_android_gms_internal_zzdqp;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
    }
}
