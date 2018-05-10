package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class zzae extends zzbfm {
    public static final Creator<zzae> CREATOR = new zzaf();
    private int f18390a;
    private int f18391b;
    private long f18392c;
    private long f18393d;

    zzae(int i, int i2, long j, long j2) {
        this.f18390a = i;
        this.f18391b = i2;
        this.f18392c = j;
        this.f18393d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzae com_google_android_gms_location_zzae = (zzae) obj;
        return this.f18390a == com_google_android_gms_location_zzae.f18390a && this.f18391b == com_google_android_gms_location_zzae.f18391b && this.f18392c == com_google_android_gms_location_zzae.f18392c && this.f18393d == com_google_android_gms_location_zzae.f18393d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f18391b), Integer.valueOf(this.f18390a), Long.valueOf(this.f18393d), Long.valueOf(this.f18392c)});
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NetworkLocationStatus:");
        stringBuilder.append(" Wifi status: ");
        stringBuilder.append(this.f18390a);
        stringBuilder.append(" Cell status: ");
        stringBuilder.append(this.f18391b);
        stringBuilder.append(" elapsed time NS: ");
        stringBuilder.append(this.f18393d);
        stringBuilder.append(" system time ms: ");
        stringBuilder.append(this.f18392c);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f18390a);
        zzbfp.m5540a(parcel, 2, this.f18391b);
        zzbfp.m5541a(parcel, 3, this.f18392c);
        zzbfp.m5541a(parcel, 4, this.f18393d);
        zzbfp.m5537a(parcel, i);
    }
}
