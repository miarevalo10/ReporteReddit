package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbt;

public final class zzcxq extends zzbfm {
    public static final Creator<zzcxq> CREATOR = new zzcxr();
    public final ConnectionResult f18032a;
    public final zzbt f18033b;
    private int f18034c;

    public zzcxq() {
        this(new ConnectionResult(8, null));
    }

    zzcxq(int i, ConnectionResult connectionResult, zzbt com_google_android_gms_common_internal_zzbt) {
        this.f18034c = i;
        this.f18032a = connectionResult;
        this.f18033b = com_google_android_gms_common_internal_zzbt;
    }

    private zzcxq(ConnectionResult connectionResult) {
        this(1, connectionResult, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f18034c);
        zzbfp.m5544a(parcel, 2, this.f18032a, i);
        zzbfp.m5544a(parcel, 3, this.f18033b, i);
        zzbfp.m5537a(parcel, a);
    }
}
