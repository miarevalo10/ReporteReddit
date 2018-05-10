package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

public final class zzait {
    public final String f6427a;
    public final double f6428b;
    public final int f6429c;
    private double f6430d;
    private double f6431e;

    public zzait(String str, double d, double d2, double d3, int i) {
        this.f6427a = str;
        this.f6431e = d;
        this.f6430d = d2;
        this.f6428b = d3;
        this.f6429c = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzait)) {
            return false;
        }
        zzait com_google_android_gms_internal_zzait = (zzait) obj;
        return zzbg.m4806a(this.f6427a, com_google_android_gms_internal_zzait.f6427a) && this.f6430d == com_google_android_gms_internal_zzait.f6430d && this.f6431e == com_google_android_gms_internal_zzait.f6431e && this.f6429c == com_google_android_gms_internal_zzait.f6429c && Double.compare(this.f6428b, com_google_android_gms_internal_zzait.f6428b) == 0;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6427a, Double.valueOf(this.f6430d), Double.valueOf(this.f6431e), Double.valueOf(this.f6428b), Integer.valueOf(this.f6429c)});
    }

    public final String toString() {
        return zzbg.m4805a(this).m4807a("name", this.f6427a).m4807a("minBound", Double.valueOf(this.f6431e)).m4807a("maxBound", Double.valueOf(this.f6430d)).m4807a("percent", Double.valueOf(this.f6428b)).m4807a("count", Integer.valueOf(this.f6429c)).toString();
    }
}
