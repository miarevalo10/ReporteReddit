package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.Arrays;

@zzzv
final class zzth {
    private final Object[] f8006a;

    zzth(zzjj com_google_android_gms_internal_zzjj, String str, int i) {
        this.f8006a = zzp.m4516a((String) zzkb.m6350f().m6488a(zznh.aH), com_google_android_gms_internal_zzjj, str, i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzth)) {
            return false;
        }
        return Arrays.equals(this.f8006a, ((zzth) obj).f8006a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f8006a);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f8006a);
        StringBuilder stringBuilder = new StringBuilder(24 + String.valueOf(arrays).length());
        stringBuilder.append("[InterstitialAdPoolKey ");
        stringBuilder.append(arrays);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
