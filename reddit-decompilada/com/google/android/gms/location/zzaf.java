package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzaf implements Creator<zzae> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        long j = -1;
        long j2 = j;
        int i = 1;
        int i2 = i;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 3:
                    j = zzbfn.m5521e(parcel, readInt);
                    break;
                case 4:
                    j2 = zzbfn.m5521e(parcel, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new zzae(i, i2, j, j2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzae[i];
    }
}
