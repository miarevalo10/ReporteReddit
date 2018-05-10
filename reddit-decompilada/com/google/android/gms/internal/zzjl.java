package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.List;

public final class zzjl implements Creator<zzjj> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        int i2 = i;
        boolean z = i2;
        int i3 = z;
        boolean z2 = i3;
        boolean z3 = z2;
        Bundle bundle = null;
        List list = bundle;
        String str = list;
        zzmn com_google_android_gms_internal_zzmn = str;
        Location location = com_google_android_gms_internal_zzmn;
        String str2 = location;
        Bundle bundle2 = str2;
        Bundle bundle3 = bundle2;
        List list2 = bundle3;
        String str3 = list2;
        String str4 = str3;
        long j = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 2:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 3:
                    bundle = zzbfn.m5529m(parcel2, readInt);
                    break;
                case 4:
                    i2 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 5:
                    list = zzbfn.m5533q(parcel2, readInt);
                    break;
                case 6:
                    z = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 7:
                    i3 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 8:
                    z2 = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 9:
                    str = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 10:
                    com_google_android_gms_internal_zzmn = (zzmn) zzbfn.m5512a(parcel2, readInt, zzmn.CREATOR);
                    break;
                case 11:
                    location = (Location) zzbfn.m5512a(parcel2, readInt, Location.CREATOR);
                    break;
                case 12:
                    str2 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 13:
                    bundle2 = zzbfn.m5529m(parcel2, readInt);
                    break;
                case 14:
                    bundle3 = zzbfn.m5529m(parcel2, readInt);
                    break;
                case 15:
                    list2 = zzbfn.m5533q(parcel2, readInt);
                    break;
                case 16:
                    str3 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 17:
                    str4 = zzbfn.m5527k(parcel2, readInt);
                    break;
                case 18:
                    z3 = zzbfn.m5516b(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new zzjj(i, j, bundle, i2, list, z, i3, z2, str, com_google_android_gms_internal_zzmn, location, str2, bundle2, bundle3, list2, str3, str4, z3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzjj[i];
    }
}
