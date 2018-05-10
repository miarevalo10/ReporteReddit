package com.google.android.gms.internal;

public final class zzhy {
    final long f7709a;
    final String f7710b;
    final int f7711c;

    zzhy(long j, String str, int i) {
        this.f7709a = j;
        this.f7710b = str;
        this.f7711c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzhy)) {
            return false;
        }
        zzhy com_google_android_gms_internal_zzhy = (zzhy) obj;
        if (com_google_android_gms_internal_zzhy.f7709a == this.f7709a && com_google_android_gms_internal_zzhy.f7711c == this.f7711c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.f7709a;
    }
}
