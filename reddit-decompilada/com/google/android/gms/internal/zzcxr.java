package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbt;

public final class zzcxr implements Creator<zzcxq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        zzbt com_google_android_gms_common_internal_zzbt = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    connectionResult = (ConnectionResult) zzbfn.m5512a(parcel, readInt, ConnectionResult.CREATOR);
                    break;
                case 3:
                    com_google_android_gms_common_internal_zzbt = (zzbt) zzbfn.m5512a(parcel, readInt, zzbt.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzcxq(i, connectionResult, com_google_android_gms_common_internal_zzbt);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcxq[i];
    }
}
