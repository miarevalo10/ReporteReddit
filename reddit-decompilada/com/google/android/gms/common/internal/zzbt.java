package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzbt extends zzbfm {
    public static final Creator<zzbt> CREATOR = new zzbu();
    public ConnectionResult f17333a;
    public boolean f17334b;
    public boolean f17335c;
    private int f17336d;
    private IBinder f17337e;

    zzbt(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f17336d = i;
        this.f17337e = iBinder;
        this.f17333a = connectionResult;
        this.f17334b = z;
        this.f17335c = z2;
    }

    public final zzan m17680a() {
        IBinder iBinder = this.f17337e;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        return queryLocalInterface instanceof zzan ? (zzan) queryLocalInterface : new zzap(iBinder);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbt)) {
            return false;
        }
        zzbt com_google_android_gms_common_internal_zzbt = (zzbt) obj;
        return this.f17333a.equals(com_google_android_gms_common_internal_zzbt.f17333a) && m17680a().equals(com_google_android_gms_common_internal_zzbt.m17680a());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17336d);
        zzbfp.m5543a(parcel, 2, this.f17337e);
        zzbfp.m5544a(parcel, 3, this.f17333a, i);
        zzbfp.m5547a(parcel, 4, this.f17334b);
        zzbfp.m5547a(parcel, 5, this.f17335c);
        zzbfp.m5537a(parcel, a);
    }
}
