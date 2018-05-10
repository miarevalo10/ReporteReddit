package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

public final class zzah {
    final String f5879a;
    final ComponentName f5880b = null;
    final int f5881c;
    private final String f5882d;

    public zzah(String str, String str2, int i) {
        this.f5882d = zzbq.m4810a(str);
        this.f5879a = zzbq.m4810a(str2);
        this.f5881c = i;
    }

    public final Intent m4786a() {
        return this.f5882d != null ? new Intent(this.f5882d).setPackage(this.f5879a) : new Intent().setComponent(this.f5880b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah com_google_android_gms_common_internal_zzah = (zzah) obj;
        return zzbg.m4806a(this.f5882d, com_google_android_gms_common_internal_zzah.f5882d) && zzbg.m4806a(this.f5879a, com_google_android_gms_common_internal_zzah.f5879a) && zzbg.m4806a(this.f5880b, com_google_android_gms_common_internal_zzah.f5880b) && this.f5881c == com_google_android_gms_common_internal_zzah.f5881c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5882d, this.f5879a, this.f5880b, Integer.valueOf(this.f5881c)});
    }

    public final String toString() {
        return this.f5882d == null ? this.f5880b.flattenToString() : this.f5882d;
    }
}
