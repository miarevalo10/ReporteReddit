package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

@zzzv
public final class zzadv extends zzbfm {
    public static final Creator<zzadv> CREATOR = new zzadw();
    public final zzjj f17507a;
    public final String f17508b;

    public zzadv(zzjj com_google_android_gms_internal_zzjj, String str) {
        this.f17507a = com_google_android_gms_internal_zzjj;
        this.f17508b = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5544a(parcel, 2, this.f17507a, i);
        zzbfp.m5545a(parcel, 3, this.f17508b);
        zzbfp.m5537a(parcel, a);
    }
}
