package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzmo implements Creator<zzmn> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 15) {
                zzbfn.m5513a(parcel, readInt);
            } else {
                str = zzbfn.m5527k(parcel, readInt);
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzmn(str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzmn[i];
    }
}
