package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzcgj implements Creator<zzcgi> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        boolean z = false;
        int i = z;
        boolean z2 = true;
        boolean z3 = z2;
        long j = 0;
        long j2 = j;
        long j3 = j2;
        long j4 = j3;
        String str = null;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        long j5 = -2147483648L;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 3:
                    str2 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 4:
                    str3 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 5:
                    str4 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 6:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 7:
                    j2 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 8:
                    str5 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 9:
                    z2 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 10:
                    z = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 11:
                    j5 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 12:
                    str6 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 13:
                    j3 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 14:
                    j4 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 15:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 16:
                    z3 = zzbfn.m5516b(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new zzcgi(str, str2, str3, str4, j, j2, str5, z2, z, j5, str6, j3, j4, i, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcgi[i];
    }
}
