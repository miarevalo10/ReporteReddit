package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzaby implements Creator<zzabx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                zzbfn.m5513a(parcel, readInt);
            } else {
                str = zzbfn.m5527k(parcel, readInt);
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzabx(str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzabx[i];
    }
}
