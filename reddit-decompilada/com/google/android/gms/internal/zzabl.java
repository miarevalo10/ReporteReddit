package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;

public final class zzabl implements Creator<zzabj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                zzbfn.m5513a(parcel, readInt);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) zzbfn.m5512a(parcel, readInt, ParcelFileDescriptor.CREATOR);
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzabj(parcelFileDescriptor);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzabj[i];
    }
}
