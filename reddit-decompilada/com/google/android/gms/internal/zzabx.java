package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

@zzzv
public final class zzabx extends zzbfm {
    public static final Creator<zzabx> CREATOR = new zzaby();
    String f17494a;

    public zzabx(String str) {
        this.f17494a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f17494a);
        zzbfp.m5537a(parcel, i);
    }
}
