package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzim implements Creator<zzil> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        long j = 0;
        long j2 = j;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        Bundle bundle = str4;
        boolean z = false;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 3:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 4:
                    str2 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 5:
                    str3 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 6:
                    str4 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 7:
                    bundle = zzbfn.m5529m(parcel2, readInt);
                    break;
                case 8:
                    z = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 9:
                    j2 = zzbfn.m5521e(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new zzil(str, j, str2, str3, str4, bundle, z, j2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzil[i];
    }
}
