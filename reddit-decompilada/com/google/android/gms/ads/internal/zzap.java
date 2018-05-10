package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzap implements Creator<zzao> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        boolean z = false;
        boolean z2 = z;
        boolean z3 = z2;
        int i = z3;
        boolean z4 = i;
        boolean z5 = z4;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 3:
                    z2 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 4:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 5:
                    z3 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 6:
                    f = zzbfn.m5523g(parcel, readInt);
                    break;
                case 7:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 8:
                    z4 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 9:
                    z5 = zzbfn.m5516b(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzao(z, z2, str, z3, f, i, z4, z5);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzao[i];
    }
}
