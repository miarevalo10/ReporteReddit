package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzv implements Creator<LocationAvailability> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 1;
        int i2 = i;
        int i3 = 1000;
        long j = 0;
        zzae[] com_google_android_gms_location_zzaeArr = null;
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
                    i3 = zzbfn.m5520d(parcel, readInt);
                    break;
                case 5:
                    com_google_android_gms_location_zzaeArr = (zzae[]) zzbfn.m5517b(parcel, readInt, zzae.CREATOR);
                    break;
                default:
                    zzbfn.m5513a(parcel, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel, a);
        return new LocationAvailability(i3, i, i2, j, com_google_android_gms_location_zzaeArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
