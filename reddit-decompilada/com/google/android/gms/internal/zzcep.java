package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

public final class zzcep implements Creator<zzceo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        Status status = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                zzbfn.m5513a(parcel, readInt);
            } else {
                status = (Status) zzbfn.m5512a(parcel, readInt, Status.CREATOR);
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzceo(status);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzceo[i];
    }
}
