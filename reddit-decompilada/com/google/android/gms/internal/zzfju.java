package com.google.android.gms.internal;

import java.util.Arrays;

final class zzfju {
    final int f7557a;
    final byte[] f7558b;

    zzfju(int i, byte[] bArr) {
        this.f7557a = i;
        this.f7558b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfju)) {
            return false;
        }
        zzfju com_google_android_gms_internal_zzfju = (zzfju) obj;
        return this.f7557a == com_google_android_gms_internal_zzfju.f7557a && Arrays.equals(this.f7558b, com_google_android_gms_internal_zzfju.f7558b);
    }

    public final int hashCode() {
        return ((527 + this.f7557a) * 31) + Arrays.hashCode(this.f7558b);
    }
}
