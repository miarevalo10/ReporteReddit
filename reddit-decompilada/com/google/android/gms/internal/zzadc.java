package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbg;

@zzzv
public final class zzadc extends zzadi {
    private final String f17500a;
    private final int f17501b;

    public zzadc(String str, int i) {
        this.f17500a = str;
        this.f17501b = i;
    }

    public final String mo1659a() {
        return this.f17500a;
    }

    public final int mo1660b() {
        return this.f17501b;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzadc)) {
            return false;
        }
        zzadc com_google_android_gms_internal_zzadc = (zzadc) obj;
        if (zzbg.m4806a(this.f17500a, com_google_android_gms_internal_zzadc.f17500a) && zzbg.m4806a(Integer.valueOf(this.f17501b), Integer.valueOf(com_google_android_gms_internal_zzadc.f17501b))) {
            return true;
        }
        return false;
    }
}
