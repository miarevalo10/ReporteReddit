package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzcbp extends zzbfm {
    public static final Creator<zzcbp> CREATOR = new zzcbq();
    private int f17710a;
    private String f17711b;
    private String f17712c;

    zzcbp(int i, String str, String str2) {
        this.f17710a = i;
        this.f17711b = str;
        this.f17712c = str2;
    }

    public zzcbp(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17710a);
        zzbfp.m5545a(parcel, 2, this.f17711b);
        zzbfp.m5545a(parcel, 3, this.f17712c);
        zzbfp.m5537a(parcel, i);
    }
}
