package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzadw implements Creator<zzadv> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        zzjj com_google_android_gms_internal_zzjj = null;
        String str = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    com_google_android_gms_internal_zzjj = (zzjj) zzbfn.m5512a(parcel, readInt, zzjj.CREATOR);
                    break;
                case 3:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzadv(com_google_android_gms_internal_zzjj, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzadv[i];
    }
}
