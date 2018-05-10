package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzake implements Creator<zzakd> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        int i2 = i;
        boolean z = i2;
        boolean z2 = z;
        String str = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 3:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 5:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 6:
                    z2 = zzbfn.m5516b(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzakd(str, i, i2, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzakd[i];
    }
}
