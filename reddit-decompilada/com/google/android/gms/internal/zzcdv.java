package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;

public final class zzcdv extends zzbfm {
    public static final Creator<zzcdv> CREATOR = new zzcdw();
    private int f17716a;
    private String f17717b;

    public zzcdv(int i, String str) {
        this.f17716a = i;
        this.f17717b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof zzcdv)) {
            return false;
        }
        zzcdv com_google_android_gms_internal_zzcdv = (zzcdv) obj;
        return com_google_android_gms_internal_zzcdv.f17716a == this.f17716a && zzbg.m4806a(com_google_android_gms_internal_zzcdv.f17717b, this.f17717b);
    }

    public final int hashCode() {
        return this.f17716a;
    }

    public final String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.f17716a), this.f17717b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17716a);
        zzbfp.m5545a(parcel, 2, this.f17717b);
        zzbfp.m5537a(parcel, i);
    }
}
