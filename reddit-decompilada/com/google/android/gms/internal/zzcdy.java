package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.zze;
import java.util.List;

public final class zzcdy implements Creator<zzcdx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        zze com_google_android_gms_location_zze = zzcdx.f17719b;
        List list = zzcdx.f17718a;
        String str = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    com_google_android_gms_location_zze = (zze) zzbfn.m5512a(parcel, readInt, zze.CREATOR);
                    break;
                case 2:
                    list = zzbfn.m5518c(parcel, readInt, zzcdv.CREATOR);
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
        return new zzcdx(com_google_android_gms_location_zze, list, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcdx[i];
    }
}
