package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzrs implements Creator<zzrr> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        String[] strArr = null;
        String[] strArr2 = strArr;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 2:
                    strArr = zzbfn.m5531o(parcel, readInt);
                    break;
                case 3:
                    strArr2 = zzbfn.m5531o(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzrr(str, strArr, strArr2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzrr[i];
    }
}
