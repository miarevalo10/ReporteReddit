package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;

public final class zzg implements Creator<Status> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a = zzbfn.m5511a(parcel);
        int i = 0;
        String str = null;
        PendingIntent pendingIntent = str;
        int i2 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 != 1000) {
                switch (i3) {
                    case 1:
                        i2 = zzbfn.m5520d(parcel, readInt);
                        break;
                    case 2:
                        str = zzbfn.m5527k(parcel, readInt);
                        break;
                    case 3:
                        pendingIntent = (PendingIntent) zzbfn.m5512a(parcel, readInt, PendingIntent.CREATOR);
                        break;
                    default:
                        zzbfn.m5513a(parcel, readInt);
                        break;
                }
            }
            i = zzbfn.m5520d(parcel, readInt);
        }
        zzbfn.m5534r(parcel, a);
        return new Status(i, i2, str, pendingIntent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Status[i];
    }
}
