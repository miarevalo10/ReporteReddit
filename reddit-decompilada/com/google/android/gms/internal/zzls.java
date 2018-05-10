package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzls implements Creator<zzlr> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                zzbfn.m5513a(parcel, readInt);
            } else {
                i = zzbfn.m5520d(parcel, readInt);
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzlr(i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzlr[i];
    }
}
