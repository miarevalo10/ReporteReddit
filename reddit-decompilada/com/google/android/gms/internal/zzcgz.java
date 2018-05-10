package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzcgz implements Creator<zzcgx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                zzbfn.m5513a(parcel, readInt);
            } else {
                bundle = zzbfn.m5529m(parcel, readInt);
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzcgx(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcgx[i];
    }
}
