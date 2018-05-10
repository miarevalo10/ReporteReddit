package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbr;

public final class zzcxo extends zzbfm {
    public static final Creator<zzcxo> CREATOR = new zzcxp();
    private int f18030a;
    private zzbr f18031b;

    zzcxo(int i, zzbr com_google_android_gms_common_internal_zzbr) {
        this.f18030a = i;
        this.f18031b = com_google_android_gms_common_internal_zzbr;
    }

    public zzcxo(zzbr com_google_android_gms_common_internal_zzbr) {
        this(1, com_google_android_gms_common_internal_zzbr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f18030a);
        zzbfp.m5544a(parcel, 2, this.f18031b, i);
        zzbfp.m5537a(parcel, a);
    }
}
