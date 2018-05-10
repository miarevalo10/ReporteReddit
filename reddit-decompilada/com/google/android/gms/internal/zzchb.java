package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzchb implements Creator<zzcha> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        zzcgx com_google_android_gms_internal_zzcgx = str;
        String str2 = com_google_android_gms_internal_zzcgx;
        long j = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 3:
                    com_google_android_gms_internal_zzcgx = (zzcgx) zzbfn.m5512a(parcel, readInt, zzcgx.CREATOR);
                    break;
                case 4:
                    str2 = zzbfn.m5527k(parcel, readInt);
                    break;
                case 5:
                    j = zzbfn.m5521e(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzcha(str, com_google_android_gms_internal_zzcgx, str2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcha[i];
    }
}
