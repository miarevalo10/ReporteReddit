package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzc extends zzbfm {
    public static final Creator<zzc> CREATOR = new zzd();
    private String f17352a;
    private int f17353b;

    public zzc(String str, int i) {
        this.f17352a = str;
        this.f17353b = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 1, this.f17352a);
        zzbfp.m5540a(parcel, 2, this.f17353b);
        zzbfp.m5537a(parcel, i);
    }
}
