package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzcft implements Creator<zzcfs> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        double d = 0.0d;
        double d2 = d;
        int i = 0;
        short s = i;
        int i2 = s;
        String str = null;
        float f = 0.0f;
        long j = 0;
        int i3 = -1;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 2:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 3:
                    s = zzbfn.m5519c(parcel2, readInt);
                    break;
                case 4:
                    d = zzbfn.m5525i(parcel2, readInt);
                    break;
                case 5:
                    d2 = zzbfn.m5525i(parcel2, readInt);
                    break;
                case 6:
                    f = zzbfn.m5523g(parcel2, readInt);
                    break;
                case 7:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 8:
                    i2 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 9:
                    i3 = zzbfn.m5520d(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new zzcfs(str, i, s, d, d2, f, j, i2, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcfs[i];
    }
}
