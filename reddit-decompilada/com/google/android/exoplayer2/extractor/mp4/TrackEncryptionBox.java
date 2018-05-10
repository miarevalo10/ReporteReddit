package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;

public final class TrackEncryptionBox {
    public final boolean f4464a;
    public final String f4465b;
    public final CryptoData f4466c;
    public final int f4467d;
    public final byte[] f4468e;

    public TrackEncryptionBox(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        int i4 = 0;
        int i5 = 1;
        Assertions.m4184a((i == 0 ? 1 : 0) ^ (bArr2 == null ? 1 : 0));
        this.f4464a = z;
        this.f4465b = str;
        this.f4467d = i;
        this.f4468e = bArr2;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == 3046605) {
                if (str.equals("cbc1")) {
                    i4 = 2;
                    switch (i4) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                        case 3:
                            i5 = 2;
                            break;
                        default:
                            bArr2 = new StringBuilder("Unsupported protection scheme type '");
                            bArr2.append(str);
                            bArr2.append("'. Assuming AES-CTR crypto mode.");
                            Log.w("TrackEncryptionBox", bArr2.toString());
                            break;
                    }
                }
            } else if (hashCode == 3046671) {
                if (str.equals("cbcs")) {
                    i4 = 3;
                    switch (i4) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                        case 3:
                            i5 = 2;
                            break;
                        default:
                            bArr2 = new StringBuilder("Unsupported protection scheme type '");
                            bArr2.append(str);
                            bArr2.append("'. Assuming AES-CTR crypto mode.");
                            Log.w("TrackEncryptionBox", bArr2.toString());
                            break;
                    }
                }
            } else if (hashCode == 3049879) {
                if (str.equals("cenc")) {
                    switch (i4) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                        case 3:
                            i5 = 2;
                            break;
                        default:
                            bArr2 = new StringBuilder("Unsupported protection scheme type '");
                            bArr2.append(str);
                            bArr2.append("'. Assuming AES-CTR crypto mode.");
                            Log.w("TrackEncryptionBox", bArr2.toString());
                            break;
                    }
                }
            } else if (hashCode == 3049895) {
                if (str.equals("cens")) {
                    i4 = 1;
                    switch (i4) {
                        case 0:
                        case 1:
                            break;
                        case 2:
                        case 3:
                            i5 = 2;
                            break;
                        default:
                            bArr2 = new StringBuilder("Unsupported protection scheme type '");
                            bArr2.append(str);
                            bArr2.append("'. Assuming AES-CTR crypto mode.");
                            Log.w("TrackEncryptionBox", bArr2.toString());
                            break;
                    }
                }
            }
            i4 = -1;
            switch (i4) {
                case 0:
                case 1:
                    break;
                case 2:
                case 3:
                    i5 = 2;
                    break;
                default:
                    bArr2 = new StringBuilder("Unsupported protection scheme type '");
                    bArr2.append(str);
                    bArr2.append("'. Assuming AES-CTR crypto mode.");
                    Log.w("TrackEncryptionBox", bArr2.toString());
                    break;
            }
        }
        this.f4466c = new CryptoData(i5, bArr, i2, i3);
    }
}
