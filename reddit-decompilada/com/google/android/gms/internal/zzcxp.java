package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbr;

public final class zzcxp implements Creator<zzcxo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        zzbr com_google_android_gms_common_internal_zzbr = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    com_google_android_gms_common_internal_zzbr = (zzbr) zzbfn.m5512a(parcel, readInt, zzbr.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzcxo(i, com_google_android_gms_common_internal_zzbr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcxo[i];
    }
}
