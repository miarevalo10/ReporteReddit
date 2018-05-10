package com.google.android.gms.internal;

import java.security.GeneralSecurityException;

final class zzdqf implements zzdpq {
    public final zzdpw mo1855a(String str, String str2, int i) throws GeneralSecurityException {
        int i2;
        String toLowerCase = str2.toLowerCase();
        int i3 = -1;
        zzdpw com_google_android_gms_internal_zzdqh;
        if (toLowerCase.hashCode() == 2989895) {
            if (toLowerCase.equals("aead")) {
                i2 = 0;
                if (i2 == 0) {
                    throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
                }
                switch (str.hashCode()) {
                    case 360753376:
                        if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                            i3 = 3;
                            break;
                        }
                        break;
                    case 1215885937:
                        if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                            i3 = 0;
                            break;
                        }
                        break;
                    case 1469984853:
                        if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                            i3 = 4;
                            break;
                        }
                        break;
                    case 1797113348:
                        if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                            i3 = 1;
                            break;
                        }
                        break;
                    case 1855890991:
                        if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                            i3 = 2;
                            break;
                        }
                        break;
                    case 2079211877:
                        if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                            i3 = 5;
                            break;
                        }
                        break;
                    default:
                        break;
                }
                switch (i3) {
                    case 0:
                        com_google_android_gms_internal_zzdqh = new zzdqh();
                        break;
                    case 1:
                        com_google_android_gms_internal_zzdqh = new zzdqj();
                        break;
                    case 2:
                        com_google_android_gms_internal_zzdqh = new zzdqk();
                        break;
                    case 3:
                        com_google_android_gms_internal_zzdqh = new zzdql();
                        break;
                    case 4:
                        com_google_android_gms_internal_zzdqh = new zzdqm();
                        break;
                    case 5:
                        com_google_android_gms_internal_zzdqh = new zzdqo();
                        break;
                    default:
                        throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", new Object[]{str}));
                }
                if (i > 0) {
                    return com_google_android_gms_internal_zzdqh;
                }
                throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
            }
        }
        i2 = -1;
        if (i2 == 0) {
            switch (str.hashCode()) {
                case 360753376:
                    if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                        i3 = 3;
                        break;
                    }
                    break;
                case 1215885937:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                        i3 = 0;
                        break;
                    }
                    break;
                case 1469984853:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                        i3 = 4;
                        break;
                    }
                    break;
                case 1797113348:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                        i3 = 1;
                        break;
                    }
                    break;
                case 1855890991:
                    if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                        i3 = 2;
                        break;
                    }
                    break;
                case 2079211877:
                    if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                        i3 = 5;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (i3) {
                case 0:
                    com_google_android_gms_internal_zzdqh = new zzdqh();
                    break;
                case 1:
                    com_google_android_gms_internal_zzdqh = new zzdqj();
                    break;
                case 2:
                    com_google_android_gms_internal_zzdqh = new zzdqk();
                    break;
                case 3:
                    com_google_android_gms_internal_zzdqh = new zzdql();
                    break;
                case 4:
                    com_google_android_gms_internal_zzdqh = new zzdqm();
                    break;
                case 5:
                    com_google_android_gms_internal_zzdqh = new zzdqo();
                    break;
                default:
                    throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", new Object[]{str}));
            }
            if (i > 0) {
                return com_google_android_gms_internal_zzdqh;
            }
            throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", new Object[]{str, Integer.valueOf(i)}));
        }
        throw new GeneralSecurityException(String.format("No support for primitive '%s'.", new Object[]{str2}));
    }
}
