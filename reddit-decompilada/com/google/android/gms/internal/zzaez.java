package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class zzaez implements Creator<zzaey> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        String str2 = str;
        List list = str2;
        boolean z = false;
        boolean z2 = z;
        boolean z3 = z2;
        boolean z4 = z3;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 4:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 6:
                    list = zzbfn.m5533q(parcel, readInt);
                    break;
                case 7:
                    z3 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 8:
                    z4 = zzbfn.m5516b(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzaey(str, str2, z, z2, list, z3, z4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaey[i];
    }
}
