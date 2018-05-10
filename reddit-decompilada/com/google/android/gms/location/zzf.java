package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;

public final class zzf implements Creator<zze> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a = zzbfn.m5511a(parcel);
        boolean z = true;
        long j = 50;
        float f = 0.0f;
        long j2 = Long.MAX_VALUE;
        int i = RedditJobManager.f10810d;
        while (parcel.dataPosition() < a) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z = zzbfn.m5516b(parcel2, readInt);
                    break;
                case 2:
                    j = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 3:
                    f = zzbfn.m5523g(parcel2, readInt);
                    break;
                case 4:
                    j2 = zzbfn.m5521e(parcel2, readInt);
                    break;
                case 5:
                    i = zzbfn.m5520d(parcel2, readInt);
                    break;
                default:
                    zzbfn.m5513a(parcel2, readInt);
                    break;
            }
        }
        zzbfn.m5534r(parcel2, a);
        return new zze(z, j, f, j2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
