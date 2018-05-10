package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzms implements Creator<zzmr> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = z2;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 3:
                    z2 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 4:
                    z3 = zzbfn.m5516b(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzmr(z, z2, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzmr[i];
    }
}
