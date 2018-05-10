package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.search.SearchAdRequest;

@zzzv
public final class zzmn extends zzbfm {
    public static final Creator<zzmn> CREATOR = new zzmo();
    public final String f18169a;

    public zzmn(SearchAdRequest searchAdRequest) {
        this.f18169a = searchAdRequest.getQuery();
    }

    zzmn(String str) {
        this.f18169a = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 15, this.f18169a);
        zzbfp.m5537a(parcel, i);
    }
}
