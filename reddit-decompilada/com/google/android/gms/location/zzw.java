package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public final class zzw implements Creator<LocationRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        int i = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i2 = RedditJobManager.f10810d;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 2:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 3:
                    j2 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 4:
                    z = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 5:
                    j3 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 6:
                    i2 = zzbfn.m5520d(parcel2, readInt);
                    break;
                case 7:
                    f = zzbfn.m5523g(parcel2, readInt);
                    break;
                case 8:
                    j4 = zzbfn.m5521e(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new LocationRequest(i, j, j2, z, j3, i2, f, j4);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationRequest[i];
    }
}
