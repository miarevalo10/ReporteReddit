package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzclo implements Creator<zzcln> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        String str = null;
        Long l = str;
        Float f = l;
        String str2 = f;
        String str3 = str2;
        Double d = str3;
        int i = 0;
        long j = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 2:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 3:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 4:
                    l = zzbfn.m5522f(parcel2, readInt);
                    break;
                case 5:
                    f = zzbfn.m5524h(parcel2, readInt);
                    break;
                case 6:
                    str2 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 7:
                    str3 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 8:
                    d = zzbfn.m5526j(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new zzcln(i, str, j, l, f, str2, str3, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcln[i];
    }
}
