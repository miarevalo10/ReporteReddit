package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzo implements Creator<zzn> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        String str = null;
        boolean z = false;
        IBinder iBinder = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = zzbfn.m5527k(parcel, readInt);
                    break;
                case 2:
                    iBinder = zzbfn.m5528l(parcel, readInt);
                    break;
                case 3:
                    z = zzbfn.m5516b(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzn(str, iBinder, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzn[i];
    }
}
