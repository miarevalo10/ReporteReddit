package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzad implements Creator<LocationSettingsStates> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        boolean z = false;
        boolean z2 = z;
        boolean z3 = z2;
        boolean z4 = z3;
        boolean z5 = z4;
        boolean z6 = z5;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 2:
                    z2 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 3:
                    z3 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 4:
                    z4 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 5:
                    z5 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 6:
                    z6 = zzbfn.m5516b(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new LocationSettingsStates(z, z2, z3, z4, z5, z6);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
