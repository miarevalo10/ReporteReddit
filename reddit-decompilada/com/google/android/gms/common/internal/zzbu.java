package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbfn;

public final class zzbu implements Creator<zzbt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = iBinder;
        int i = 0;
        boolean z = i;
        boolean z2 = z;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    iBinder = zzbfn.m5528l(parcel, readInt);
                    break;
                case 3:
                    connectionResult = (ConnectionResult) zzbfn.m5512a(parcel, readInt, ConnectionResult.CREATOR);
                    break;
                case 4:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbfn.m5516b(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzbt(i, iBinder, connectionResult, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbt[i];
    }
}
