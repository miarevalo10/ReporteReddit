package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzcea implements Creator<zzcdz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        zzcdx com_google_android_gms_internal_zzcdx = null;
        int i = 1;
        IBinder iBinder = null;
        IBinder iBinder2 = iBinder;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    com_google_android_gms_internal_zzcdx = (zzcdx) zzbfn.m5512a(parcel, readInt, zzcdx.CREATOR);
                    break;
                case 3:
                    iBinder = zzbfn.m5528l(parcel, readInt);
                    break;
                case 4:
                    iBinder2 = zzbfn.m5528l(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzcdz(i, com_google_android_gms_internal_zzcdx, iBinder, iBinder2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcdz[i];
    }
}
