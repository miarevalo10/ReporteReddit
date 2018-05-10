package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzab implements Creator<LocationSettingsRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        boolean z = false;
        List list = null;
        boolean z2 = false;
        zzz com_google_android_gms_location_zzz = null;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i != 5) {
                switch (i) {
                    case 1:
                        list = zzbfn.m5518c(parcel, readInt, LocationRequest.CREATOR);
                        break;
                    case 2:
                        z = zzbfn.m5516b(parcel, readInt);
                        break;
                    case 3:
                        z2 = zzbfn.m5516b(parcel, readInt);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            com_google_android_gms_location_zzz = (zzz) zzbfn.m5512a(parcel, readInt, zzz.CREATOR);
        }
        zzbfn.m5534r(parcel, a);
        return new LocationSettingsRequest(list, z, z2, com_google_android_gms_location_zzz);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
