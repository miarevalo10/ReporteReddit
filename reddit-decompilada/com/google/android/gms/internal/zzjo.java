package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzjo implements Creator<zzjn> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        zzjn[] com_google_android_gms_internal_zzjnArr = str;
        int i = 0;
        int i2 = i;
        boolean z = i2;
        int i3 = z;
        int i4 = i3;
        boolean z2 = i4;
        boolean z3 = z2;
        boolean z4 = z3;
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
                    i3 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 7:
                    i4 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 8:
                    com_google_android_gms_internal_zzjnArr = (zzjn[]) zzbfn.m5517b(parcel, readInt, zzjn.CREATOR);
                    break;
                case 9:
                    z2 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 10:
                    z3 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 11:
                    z4 = zzbfn.m5516b(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzjn(str, i, i2, z, i3, i4, com_google_android_gms_internal_zzjnArr, z2, z3, z4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzjn[i];
    }
}
