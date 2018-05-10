package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzcxh implements Creator<zzcxg> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 3:
                    intent = (Intent) zzbfn.m5512a(parcel, readInt, Intent.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzcxg(i, i2, intent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcxg[i];
    }
}
