package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzpf implements Creator<zzpe> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        boolean z = i;
        int i2 = z;
        boolean z2 = i2;
        int i3 = z2;
        zzmr com_google_android_gms_internal_zzmr = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                case 3:
                    i2 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 4:
                    z2 = zzbfn.m5516b(parcel, readInt);
                    break;
                case 5:
                    i3 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 6:
                    com_google_android_gms_internal_zzmr = (zzmr) zzbfn.m5512a(parcel, readInt, zzmr.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzpe(i, z, i2, z2, i3, com_google_android_gms_internal_zzmr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzpe[i];
    }
}
