package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class zzcfp implements Creator<zzcfo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        List list = zzcfo.f17735a;
        boolean z = false;
        boolean z2 = z;
        boolean z3 = z2;
        LocationRequest locationRequest = null;
        String str = locationRequest;
        String str2 = str;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i != 1) {
                switch (i) {
                    case 5:
                        list = zzbfn.m5518c(parcel, readInt, zzcdv.CREATOR);
                        break;
                    case 6:
                        str = zzbfn.m5527k(parcel, readInt);
                        break;
                    case 7:
                        z = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 8:
                        z2 = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 9:
                        z3 = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 10:
                        str2 = zzbfn.m5527k(parcel, readInt);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            locationRequest = (LocationRequest) zzbfn.m5512a(parcel, readInt, LocationRequest.CREATOR);
        }
        zzbfn.m5534r(parcel, a);
        return new zzcfo(locationRequest, list, str, z, z2, z3, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcfo[i];
    }
}
