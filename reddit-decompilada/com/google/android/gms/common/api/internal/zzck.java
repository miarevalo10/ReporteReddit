package com.google.android.gms.common.api.internal;

public final class zzck<L> {
    private final L f5814a;
    private final String f5815b;

    zzck(L l, String str) {
        this.f5814a = l;
        this.f5815b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzck)) {
            return false;
        }
        zzck com_google_android_gms_common_api_internal_zzck = (zzck) obj;
        return this.f5814a == com_google_android_gms_common_api_internal_zzck.f5814a && this.f5815b.equals(com_google_android_gms_common_api_internal_zzck.f5815b);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f5814a) * 31) + this.f5815b.hashCode();
    }
}
